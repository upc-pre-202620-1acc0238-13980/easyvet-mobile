package pe.edu.upc.easyvet.features.catalog.presentation.productdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.core.designsystem.icon.arrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    id: Int,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    LaunchedEffect(key1 = id) {
        viewModel.loadProductById(id)
    }

    Scaffold(modifier = modifier,
        topBar = {
            TopAppBar(title =  {}, navigationIcon = {
                IconButton(
                    onClick = onBack
                ) {
                    Icon(arrowBack, contentDescription = "back")
                }
            })
        }

        ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (uiState) {

                is ProductDetailUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is ProductDetailUiState.Success -> {
                    Column (modifier = Modifier.fillMaxSize()) {
                        AsyncImage(
                            model = uiState.product.imageUrl,
                            contentDescription = uiState.product.name,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Text(text = uiState.product.description)
                    }

                }

                is ProductDetailUiState.Error -> {
                    Text(text = uiState.message)

                }
            }
        }

    }
}