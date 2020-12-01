package bd.com.ronnie.hisab.service

import bd.com.ronnie.hisab.domain.Transaction
import bd.com.ronnie.hisab.model.receive.TransactionEntry
import bd.com.ronnie.hisab.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(val transactionRepository: TransactionRepository) {

    fun saveTransaction(transactionEntry: TransactionEntry) {
        transaction = Transaction()
    }

}