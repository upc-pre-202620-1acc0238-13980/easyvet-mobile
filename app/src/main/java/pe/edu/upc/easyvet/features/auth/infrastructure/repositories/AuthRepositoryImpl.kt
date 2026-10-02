package pe.edu.upc.easyvet.features.auth.infrastructure.repositories

import pe.edu.upc.easyvet.features.auth.domain.AuthRepository
import pe.edu.upc.easyvet.features.auth.domain.User
import pe.edu.upc.easyvet.features.auth.infrastructure.local.TokenManager
import pe.edu.upc.easyvet.features.auth.infrastructure.remote.AuthService
import pe.edu.upc.easyvet.features.auth.infrastructure.remote.LoginRequestDto
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val service: AuthService,
    private val tokenManager: TokenManager
) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Result<User> {
        try {
            val response = service.login(LoginRequestDto(email, password))

            if (response.isSuccessful) {
                response.body()?.let { dto ->
                    val user = User(
                        firstName = dto.firstName,
                        lastName = dto.lastName,
                        email = dto.email
                    )
                    tokenManager.saveToken(dto.token)
                    return Result.success(value = user)
                }
            }
            return Result.failure(Exception(response.message()))

        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}