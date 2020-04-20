package bd.com.ronnie.blogservice.web.controller;

import bd.com.ronnie.blogservice.dto.BlogHomePagedPosts;
import bd.com.ronnie.blogservice.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static bd.com.ronnie.blogservice.constant.ViewConstants.BLOG_HOME_VIEW;
import static bd.com.ronnie.blogservice.constant.ViewConstants.BLOG_POST_VIEW;

@Controller
@RequestMapping("blog")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public String blog(@RequestParam(defaultValue = "0") int page, Model model) {
        BlogHomePagedPosts blogHomePagedPosts = blogService.getBlogHomePagedPosts(page);
        model.addAttribute("blogHomePagedPosts", blogHomePagedPosts);
        return BLOG_HOME_VIEW;
    }

    @GetMapping("post/{post_title}/{post_id}")
    public String blog_post(@PathVariable(name = "post_id") Long postId, Model model) {
        return BLOG_POST_VIEW;
    }

}
