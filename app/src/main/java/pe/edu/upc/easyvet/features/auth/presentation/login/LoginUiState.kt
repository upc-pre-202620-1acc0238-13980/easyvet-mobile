package pe.edu.upc.easyvet.features.auth.presentation.login

import pe.edu.upc.easyvet.features.auth.domain.User

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isPasswordHidden: Boolean = true,
    val user: User? = null,
    val isAuthenticated: Boolean = false,
    val isLoading: Boolean = false,
    var errorMessage: String? = null
)
