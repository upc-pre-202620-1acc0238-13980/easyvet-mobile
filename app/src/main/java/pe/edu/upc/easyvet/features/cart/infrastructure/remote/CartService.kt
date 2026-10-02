package pe.edu.upc.easyvet.features.cart.infrastructure.remote

import retrofit2.Response
import retrofit2.http.GET

interface CartService {

    @GET("cart")
    suspend fun getCart(): Response<CartDto>
}