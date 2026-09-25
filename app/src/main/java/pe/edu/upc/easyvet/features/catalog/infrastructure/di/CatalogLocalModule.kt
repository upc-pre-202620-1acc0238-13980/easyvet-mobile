package pe.edu.upc.easyvet.features.catalog.infrastructure.di

import android.content.Context
import androidx.room3.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.easyvet.features.catalog.infrastructure.local.AppDatabase
import pe.edu.upc.easyvet.features.catalog.infrastructure.local.ProductDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CatalogLocalModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder<AppDatabase>(context, "easyvet-database")
            .setDriver(AndroidSQLiteDriver())
            .build()
    }


    @Provides
    @Singleton
    fun provideProductDao(appDatabase: AppDatabase): ProductDao {
        return appDatabase.productDao()
    }
}