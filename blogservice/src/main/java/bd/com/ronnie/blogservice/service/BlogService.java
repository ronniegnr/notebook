package bd.com.ronnie.blogservice.service;

import bd.com.ronnie.blogservice.dto.HomePagePost;
import bd.com.ronnie.blogservice.entity.Post;
import bd.com.ronnie.blogservice.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final PostRepository postRepository;

    public BlogService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /*public Page<HomePagePost> getBlogHomePosts(Pageable pageable) {
        Page<Post> postPage = postRepository.findByStatus(Post.Status.ACTIVE, pageable);
//        postPage.
//                Page<HomePagePost> homePagePostPage = new PageImpl<HomePagePost>(());


        postPage.getTotalElements();
        postPage.getNumber();
        postPage.getNumberOfElements();
        postPage.getSize();

    }*/

}
