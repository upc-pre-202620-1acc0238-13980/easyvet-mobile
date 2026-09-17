package pe.edu.upc.easyvet.features.catalog.infrastructure.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.easyvet.features.catalog.domain.ProductRepository
import pe.edu.upc.easyvet.features.catalog.infrastructure.repositories.ProductRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideProductRepository(impl: ProductRepositoryImpl): ProductRepository
}