package pe.edu.upc.easyvet.features.catalog.presentation

import pe.edu.upc.easyvet.features.catalog.domain.Product

data class HomeUiState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
