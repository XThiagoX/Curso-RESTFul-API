package br.com.project_curso.UserModel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class UserModelApplication

fun main(args: Array<String>) {
	runApplication<UserModelApplication>(*args)
}
