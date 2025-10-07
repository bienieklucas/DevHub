package br.com.bnk.devhub.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.bnk.devhub.domain.model.User
import br.com.bnk.devhub.domain.usecase.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _userState = MutableStateFlow<UserState>(UserState.Idle)
    val userState: StateFlow<UserState> = _userState

    fun loadUser(userId: String) {
        // Inicia a Coroutine no escopo do ViewModel
        viewModelScope.launch {
            _userState.value = UserState.Loading

            try {
                // Chama a função 'suspend' do Use Case
                val user = getUserUseCase(userId)

                _userState.value = UserState.Success(user)

            } catch (e: IllegalArgumentException) {
                _userState.value = UserState.Error("Username Inválido: ${e.message}")
            } catch (e: Exception) {
                _userState.value = UserState.Error("Falha na Rede ou API.")
            }
        }
    }

    sealed class UserState {
        data object Idle : UserState()
        data object Loading : UserState()
        data class Success(val user: User) : UserState()
        data class Error(val message: String) : UserState()
    }
}