package example.service.user

import kotlin.collections.List
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import example.entity.User
import example.repository.UserRepository
import example.util.Response

@Service
class UserDeleteService {
  @Autowired
  lateinit var userRepository: UserRepository

  // メインロジック
  fun execute(userId: Int): Response {
    val result: Boolean = userRepository.deleteUser(userId)
    if (result) {
      return Response("success", result)
    } else {
      return Response("error", "", "E003")
    }
  }
}
