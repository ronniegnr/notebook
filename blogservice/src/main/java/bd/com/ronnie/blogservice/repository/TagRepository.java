package bd.com.ronnie.blogservice.repository;

import bd.com.ronnie.blogservice.domain.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
}
