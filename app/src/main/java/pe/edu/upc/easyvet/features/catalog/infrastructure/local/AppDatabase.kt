package pe.edu.upc.easyvet.features.catalog.infrastructure.local

import androidx.room3.Database
import androidx.room3.RoomDatabase

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}