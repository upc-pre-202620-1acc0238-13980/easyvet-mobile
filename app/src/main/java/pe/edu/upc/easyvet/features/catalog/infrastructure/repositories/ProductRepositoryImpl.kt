package pe.edu.upc.easyvet.features.catalog.infrastructure.repositories

import pe.edu.upc.easyvet.features.catalog.domain.Product
import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import pe.edu.upc.easyvet.features.catalog.infrastructure.remote.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRepositoryImpl(private val service: ProductService =
                                Retrofit.Builder()
                                    .baseUrl("https://petapi-591531460223.us-central1.run.app/api/")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build()
                                    .create(ProductService::class.java)


): ProductRepository {
    override suspend fun getProducts(): List<Product> {
        val response = service.getProducts()

        if(response.isSuccessful) {
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
}