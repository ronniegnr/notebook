package bd.com.ronnie.hisab.web.rest.v1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/transactions")
class TransactionController {

    @GetMapping("hello")
    fun hello(): String {
        return "hello"
    }

    /**
     * create transaction
     * get a single transaction
     * get all transactions of a day
     * get all transactions of a month
     * monthwise accountHead sum
     */

}