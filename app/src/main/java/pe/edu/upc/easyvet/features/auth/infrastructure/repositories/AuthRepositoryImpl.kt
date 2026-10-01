package pe.edu.upc.easyvet.features.auth.infrastructure.repositories

import pe.edu.upc.easyvet.features.auth.domain.AuthRepository
import pe.edu.upc.easyvet.features.auth.domain.User
import pe.edu.upc.easyvet.features.auth.infrastructure.remote.AuthService
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val service: AuthService) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Result<User> {
        TODO("Not yet implemented")
    }
}