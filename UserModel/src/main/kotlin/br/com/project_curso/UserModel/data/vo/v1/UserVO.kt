package br.com.project_curso.UserModel.data.vo.v1

import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel


data class UserVO (

    @Mapping("id")
    var key: Long = 0,
    var firstName : String? = "",
    var lastName : String? = "",
    var address : String? = "",
    var gender : String? = ""
) : RepresentationModel<UserVO>()