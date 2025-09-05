package domain.service

import arrow.core.Either
import data.entity.Product
import data.entity.ProductDTO
import data.entity.toDTO
import data.entity.toEntity
import domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductService(private val repo: ProductRepository) {

    fun getAll(): Flow<ProductDTO> =
        repo.getAllProducts().map { it.toDTO() }

    suspend fun getById(id: String): Either<Throwable, ProductDTO> =
        repo.getProductById(id).map { it.toDTO() }

    suspend fun create(productDTO: ProductDTO): Either<Throwable, Unit> =
        repo.createProduct(productDTO.toEntity())

    suspend fun update(productDTO: ProductDTO): Either<Throwable, Unit> =
        repo.updateProduct(productDTO.toEntity())

    suspend fun delete(id: String): Either<Throwable, Unit> =
        repo.deleteProductById(id)
}