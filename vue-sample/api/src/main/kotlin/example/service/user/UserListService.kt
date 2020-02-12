package example.service.user

import kotlin.collections.List
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import example.entity.PersonalInformation
import example.repository.PersonalInformationRepository
import example.util.Response

@Service
class UserListService {
  @Autowired
  lateinit var personalInformationRepository: PersonalInformationRepository

  // メインロジック
  fun execute(): Response {
    val personalInformation: List<PersonalInformation> = personalInformationRepository.selectUsers()
    if (personalInformation.count() == 0) {
      return Response("error", "", "E004")
    } else {
      return Response("success", personalInformation)
    }
  }
}
