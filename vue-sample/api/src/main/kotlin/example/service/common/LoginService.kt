package example.service.common

import java.security.MessageDigest;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import example.entity.User
import example.repository.UserRepository
import example.util.Request
import example.util.Response

@Service
class LoginService {
  @Autowired
  lateinit var userRepository: UserRepository

  // salt変換
  fun hash(str: String): String {
    val bytes = str.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("", { str, it -> str + "%02x".format(it) }).toUpperCase()
  }

  // メインロジック
  fun execute(req: Request): Response {
    val user: User? = userRepository.selectUserByLoginName(req.login_name)
    if (user == null) {
      // userが存在しない
      return Response("error", "", "E001")
    } else if("${req.password + hash(user.salt)}" != user.password) {
      // passwordが一致しない
      return Response("error", "", "E002")
    } else {
      // 問題なし -> 全部返す必要ないかも
      return Response("success", user)
    }
  }
}
