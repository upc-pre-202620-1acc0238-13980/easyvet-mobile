package pe.edu.upc.easyvet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.ui.theme.EasyVetTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val products = listOf(
        Product(
            id = 1,
            name = "Dog Food",
            description = "High-quality dog food for all breeds.",
            price = 29.99,
            rating = 4.5,
            imageUrl = "https://i.imgur.com/WkZEOU6.png"
        ),
        Product(
            id = 2,
            name = "Cat Food",
            description = "Nutritious cat food for a healthy life.",
            price = 19.99,
            rating = 4.0,
            imageUrl = "https://i.imgur.com/guSk1sh.png"
        )
    )

    LazyColumn(modifier = modifier) {
        items(products) { product ->
            Card(
                modifier = Modifier.padding(8.dp)
            ) {
                Column(modifier.padding(8.dp)) {

                    AsyncImage(
                        model = product.imageUrl,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(0.45f)
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
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EasyVetTheme(dynamicColor = false) {
        HomeScreen()
    }
}