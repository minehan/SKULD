package example.service.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import example.entity.PersonalInformation
import example.repository.PersonalInformationRepository
import example.util.Response

@Service
class UserDetailService {
  @Autowired
  lateinit var personalInformationRepository: PersonalInformationRepository

  // メインロジック
  fun execute(userId: Int): Response {
    val personalInformation: PersonalInformation? = personalInformationRepository.selectUser(userId)
    if (personalInformation == null) {
      return Response("error", "", "E005")
    } else {
      return Response("success", personalInformation)
    }
  }
}
