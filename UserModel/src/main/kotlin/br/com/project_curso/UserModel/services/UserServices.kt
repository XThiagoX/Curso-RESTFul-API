package br.com.project_curso.UserModel.services

import br.com.project_curso.UserModel.controller.UserController
import br.com.project_curso.UserModel.data.vo.v1.UserVO
import br.com.project_curso.UserModel.data.vo.v2.UserVO as UserVersion2
import br.com.project_curso.UserModel.exceptions.ResourceNotFoundException
import br.com.project_curso.UserModel.mapper.DozerMapper
import br.com.project_curso.UserModel.mapper.custom.UserMapper
import br.com.project_curso.UserModel.model.User
import br.com.project_curso.UserModel.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class UserServices(
    private val repository: UserRepository,
    //private val customUserMapper : UserMapper
) {

    @Autowired
    private lateinit var customUserMapper : UserMapper

    private val logger = Logger.getLogger(UserServices::class.java.name)

    fun findById(id: Long): UserVO {
        logger.info("Finding one user")
        val users = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No Records found for this ID!") }
        val userVO: UserVO = DozerMapper.parseObject( users, UserVO::class.java)
        val withSelfRel = linkTo(UserController::class.java).slash(userVO.key).withSelfRel()
        userVO.add(withSelfRel)
        return userVO
    }

    fun findAll(): List<UserVO> {
        logger.info("Finding all users")
        val users = repository.findAll()
        return DozerMapper.parseListObject(users, UserVO::class.java)
    }

    fun create(user: UserVO): UserVO {
        logger.info("Creating one person with name ${user.firstName}")
        var entity : User = DozerMapper.parseObject(user, User::class.java)
        val userVO: UserVO = DozerMapper.parseObject(repository.save(entity), UserVO::class.java)
        val withSelfRel = linkTo(UserController::class.java).slash(userVO.key).withSelfRel()
        userVO.add(withSelfRel)
        return userVO
    }

    fun createVersion2(user: UserVersion2): UserVersion2 {
        logger.info("Creating one person with name ${user.firstName}")
        var entity : User = customUserMapper.mapVOToEntity(user)
        return customUserMapper.mapEntityToVO(repository.save(entity))
    }

    fun update(user: UserVO): UserVO {
        logger.info("Update one person with id: ${user.key}")
        val entity = repository.findById(user.key!!)
            .orElseThrow { ResourceNotFoundException("No Records found for this ID!") }

        entity.firstName = user.firstName
        entity.lastName = user.lastName
        entity.address = user.address
        entity.gender = user.gender

        val userVO : UserVO = DozerMapper.parseObject(repository.save(entity), UserVO::class.java)
        val withSelfRel = linkTo(UserController::class.java).slash(userVO.key).withSelfRel()
        userVO.add(withSelfRel)
        return userVO
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No Records found for this ID!") }
        repository.delete(entity)
    }
}
