package pe.edu.upc.easyvet.features.catalog.infrastructure.local

import androidx.room3.Dao
import androidx.room3.Query
import androidx.room3.Upsert

@Dao
interface ProductDao {

    @Query("select * from products")
    suspend fun fetchAllProducts(): List<ProductEntity>

    @Upsert
    suspend fun insertProducts(entities: List<ProductEntity>)

    @Upsert
    suspend fun insertProduct(entity: ProductEntity)
}