package data.repositoryImpl

import MongoConnection
import arrow.core.Either
import com.mongodb.client.model.Filters
import com.mongodb.reactivestreams.client.MongoCollection
import data.entity.Product
import domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.awaitSingle

class ProductRepositoryImpl(
    private val db: MongoConnection,
): ProductRepository {

    private val collection: MongoCollection<Product> =
        db.database.getCollection("products", Product::class.java)

    override fun getAllProducts(): Flow<Product> =
        collection.find().asFlow()

    override suspend fun getProductById(id: String): Either<Throwable, Product> =
        Either.catch {
            val product = collection.find(Filters.eq("_id", id)).awaitFirstOrNull()
            product ?: error("Product with id=$id not found")
        }

    override suspend fun createProduct(product: Product): Either<Throwable, Unit> =
        Either.catch {
            collection.insertOne(product).awaitSingle()
            Unit
        }

    override suspend fun updateProduct(product: Product): Either<Throwable, Unit> =
        Either.catch {
            requireNotNull(product.id) { "Product ID must not be null for update" }
            collection.replaceOne(Filters.eq("_id", product.id), product).awaitSingle()
            Unit
        }

    override suspend fun deleteProductById(id: String): Either<Throwable, Unit> =
        Either.catch {
            collection.deleteOne(Filters.eq("_id", id)).awaitSingle()
            Unit
        }
}