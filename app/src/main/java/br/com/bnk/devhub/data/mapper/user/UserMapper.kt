package br.com.bnk.devhub.data.mapper.user

import br.com.bnk.devhub.data.dto.UserDto
import br.com.bnk.devhub.domain.model.User

fun UserDto.toDomain(): User {
    return User(
        login = this.login,
        avatarUrl = this.avatar_url,
        name = this.name,
        bio = this.bio
    )
}