package bd.com.ronnie.blogservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("blog")
public class BlogController {

    // private final

    @GetMapping("")
    public String blog() {
        return "client/blog_home";
    }
}
