package pe.edu.upc.easyvet.features.catalog.domain

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}