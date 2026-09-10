package pe.edu.upc.easyvet.features.catalog.application

import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import pe.edu.upc.easyvet.features.catalog.infrastructure.InMemoryRepository

class GetProductsUseCase(private val repository: ProductRepository = InMemoryRepository()) {
    operator fun invoke() = repository.getProducts()
}