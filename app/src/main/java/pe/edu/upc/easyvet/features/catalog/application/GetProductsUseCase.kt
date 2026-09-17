package pe.edu.upc.easyvet.features.catalog.application

import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke() = repository.getProducts()
}