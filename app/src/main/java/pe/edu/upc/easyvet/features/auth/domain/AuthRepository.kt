package pe.edu.upc.easyvet.features.auth.domain

interface AuthRepository {

    suspend fun login(email: String, password: String): Result<User>
}