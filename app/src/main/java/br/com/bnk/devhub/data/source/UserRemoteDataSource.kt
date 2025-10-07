package br.com.bnk.devhub.data.source

import br.com.bnk.devhub.data.dto.UserDto

interface UserRemoteDataSource {
    suspend fun getUser(userName: String): UserDto
}