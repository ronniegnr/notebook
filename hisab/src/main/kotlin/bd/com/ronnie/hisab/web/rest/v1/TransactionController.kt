package bd.com.ronnie.hisab.web.rest.v1

import bd.com.ronnie.hisab.repository.AccountHeadRepository
import bd.com.ronnie.hisab.domain.AccountHead
import bd.com.ronnie.hisab.model.receive.TransactionEntry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/transactions")
class TransactionController(private val accountHeadRepository: AccountHeadRepository) {

    @PostMapping("")
    fun create(@RequestBody transactionEntry: TransactionEntry): Response {
        return transactionEntry
    }

    @GetMapping("crash")
    fun crash(): Nothing = throw RuntimeException("Showcasing Exception cases for Sentry entry")

    /**
     * create transaction
     * get a single transaction
     * get all transactions of a day
     * get all transactions of a month
     * month wise accountHead sum
     */

    @GetMapping("hello")
    fun hello(): String {
        val number = Math.random()
        val accountHead = AccountHead("$number the name", AccountHead.Status.ACTIVE)
        accountHeadRepository.save(accountHead)

        return "data inserted"
    }

    @GetMapping("select")
    fun select() = accountHeadRepository.findAll()

}