package br.com.project_curso.UserModel.exceptions

import java.util.Date

data class ExceptionResponse (
    val timestamp : Date,
    val message: String?,
    val details: String
)