package br.com.project_curso.UserModel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan("br.com.project_curso.UserModel.model")
@EnableJpaRepositories("br.com.project_curso.UserModel.repository")
class UserModelApplication

fun main(args: Array<String>) {
	runApplication<UserModelApplication>(*args)
}
