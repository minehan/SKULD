package example.entity

data class User(
  var id: Int?,
  var login_name: String,
  var password: String,
  var salt: String,
  var vaild: Boolean
)