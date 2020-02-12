package example.entity

data class PersonalInformation(
  var id: Int?,
  var user_id: Int,
  var first_name: String,
  var last_name: String,
  var first_phonetic: String,
  var last_phonetic: String,
  var gender: String,
  var email: String,
  var age: Int,
  var birthplace: String,
  var hire_date: String,
  var rool: String,
  var tel: String
)