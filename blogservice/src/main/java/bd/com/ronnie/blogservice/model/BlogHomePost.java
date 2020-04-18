package bd.com.ronnie.blogservice.model;

import bd.com.ronnie.blogservice.entity.Post;
import bd.com.ronnie.blogservice.entity.Tag;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class BlogHomePost {

    private Long id;
    private String title;
    private String topSummary;
    private String author;
    private Long authorId;
    private Instant createdAt;
    private List<Tag> tags;

    private BlogHomePost() {
    }

    public static BlogHomePost from(Post post) {
        BlogHomePost blogHomePost = new BlogHomePost();
        blogHomePost.id = post.getId();
        blogHomePost.title = post.getTitle();
        blogHomePost.topSummary = post.getTopSummary();
        blogHomePost.author = post.getUser().getName();
        blogHomePost.authorId = post.getUser().getId();
        blogHomePost.createdAt = post.getCreatedAt();
        blogHomePost.tags = post.getTags();
        return blogHomePost;
    }

    public static List<BlogHomePost> from(List<Post> posts) {
        return posts.stream()
                .map(BlogHomePost::from)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTopSummary() {
        return topSummary;
    }

    public String getAuthor() {
        return author;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
