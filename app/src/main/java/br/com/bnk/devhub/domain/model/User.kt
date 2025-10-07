package br.com.bnk.devhub.domain.model

data class User(
    val login: String,
    val avatarUrl: String,
    val name: String,
    val bio: String
)
