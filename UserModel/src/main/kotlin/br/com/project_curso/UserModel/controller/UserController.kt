package br.com.project_curso.UserModel.controller

import br.com.project_curso.UserModel.model.User
import br.com.project_curso.UserModel.services.UserServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

    // spring injeta a instância dessa variável posteriormente
    @Autowired
    private lateinit var userService : UserServices

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findUser(@PathVariable(value = "id") id : Long): User{
        return userService.findById(id)
    }

    @RequestMapping(value = ["/"], method = [RequestMethod.POST],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody user: User): User{
        return userService.create(user)
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.PUT],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody user: User): User{
        return userService.update(user)
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.DELETE],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value = "id") id: Long){
        userService.delete(id)
    }

    @RequestMapping(value = ["/"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAllUsers(): List<User>{
        return userService.findAll()
    }
}