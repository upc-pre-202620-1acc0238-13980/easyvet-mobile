package pe.edu.upc.easyvet.features.catalog.application

import pe.edu.upc.easyvet.features.catalog.domain.Product
import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Int): Result<Product> = repository.getProductById(id)
}