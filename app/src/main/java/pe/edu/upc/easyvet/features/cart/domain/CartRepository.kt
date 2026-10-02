package pe.edu.upc.easyvet.features.cart.domain

interface CartRepository {
    suspend fun getCart(): Result<Cart>
}