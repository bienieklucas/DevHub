package br.com.bnk.devhub.data.source

import br.com.bnk.devhub.data.dto.UserDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserRemoteDataSourceImpl(
    private val httpClient: HttpClient,
) : UserRemoteDataSource {
    override suspend fun getUser(userName: String): UserDto =
        httpClient.get("/users/$userName").body()
}