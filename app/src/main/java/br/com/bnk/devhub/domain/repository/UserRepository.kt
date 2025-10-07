package br.com.bnk.devhub.domain.repository

import br.com.bnk.devhub.domain.model.User

interface UserRepository {
    suspend fun getUser(userName: String): User
}