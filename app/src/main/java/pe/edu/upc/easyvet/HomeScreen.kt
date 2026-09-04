package pe.edu.upc.easyvet

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.easyvet.ui.theme.EasyVetTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val products = listOf("Product 1", "Product 2", "Product 3")

    LazyColumn(modifier = modifier) {
        items(products) { product ->
            Card(modifier = Modifier.padding(8.dp)) {
                Text(text = product, modifier = Modifier.padding(16.dp))
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