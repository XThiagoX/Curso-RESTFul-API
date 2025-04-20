package br.com.erudio.unittests.mapper.mocks

import java.util.ArrayList
import br.com.project_curso.UserModel.data.vo.v1.UserVO
import br.com.project_curso.UserModel.model.User

class MockUser {
    fun mockEntity(): User {
        return mockEntity(0)
    }

    fun mockVO(): UserVO {
        return mockVO(0)
    }

    fun mockEntityList(): ArrayList<User> {
        val persons: ArrayList<User> = ArrayList<User>()
        for (i in 0..13) {
            persons.add(mockEntity(i))
        }
        return persons
    }

    fun mockVOList(): ArrayList<UserVO> {
        val persons: ArrayList<UserVO> = ArrayList()
        for (i in 0..13) {
            persons.add(mockVO(i))
        }
        return persons
    }

    fun mockEntity(number: Int): User {
        val person = User()
        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.gender = if (number % 2 == 0) "Male" else "Female"
        person.id = number.toLong()
        person.lastName = "Last Name Test$number"
        return person
    }

    fun mockVO(number: Int): UserVO {
        val person = UserVO()
        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.gender = if (number % 2 == 0) "Male" else "Female"
        person.id = number.toLong()
        person.lastName = "Last Name Test$number"
        return person
    }
}