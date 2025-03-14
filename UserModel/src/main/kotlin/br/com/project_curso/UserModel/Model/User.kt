package br.com.project_curso.UserModel.Model


data class User (
    //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = 0,
    var fistName : String? = "",
    var lastName : String? = "",
    var edress : String? = "",
    var gender : String? = ""
)