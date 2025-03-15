package br.com.project_curso.UserModel.exceptions

import org.apache.logging.log4j.message.Message
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(message: String?) : RuntimeException(message)