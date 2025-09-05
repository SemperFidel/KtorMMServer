package di

import MongoConnection
import data.repositoryImpl.ProductRepositoryImpl
import domain.repository.ProductRepository
import org.koin.dsl.module

val databaseModule = module {
    single {MongoConnection("mongodb://localhost:27017", "ServerDB")}
    single<ProductRepository> { ProductRepositoryImpl(get()) }
}

