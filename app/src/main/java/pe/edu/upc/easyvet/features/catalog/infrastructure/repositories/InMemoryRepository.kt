package pe.edu.upc.easyvet.features.catalog.infrastructure.repositories

import kotlinx.coroutines.delay
import pe.edu.upc.easyvet.features.catalog.domain.Product
import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import kotlin.time.Duration.Companion.milliseconds

class InMemoryRepository : ProductRepository {

    private val _products = listOf(
        Product(
            id = 1,
            name = "Dog Food",
            description = "High-quality dog food for all breeds.",
            price = 29.99,
            rating = 4.5,
            imageUrl = "https://i.imgur.com/WkZEOU6.png"
        ),
        Product(
            id = 2,
            name = "Cat Food",
            description = "Nutritious cat food for a healthy life.",
            price = 19.99,
            rating = 4.0,
            imageUrl = "https://i.imgur.com/guSk1sh.png"
        )
    )

    override suspend fun getProducts(): List<Product> {
        delay(2000.milliseconds)
        return _products
    }
}