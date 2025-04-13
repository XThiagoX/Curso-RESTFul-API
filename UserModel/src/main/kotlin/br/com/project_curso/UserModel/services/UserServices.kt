package br.com.project_curso.UserModel.services

import br.com.project_curso.UserModel.model.User
import br.com.project_curso.UserModel.exceptions.ResourceNotFoundException
import br.com.project_curso.UserModel.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class UserServices(
    private val repository: UserRepository
) {

    private val logger = Logger.getLogger(UserServices::class.java.name)

    fun findById(id: Long): User {
        logger.info("Finding one user")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No Records found for this ID!") }
    }

    fun findAll(): List<User> {
        logger.info("Finding all users")
        return repository.findAll()
    }

    fun create(user: User): User {
        logger.info("Creating one person with name ${user.firstName}")
        return repository.save(user)
    }

    fun update(user: User): User {
        logger.info("Update one person with id: ${user.id}")
        val entity = repository.findById(user.id!!)
            .orElseThrow { ResourceNotFoundException("No Records found for this ID!") }

        entity.firstName = user.firstName
        entity.lastName = user.lastName
        entity.address = user.address
        entity.gender = user.gender
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id: $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No Records found for this ID!") }
        repository.delete(entity)
    }
}
