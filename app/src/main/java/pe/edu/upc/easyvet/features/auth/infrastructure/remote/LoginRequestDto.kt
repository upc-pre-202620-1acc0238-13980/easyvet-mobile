package pe.edu.upc.easyvet.features.auth.infrastructure.remote

data class LoginRequestDto(
    val email: String,
    val password: String
)
