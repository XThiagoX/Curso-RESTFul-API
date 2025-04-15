package br.com.project_curso.UserModel.controller

import br.com.project_curso.UserModel.model.User
import br.com.project_curso.UserModel.services.UserServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @GetMapping( "/{id}",
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findUser(@PathVariable(value = "id") id : Long): User{
        return userService.findById(id)
    }

    @GetMapping(value = ["/"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAllUsers(): List<User>{
        return userService.findAll()
    }

    @PostMapping("/",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody user: User): User{
        return userService.create(user)
    }

    @PutMapping(value = ["/{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody user: User): User{
        return userService.update(user)
    }

    @DeleteMapping(value = ["/{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*>{
        userService.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}