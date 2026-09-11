package pe.edu.upc.easyvet.features.catalog.application

import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import pe.edu.upc.easyvet.features.catalog.infrastructure.repositories.InMemoryRepository

class GetProductsUseCase(private val repository: ProductRepository = InMemoryRepository()) {
    suspend operator fun invoke() = repository.getProducts()
}