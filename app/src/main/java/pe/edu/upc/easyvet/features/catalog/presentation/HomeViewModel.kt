package pe.edu.upc.easyvet.features.catalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.easyvet.features.catalog.application.GetProductsUseCase

class HomeViewModel(private val getProducts: GetProductsUseCase = GetProductsUseCase()): ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()


    fun loadProducts() {

        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(isLoading = true)
            }

            try {
                val products = getProducts()
                _uiState.update { currentState ->
                    currentState.copy(
                        products = products,
                        isLoading = false
                    )
                }

            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        errorMessage = e.message ?: "An unexpected error occurred"
                    )
                }
            }
        }

    }

    init {
        loadProducts()
    }
}