package br.com.bnk.devhub.data.dto

import kotlinx.serialization.Serializable

@Serializable
class UserDto(
    val login: String,
    val avatar_url: String,
    val name: String,
    val bio: String
) {
}