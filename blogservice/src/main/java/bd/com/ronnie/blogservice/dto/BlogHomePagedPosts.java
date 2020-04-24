package bd.com.ronnie.blogservice.dto;

import bd.com.ronnie.blogservice.entity.Post;
import bd.com.ronnie.blogservice.model.BlogHomePost;
import bd.com.ronnie.blogservice.model.Pager;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

import static bd.com.ronnie.blogservice.constant.URLConstants.POST_DETAIL_URL_PART;
import static bd.com.ronnie.blogservice.constant.URLConstants.POST_HOME_URL_WITH_PAGE;

public class BlogHomePagedPosts {

    private List<BlogHomePost> blogHomePosts;
    private Pager<Post> pager;
    private String postDetailURLPart;

    private BlogHomePagedPosts() {
    }

    public static BlogHomePagedPosts newFromPosts(Page<Post> postPage) {
        BlogHomePagedPosts blogHomePagedPosts = new BlogHomePagedPosts();
        blogHomePagedPosts.blogHomePosts = postPage.get()
                .map(BlogHomePost::from)
                .collect(Collectors.toList());
        blogHomePagedPosts.pager = new Pager<>(postPage, POST_HOME_URL_WITH_PAGE);
        blogHomePagedPosts.postDetailURLPart = POST_DETAIL_URL_PART;
        return blogHomePagedPosts;
    }

    public List<BlogHomePost> getBlogHomePosts() {
        return blogHomePosts;
    }

    public Pager getPager() {
        return pager;
    }

    public String getPostDetailURLPart() {
        return postDetailURLPart;
    }

}
