package br.com.bnk.devhub.domain.usecase

import br.com.bnk.devhub.domain.model.User
import br.com.bnk.devhub.domain.repository.UserRepository

class GetUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userName: String): User {
        if (userName.isEmpty()) {
            throw IllegalArgumentException("Username cannot be empty.")
        }
        return repository.getUser(userName)
    }
}