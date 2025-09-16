package domain.repository

import arrow.core.Either
import kotlinx.coroutines.flow.Flow
import org.jetbrains.exposed.v1.core.Transaction

interface TransactionRepository {
    fun getAllTransactions(): Flow<Transaction>
    suspend fun addTransaction(transaction: Transaction): Either<Throwable, Transaction>
    suspend fun updateTransaction(transaction: Transaction): Either<Throwable, Transaction>
    suspend fun deleteTransaction(transaction: Transaction): Either<Throwable, Transaction>
}