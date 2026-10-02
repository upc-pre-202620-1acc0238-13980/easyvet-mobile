package pe.edu.upc.easyvet.features.cart.infrastructure.remote

class CartItemDto (
    val productId: Int,
    val title: String,
    val price: Double,
    val image: String,
    val category: String,
    val quantity: Int
)
