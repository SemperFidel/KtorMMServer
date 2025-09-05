package domain.repository

import arrow.core.Either
import data.entity.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getAllProducts(): Flow<Product>
    suspend fun getProductById(id: String): Either<Throwable, Product>
    suspend fun createProduct(product: Product): Either<Throwable, Unit>
    suspend fun updateProduct(product: Product): Either<Throwable, Unit>
    suspend fun deleteProductById(id: String): Either<Throwable, Unit>
}