package pe.edu.upc.easyvet.features.catalog.application

import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository

class GetProductsUseCase (private val repository: ProductRepository){
    operator fun invoke() = repository.getProducts()
}