package pe.edu.upc.easyvet.features.catalog.infrastructure.repositories

import pe.edu.upc.easyvet.features.catalog.domain.Product
import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import pe.edu.upc.easyvet.features.catalog.infrastructure.local.ProductDao
import pe.edu.upc.easyvet.features.catalog.infrastructure.local.ProductEntity
import pe.edu.upc.easyvet.features.catalog.infrastructure.remote.ProductService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val service: ProductService,
    private val dao: ProductDao
) : ProductRepository {
    override suspend fun getProducts(): Result<List<Product>> {

        try {
            val response = service.getProducts()

            if (response.isSuccessful) {

                response.body()?.let { productsResponseDto ->
                    val entities = productsResponseDto.products.map { dto ->
                        ProductEntity(
                            id = dto.id,
                            name = dto.title,
                            description = dto.description,
                            price = dto.price,
                            rating = dto.rating,
                            imageUrl = dto.image
                        )
                    }.toList()
                    dao.insertProducts(entities)
                }
            }
        }
        catch (_: Exception){
        }

        val products = dao.fetchAllProducts().map { entity ->
            Product(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                price = entity.price,
                rating = entity.rating,
                imageUrl = entity.imageUrl
            )
        }
        return Result.success(products)
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