package bd.com.ronnie.blogservice.web.controller;

import bd.com.ronnie.blogservice.dto.BlogHomePagedPosts;
import bd.com.ronnie.blogservice.dto.PostDetail;
import bd.com.ronnie.blogservice.exception.ResourceNotFoundException;
import bd.com.ronnie.blogservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static bd.com.ronnie.blogservice.constant.ViewConstants.POSTS_DETAIL_VIEW;
import static bd.com.ronnie.blogservice.constant.ViewConstants.POSTS_HOME_VIEW;

@Controller
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // TODO : author tag based filtering ai method er modhe add korte hobe
    @GetMapping("")
    public String getBlog(@RequestParam(defaultValue = "0") int page, Model model) {
        BlogHomePagedPosts blogHomePagedPosts = postService.getBlogHomePagedPosts(page);
        model.addAttribute("blogHomePagedPosts", blogHomePagedPosts);
        return POSTS_HOME_VIEW;
    }

    @GetMapping("{post_id}")
    public String blog_post(@PathVariable(name = "post_id") Long postId, Model model) throws ResourceNotFoundException {
        PostDetail postDetail = postService.getPostDetail(postId);
        model.addAttribute("postDetail", postDetail);
        return POSTS_DETAIL_VIEW;
    }

}
