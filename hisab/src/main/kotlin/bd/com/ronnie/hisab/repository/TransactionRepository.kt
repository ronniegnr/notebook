package bd.com.ronnie.hisab.repository

import org.hibernate.Transaction
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : CrudRepository<Transaction, Int> {
}