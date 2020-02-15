package example.service.user

import java.security.MessageDigest;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.apache.commons.lang3.RandomStringUtils;
import example.entity.PersonalInformation
import example.repository.PersonalInformationRepository
import example.repository.UserRepository
import example.entity.User
import example.util.Request
import example.util.Response

@Service
class UserCreateService {
  @Autowired
  lateinit var userRepository: UserRepository

  @Autowired
  lateinit var personalInformationRepository: PersonalInformationRepository

  // salt変換 -> あとで共通化
  fun hash(str: String): String {
    val bytes = str.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("", { str, it -> str + "%02x".format(it) }).toUpperCase()
  }

  // メインロジック
  fun execute(req: Request): Response {
    val salt: String = RandomStringUtils.randomAlphanumeric(8)
    val createDataByUser: User = User(null, "${req.login_name}", "${req.password + hash(salt)}", salt, true)
    var result: Boolean = userRepository.createUser(createDataByUser)
    if (!result) {
      Response("error", "", "E006")
    }
    val userId: Int = userRepository.getNewUserId()
    val age: Int = Integer.parseInt("${req.age}")
    val createDataByPersonalInformation: PersonalInformation =
      PersonalInformation(
        null, userId, "${req.first_name}", "${req.last_name}", "${req.first_phonetic}",
        "${req.last_phonetic}","${req.gender}", "${req.email}", age,
        "${req.birthplace}", "${req.hire_date}", "${req.rool}", "${req.tel}"
      )
    result = personalInformationRepository.createUser(createDataByPersonalInformation)
    if (!result) {
      return Response("error", "", "E007")
    } else {
      return Response("success", result)
    }
  }
}
