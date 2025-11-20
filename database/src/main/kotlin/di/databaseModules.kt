package di

import MongoConnection
import data.repositoryImpl.ProductRepositoryImpl
import domain.repository.ProductRepository
import io.r2dbc.spi.IsolationLevel
import org.jetbrains.exposed.v1.r2dbc.R2dbcDatabase
import org.jetbrains.exposed.v1.r2dbc.R2dbcDatabaseConfig
import org.koin.dsl.module

val databaseModule = module {
    single {MongoConnection("mongodb://localhost:27017", "ServerDB")}
    single {
        R2dbcDatabase.connect(
            url = "r2dbc:postgresql://localhost:5432/storebase",
            driver = "postgresql",
            user = "postgres",
            password = "password",
            databaseConfig = R2dbcDatabaseConfig{
                defaultMaxAttempts = 3
                defaultR2dbcIsolationLevel = IsolationLevel.READ_COMMITTED
            }
        )
    }
}

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
}

