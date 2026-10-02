package pe.edu.upc.easyvet.features.cart.infrastructure.repositories

import pe.edu.upc.easyvet.features.cart.domain.Cart
import pe.edu.upc.easyvet.features.cart.domain.CartRepository
import pe.edu.upc.easyvet.features.cart.infrastructure.remote.CartService
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(private val service: CartService) : CartRepository {
    override suspend fun getCart(): Result<Cart> {
        TODO("Not yet implemented")
    }
}