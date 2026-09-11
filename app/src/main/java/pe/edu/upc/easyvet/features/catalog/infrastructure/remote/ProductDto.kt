package pe.edu.upc.easyvet.features.catalog.infrastructure.remote

data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String,
    val category: String,
    val rating: Double,
    val stock: Int
)
