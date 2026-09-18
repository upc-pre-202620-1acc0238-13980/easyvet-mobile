package pe.edu.upc.easyvet.features.catalog.infrastructure.repositories

import pe.edu.upc.easyvet.features.catalog.domain.Product
import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import pe.edu.upc.easyvet.features.catalog.infrastructure.remote.ProductService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val service: ProductService
) : ProductRepository {
    override suspend fun getProducts(): Result<List<Product>> {

        try {
            val response = service.getProducts()

            if (response.isSuccessful) {

                response.body()?.let { productsResponseDto ->
                    val products = productsResponseDto.products.map { dto ->
                        Product(
                            id = dto.id,
                            name = dto.title,
                            description = dto.description,
                            price = dto.price,
                            rating = dto.rating,
                            imageUrl = dto.image
                        )
                    }.toList()
                    return Result.success(products)
                }
                return Result.failure(Exception("No products found"))
            }
            return Result.failure(Exception("No response"))
        }
        catch (_: Exception){
            return Result.failure(Exception("No internet connection"))
        }

    }

    override suspend fun getProductById(id: Int): Result<Product> {
        val response = service.getProductById(id)

        if (response.isSuccessful) {
            response.body()?.let { dto ->
                val product =   Product(
                    id = dto.id,
                    name = dto.title,
                    description = dto.description,
                    price = dto.price,
                    rating = dto.rating,
                    imageUrl = dto.image
                )
                return Result.success(product)
            }
            return Result.failure(Exception("No products found"))
        }
        return Result.failure(Exception("No response"))
    }
}