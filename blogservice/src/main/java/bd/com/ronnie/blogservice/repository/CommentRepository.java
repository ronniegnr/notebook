package bd.com.ronnie.blogservice.repository;

import bd.com.ronnie.blogservice.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
