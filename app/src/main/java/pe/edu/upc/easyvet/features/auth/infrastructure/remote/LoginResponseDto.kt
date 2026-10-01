package pe.edu.upc.easyvet.features.auth.infrastructure.remote

data class LoginResponseDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val token: String
)
