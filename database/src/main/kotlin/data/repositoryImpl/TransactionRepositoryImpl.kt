package data.repositoryImpl

import arrow.core.Either
import domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.core.Transaction
import org.jetbrains.exposed.v1.r2dbc.R2dbcDatabase
import org.jetbrains.exposed.v1.r2dbc.selectAll
import org.jetbrains.exposed.v1.r2dbc.transactions.suspendTransaction

class TransactionRepositoryImpl(
    private val db: R2dbcDatabase
): TransactionRepository {

    private val table: Table = Table("transactions")

    override fun getAllTransactions(): Flow<Transaction> = flow {
        suspendTransaction(db) {
            table.selectAll()
        }
    }

    override suspend fun addTransaction(transaction: Transaction): Either<Throwable, Transaction> {
        TODO("Not yet implemented")
    }

    override suspend fun updateTransaction(transaction: Transaction): Either<Throwable, Transaction> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTransaction(transaction: Transaction): Either<Throwable, Transaction> {
        TODO("Not yet implemented")
    }

}