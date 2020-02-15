package example.repository

import kotlin.collections.List
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import example.entity.PersonalInformation

@Mapper
@Repository
interface PersonalInformationRepository {
  @Select(
    "SELECT *",
    "FROM personal_information",
    "WHERE user_id IN",
    "(SELECT id FROM `user` WHERE vaild <> 0)"
  )
  fun selectUsers(): List<PersonalInformation>

  @Select(
    "SELECT *",
    "FROM personal_information",
    "WHERE user_id = #{userId}"
  )
  fun selectUser(userId: Int): PersonalInformation

  @Insert(
    "INSERT INTO personal_information(user_id, first_name, last_name, first_phonetic, last_phonetic, gender, email, age, birthplace, hire_date, rool, tel)",
    "values(#{user_id}, #{first_name}, #{last_name}, #{first_phonetic}, #{last_phonetic}, #{gender}, #{email}, #{age}, #{birthplace}, #{hire_date}, #{rool}, #{tel})"
  )
  fun createUser(createData: PersonalInformation): Boolean

  @Update(
    "UPDATE personal_information SET",
    "first_name = #{first_name}, last_name = #{last_name}, first_phonetic = #{first_phonetic}, last_phonetic = #{last_phonetic},",
    "gender = #{gender}, email = #{email}, age = #{age}, birthplace = #{birthplace}, hire_date = #{hire_date}, rool = #{rool}, tel = #{tel}",
    "WHERE user_id = #{user_id}"
  )
  fun updateUser(createData: PersonalInformation): Boolean
}
