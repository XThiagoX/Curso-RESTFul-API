package br.com.project_curso.UserModel.services

import br.com.project_curso.UserModel.Model.User
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class UserServices {
    private val counter : AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(UserServices::class.java.name)

    fun findById (id : Long): User{
        logger.info("Finding one user")

        val userMok = User()
        userMok.id = counter.incrementAndGet()
        userMok.fistName = "Thiago"
        userMok.lastName = "Araujo"
        userMok.edress = "Jabutinigga"
        userMok.gender = "male"
        return  userMok
    }

    fun findAll (): List<User>{
        logger.info("Finding all users")
        val users : MutableList<User> = ArrayList()
        for (i in 0..7){
            val user = mockUser(i)
            users.add(user)
        }
        return users
    }

    fun mockUser(i: Int): User {
        val userMok = User()
        userMok.id = counter.incrementAndGet()
        userMok.fistName = "Fist Name User $i"
        userMok.lastName = "Last Name User $i"
        userMok.edress = "Jabutinigga $i"
        userMok.gender = "male"
        return userMok
    }

    fun create(user: User) = user
    fun update(user: User) = user
    fun delete(id: Long) {}
}