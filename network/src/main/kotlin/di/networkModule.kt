package di

import domain.service.ProductService
import org.koin.dsl.module

val serviceModule = module {
    single { ProductService(get()) }
}