package pe.edu.upc.easyvet.features.catalog.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.core.theme.EasyVetTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel = viewModel()) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value


    LazyColumn(modifier = modifier) {
        items(uiState.products) { product ->
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