package example.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.*
import example.service.user.UserListService
import example.service.user.UserDetailService
import example.service.user.UserDeleteService
import example.service.user.UserCreateService
import example.service.user.UserUpdateService
import example.util.Response
import example.util.Request

@RestController
class UserController {
  // user一覧
  @Autowired
  lateinit var userListService: UserListService

  @CrossOrigin
  @GetMapping("/users")
  fun getUsers(): Response {
    return userListService.execute()
  }

  // user詳細
  @Autowired
  lateinit var userDetailService: UserDetailService

  @CrossOrigin
  @GetMapping("/user")
  fun getUser(@RequestParam("userId") userId : Int): Response {
    return userDetailService.execute(userId)
  }

  // user削除
  @Autowired
  lateinit var userDeleteService: UserDeleteService

  @CrossOrigin
  @DeleteMapping("/user")
  fun deleteUser(@RequestParam("userId") userId : Int): Response {
    return userDeleteService.execute(userId)
  }

  // user登録
  @Autowired
  lateinit var userCreateService: UserCreateService

  @CrossOrigin
  @PostMapping("/user")
  fun createUser(@RequestBody req: Request): Response {
    return userCreateService.execute(req)
  }

  // user更新
  @Autowired
  lateinit var userUpdateService: UserUpdateService

  @CrossOrigin
  @PutMapping("/user")
  fun updateUser(@RequestBody req: Request): Response {
    return userUpdateService.execute(req)
  }
}
