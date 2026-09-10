package pe.edu.upc.easyvet.features.catalog.domain

interface ProductRepository {
    fun getProducts(): List<Product>
}