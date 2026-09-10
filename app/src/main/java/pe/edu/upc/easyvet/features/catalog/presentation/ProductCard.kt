package pe.edu.upc.easyvet.features.catalog.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.features.catalog.domain.Product

@Composable
fun ProductCard(modifier: Modifier = Modifier, product: Product) {

    Card(
        modifier = modifier.padding(8.dp)
    ) {
        Column(modifier.padding(8.dp)) {

            AsyncImage(
                model = product.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "${product.rating}",
            )
            Text(
                text = "$ ${product.price}",
            )
        }

    }
}
