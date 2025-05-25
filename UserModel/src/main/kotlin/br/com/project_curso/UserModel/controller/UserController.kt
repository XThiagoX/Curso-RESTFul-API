package br.com.project_curso.UserModel.controller

import br.com.project_curso.UserModel.data.vo.v1.UserVO
import br.com.project_curso.UserModel.data.vo.v2.UserVO as UserVersion2
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
    private lateinit var UserService : UserServices

    @GetMapping( "/{id}",
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun findUserVO(@PathVariable(value = "id") id : Long): UserVO{
        return UserService.findById(id)
    }

    @GetMapping(value = ["/"], produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun findAllUserVOs(): List<UserVO>{
        return UserService.findAll()
    }

    @PostMapping(value = ["/"],
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun create(@RequestBody UserVO: UserVO): UserVO{
        return UserService.create(UserVO)
    }

    @PostMapping(value = ["/v2"],
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun createVersion2(@RequestBody user: UserVersion2): UserVersion2{
        return UserService.createVersion2(user)
    }

    @PutMapping(value = ["/{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun update(@RequestBody UserVO: UserVO): UserVO{
        return UserService.update(UserVO)
    }

    @DeleteMapping(value = ["/{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*>{
        UserService.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}