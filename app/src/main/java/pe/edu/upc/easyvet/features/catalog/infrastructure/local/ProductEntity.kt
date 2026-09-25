package pe.edu.upc.easyvet.features.catalog.infrastructure.local

import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "products")
class ProductEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    @ColumnInfo("image_url")
    val imageUrl: String
)