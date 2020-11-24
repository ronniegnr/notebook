package bd.com.ronnie.hisab.web.rest;

import bd.com.ronnie.hisab.model.Transaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class TransactionController {


    @PostMapping("")
    public String createTransaction(@RequestBody Transaction transaction) {

        return "hello";
    }
}
