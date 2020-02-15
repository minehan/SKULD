package example.util

data class Response(
  var status: String,
  var result: Any?,
  var message: String = ""
)