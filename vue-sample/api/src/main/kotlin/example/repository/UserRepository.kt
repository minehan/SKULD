package example.repository

import example.entity.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface UserRepository {
  @Select(
    "SELECT *",
    "FROM user",
    "WHERE login_name = #{login_name}",
    "AND vaild <> 0"
  )
  fun selectUserByLoginName(@Param("login_name") login_name: String?): User

  @Update("UPDATE user SET vaild = 0 WHERE id = #{userId}")
  fun deleteUser(userId: Int): Boolean

  @Insert(
    "INSERT INTO user(login_name, password, salt, vaild)",
    "values(#{login_name}, #{password}, #{salt}, #{vaild})"
  )
  fun createUser(createData: User): Boolean

  // 排他的制御はとりあえず後回し
  @Select("SELECT id FROM user ORDER BY id DESC LIMIT 1")
  fun getNewUserId(): Int

}
