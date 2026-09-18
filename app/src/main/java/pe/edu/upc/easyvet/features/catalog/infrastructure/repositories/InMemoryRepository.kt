package pe.edu.upc.easyvet.features.catalog.infrastructure.repositories

import kotlinx.coroutines.delay
import pe.edu.upc.easyvet.features.catalog.domain.Product
import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class InMemoryRepository @Inject constructor() : ProductRepository {

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

    override suspend fun getProducts(): Result<List<Product>> {
        delay(2000.milliseconds)
        return runCatching {
            _products
        }
    }

    override suspend fun getProductById(id: Int): Result<Product> {

        val product = _products.find { it.id == id }
        product?.let { product ->
            return Result.success(product)
        }
        return Result.failure(Exception("No product found"))

    }
}