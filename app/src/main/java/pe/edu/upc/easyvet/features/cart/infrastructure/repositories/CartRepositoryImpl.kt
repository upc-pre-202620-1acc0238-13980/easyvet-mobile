package pe.edu.upc.easyvet.features.cart.infrastructure.repositories

import pe.edu.upc.easyvet.features.cart.domain.Cart
import pe.edu.upc.easyvet.features.cart.domain.CartItem
import pe.edu.upc.easyvet.features.cart.domain.CartRepository
import pe.edu.upc.easyvet.features.cart.infrastructure.remote.CartService
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(private val service: CartService) : CartRepository {
    override suspend fun getCart(): Result<Cart> {
        try {
            val response = service.getCart()
            if (response.isSuccessful) {
                response.body()?.let { cartDto ->
                    val cart = Cart(
                        cartItems = cartDto.cartItems.map { cartItemDto ->
                            CartItem(
                                productId = cartItemDto.productId,
                                quantity = cartItemDto.quantity,
                                name = cartItemDto.title,
                                price = cartItemDto.price,
                                image = cartItemDto.image,
                                category = cartItemDto.category
                            )
                        }
                    )
                    return Result.success(cart)
                }
            }
            return Result.failure(Exception(response.message()))
        } catch (e: Exception) {
            return Result.failure(e)
        }

    }
}