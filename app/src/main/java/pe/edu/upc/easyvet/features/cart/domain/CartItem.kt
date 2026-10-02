package pe.edu.upc.easyvet.features.cart.domain

data class CartItem(
    val productId: Int,
    val name: String,
    val price: Double,
    val image: String,
    val category: String,
    val quantity: Int
)
