package br.com.project_curso.UserModel.data.vo.v2

import java.util.Date


data class UserVO (

    var id: Long = 0,
    var firstName : String? = "",
    var lastName : String? = "",
    var birthday : Date? = null,
    var address : String? = "",
    var gender : String? = ""
)