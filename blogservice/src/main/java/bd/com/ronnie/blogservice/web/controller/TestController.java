package bd.com.ronnie.blogservice.web.controller;

import bd.com.ronnie.blogservice.entity.Comment;
import bd.com.ronnie.blogservice.entity.Tag;
import bd.com.ronnie.blogservice.repository.CommentRepository;
import bd.com.ronnie.blogservice.repository.TagRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;

    public TestController(CommentRepository commentRepository, TagRepository tagRepository) {
        this.commentRepository = commentRepository;
        this.tagRepository = tagRepository;
    }

    @GetMapping("comment-create")
    public Comment createTag() {
        Comment comment = Comment.newObjectWithDefaults();
        comment.setContent("First content");
        commentRepository.save(comment);

        return comment;
    }

    @GetMapping("get-tags")
    public Iterable<Tag> getTags() {
        return tagRepository.findAll();
    }
}
