package domain.repository

import arrow.core.Either
import kotlinx.coroutines.flow.Flow
import org.jetbrains.exposed.v1.core.Transaction

interface TransactionRepository {
    suspend fun getAllTransactions(): List<Transaction>

    suspend fun getAllTransactionsByUserId(userId: String): Either<List<Transaction>, Int>
    suspend fun addTransaction(transaction: Transaction): Either<Throwable, Transaction>
    suspend fun updateTransaction(transaction: Transaction): Either<Throwable, Unit>
    suspend fun deleteTransactionById(id: Int): Either<Throwable, Unit>
}