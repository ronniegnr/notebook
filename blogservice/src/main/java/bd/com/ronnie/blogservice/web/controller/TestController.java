package bd.com.ronnie.blogservice.web.controller;

import bd.com.ronnie.blogservice.domain.Comment;
import bd.com.ronnie.blogservice.repository.CommentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final CommentRepository tagRepository;

    public TestController(CommentRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @GetMapping("comment-create")
    public Comment createTag() {
        Comment comment = Comment.newObjectWithDefaults();
        comment.setContent("First content");
        tagRepository.save(comment);

        return comment;
    }
}
