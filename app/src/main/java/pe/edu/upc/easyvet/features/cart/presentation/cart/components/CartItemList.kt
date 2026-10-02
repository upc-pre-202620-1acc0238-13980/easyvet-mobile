package pe.edu.upc.easyvet.features.cart.presentation.cart.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import pe.edu.upc.easyvet.features.cart.domain.CartItem

@Composable
fun CartItemList(cartItems: List<CartItem>) {

    LazyColumn {
        items(cartItems) { carItem ->
            CartItemCard(carItem)
        }
    }

}