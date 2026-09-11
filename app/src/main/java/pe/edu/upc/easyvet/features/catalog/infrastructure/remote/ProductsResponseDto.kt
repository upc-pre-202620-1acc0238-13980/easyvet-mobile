package pe.edu.upc.easyvet.features.catalog.infrastructure.remote

data class ProductsResponseDto(
    val count: Int,
    val products: List<ProductDto>
)
