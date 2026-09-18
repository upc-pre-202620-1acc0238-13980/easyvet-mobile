package pe.edu.upc.easyvet.features.catalog.infrastructure.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.easyvet.features.catalog.infrastructure.remote.ProductService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CatalogApiModule {

    @Provides
    @Singleton
    fun provideProductService(retrofit: Retrofit): ProductService {
       return  retrofit.create(ProductService::class.java)
    }
}