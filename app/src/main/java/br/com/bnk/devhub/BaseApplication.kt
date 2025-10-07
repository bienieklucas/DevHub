package br.com.bnk.devhub

import android.app.Application
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json

class BaseApplication : Application() {

    val httpClient = HttpClient {
        defaultRequest {
            url("https://api.github.com/")
        }
        install(ContentNegotiation) {
            json(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }
}