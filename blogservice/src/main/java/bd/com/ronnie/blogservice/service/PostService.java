package bd.com.ronnie.blogservice.service;

import bd.com.ronnie.blogservice.dto.BlogHomePagedPosts;
import bd.com.ronnie.blogservice.dto.PostDetail;
import bd.com.ronnie.blogservice.entity.Post;
import bd.com.ronnie.blogservice.exception.ResourceNotFoundException;
import bd.com.ronnie.blogservice.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public BlogHomePagedPosts getBlogHomePagedPosts(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").descending()); // TODO refactor this to common place
        Page<Post> postPage = postRepository.findByStatus(Post.Status.ACTIVE, pageable);
        return BlogHomePagedPosts.newFromPosts(postPage);
    }

    public PostDetail getPostDetail(Long id) throws ResourceNotFoundException {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return PostDetail.newFromPost(optionalPost.get());
        } else {
            throw new ResourceNotFoundException("Post not found with id: " + id);
        }
    }

}
