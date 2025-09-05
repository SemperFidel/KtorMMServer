package di

import domain.controller.ProductController
import domain.service.ProductService
import org.koin.dsl.module

val controllerModule = module {
    single { ProductController(get()) }
}

val serviceModule = module {
    single { ProductService(get()) }
}