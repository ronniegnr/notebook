package bd.com.ronnie.hisab.web.rest.v1

import bd.com.ronnie.hisab.AccountHeadRepository
import bd.com.ronnie.hisab.model.AccountHead
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/transactions")
class TransactionController(private val accountHeadRepository: AccountHeadRepository) {

    @GetMapping("hello")
    fun hello(): String {
        val number = Math.random()
        val accountHead = AccountHead("$number the name", AccountHead.Status.ACTIVE)
        accountHeadRepository.save(accountHead)

        return "data inserted"
    }

    @GetMapping("select")
    fun select(): Iterable<AccountHead> {
        return accountHeadRepository.findAll()
    }

    /**
     * create transaction
     * get a single transaction
     * get all transactions of a day
     * get all transactions of a month
     * monthwise accountHead sum
     */

}