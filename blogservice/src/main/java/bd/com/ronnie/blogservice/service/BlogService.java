package bd.com.ronnie.blogservice.service;

import bd.com.ronnie.blogservice.dto.BlogHomePagedPosts;
import bd.com.ronnie.blogservice.entity.Post;
import bd.com.ronnie.blogservice.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final PostRepository postRepository;

    public BlogService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public BlogHomePagedPosts getBlogHomePagedPosts(Pageable pageable) {
        Page<Post> postPage = postRepository.findByStatus(Post.Status.ACTIVE, pageable);
        return BlogHomePagedPosts.newFromPosts(postPage);
    }

}
