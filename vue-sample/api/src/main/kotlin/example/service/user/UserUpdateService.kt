package example.service.user

import kotlin.collections.List
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import example.entity.PersonalInformation
import example.repository.PersonalInformationRepository
import example.util.Response
import example.util.Request

@Service
class UserUpdateService {
  @Autowired
  lateinit var personalInformationRepository: PersonalInformationRepository

  // メインロジック
  fun execute(req: Request): Response {
    val userId: Int = Integer.parseInt("${req.user_id}")
    val age: Int = Integer.parseInt("${req.age}")
    val createDataByPersonalInformation: PersonalInformation =
      PersonalInformation(
        null, userId, "${req.first_name}", "${req.last_name}", "${req.first_phonetic}",
        "${req.last_phonetic}","${req.gender}", "${req.email}", age,
        "${req.birthplace}", "${req.hire_date}", "${req.rool}", "${req.tel}"
      )
    val result: Boolean = personalInformationRepository.updateUser(createDataByPersonalInformation)
    if (result) {
      return Response("success", result)
    } else {
      return Response("error", "", "E008")
    }
  }
}
