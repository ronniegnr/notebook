package bd.com.ronnie.blogservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static bd.com.ronnie.blogservice.constant.URLConstants.POST_HOME_URL;

@Controller
public class HomeController {

    @GetMapping("")
    public String home() {
        return "redirect:" + POST_HOME_URL;
    }

}
