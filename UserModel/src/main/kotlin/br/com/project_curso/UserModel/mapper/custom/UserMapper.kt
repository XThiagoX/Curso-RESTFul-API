package br.com.project_curso.UserModel.mapper.custom

import br.com.project_curso.UserModel.data.vo.v2.UserVO
import br.com.project_curso.UserModel.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserMapper {

    fun mapEntityToVO(user: User): UserVO {
        val vo = UserVO()
        vo.id = user.id!!
        vo.address = user.address
        vo.birthday = Date()
        vo.firstName = user.firstName
        vo.lastName = user.lastName
        vo.gender = user.gender
        return vo
    }

    fun mapVOToEntity(user: UserVO): User {
        val entity = User()
        entity.id = user.id
        entity.address = user.address
        // entity.birthDay = user.birthDay
        entity.firstName = user.firstName
        entity.lastName = user.lastName
        entity.gender = user.gender
        return entity
    }
}