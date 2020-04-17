package bd.com.ronnie.blogservice.repository;

import bd.com.ronnie.blogservice.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findByStatus(Post.Status status, Pageable pageable);

}
