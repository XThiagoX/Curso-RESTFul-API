package br.com.project_curso.UserModel.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = 0,

    @Column(name = "fist_name", nullable = false)
    var firstName : String? = "",

    @Column(name = "last_name")
    var lastName : String? = "",

    @Column(nullable = false, length = 100)
    var address : String? = "",

    @Column
    var gender : String? = ""
)