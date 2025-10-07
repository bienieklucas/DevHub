package br.com.bnk.devhub.data.repository

import br.com.bnk.devhub.data.mapper.user.toDomain
import br.com.bnk.devhub.data.source.UserRemoteDataSource
import br.com.bnk.devhub.domain.model.User
import br.com.bnk.devhub.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUser(userName: String): User {
        val response = remoteSource.getUser(userName)

        return response.toDomain()
    }
}