package pe.edu.upc.easyvet.features.catalog.infrastructure.repositories

import pe.edu.upc.easyvet.features.catalog.domain.Product
import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import pe.edu.upc.easyvet.features.catalog.infrastructure.remote.ProductService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val service: ProductService
) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        val response = service.getProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsResponseDto ->
                return productsResponseDto.products.map { dto ->
                    Product(
                        id = dto.id,
                        name = dto.title,
                        description = dto.description,
                        price = dto.price,
                        rating = dto.rating,
                        imageUrl = dto.image
                    )
                }.toList()
            }
        }
        return emptyList()
    }

    override suspend fun getProductById(id: Int): Product? {
        val response = service.getProductById(id)

        if (response.isSuccessful) {
            response.body()?.let { dto ->
                Product(
                    id = dto.id,
                    name = dto.title,
                    description = dto.description,
                    price = dto.price,
                    rating = dto.rating,
                    imageUrl = dto.image
                )
            }
        }
        return null
    }
}