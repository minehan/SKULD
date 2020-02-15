package example.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*
import example.service.common.LoginService
import example.util.Response
import example.util.Request

@RestController
class CommonController {
  @Autowired
  lateinit var loginService: LoginService

  @CrossOrigin
  @PostMapping("/login")
  fun login(@RequestBody req: Request): Response {
    return loginService.execute(req)
  }
}
