package pe.edu.upc.easyvet.features.cart.presentation.cart.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.features.cart.domain.CartItem

@Composable
fun CartItemCard(cartItem: CartItem) {
    Column {
        AsyncImage(
            model = cartItem.image,
            contentDescription = cartItem.name
        )
        Text(text = cartItem.name)
    }
}