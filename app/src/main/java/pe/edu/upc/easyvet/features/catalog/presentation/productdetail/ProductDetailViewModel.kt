package pe.edu.upc.easyvet.features.catalog.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easyvet.features.catalog.application.GetProductByIdUseCase
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductById: GetProductByIdUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<ProductDetailUiState>(ProductDetailUiState.Loading)
    val uiState: StateFlow<ProductDetailUiState> = _uiState.asStateFlow()

    fun loadProductById(id: Int) {

        viewModelScope.launch {

            try {
                getProductById(id)
                    .onSuccess { product ->
                        _uiState.value = ProductDetailUiState.Success(product = product)

                    }
                    .onFailure { e ->
                        _uiState.value = ProductDetailUiState.Error(
                            message = e.message ?: "Unknown error"
                        )
                    }

            } catch (e: Exception) {
                _uiState.value = ProductDetailUiState.Error(
                    message = e.message ?: "An unexpected error occurred"
                )

            }

        }

    }
}