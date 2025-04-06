package br.com.project_curso.UserModel.repository

import br.com.project_curso.UserModel.Model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long?> {

}