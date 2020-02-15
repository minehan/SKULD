package example.util

data class Request(
  // 飛ばすパラメーター全部ここで定義しておく
  var login_name: String? = "",
  var password: String? = "",
  var user_id: String? = "",
  var first_name: String? = "",
  var last_name: String? = "",
  var first_phonetic: String? = "",
  var last_phonetic: String? = "",
  var gender: String? = "",
  var email: String? = "",
  var age: String? = "",
  var birthplace: String? = "",
  var hire_date: String? = "",
  var rool: String? = "",
  var tel: String? = ""
)