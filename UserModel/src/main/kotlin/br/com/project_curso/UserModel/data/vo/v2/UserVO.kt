package br.com.project_curso.UserModel.data.vo.v2

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.util.Date

@JsonPropertyOrder("id", "firstName", "lastName", "gender", "birthDate", "address") //Serialização: muda a ordem
data class UserVO (

    var id: Long = 0,
    @field:JsonProperty("first_Name") //Serialização: muda nome na api
    var firstName : String? = "",
    @field:JsonProperty("last_Name")
    var lastName : String? = "",
    var birthday : Date? = null,
    var address : String? = "",
    var gender : String? = ""
)