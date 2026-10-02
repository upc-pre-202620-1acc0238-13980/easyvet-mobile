package pe.edu.upc.easyvet.features.cart.presentation.cart

import pe.edu.upc.easyvet.features.cart.domain.Cart

data class CartUiState(
    val isLoading: Boolean = false,
    val cart: Cart = Cart(emptyList()),
    val errorMessage: String? = null
)
