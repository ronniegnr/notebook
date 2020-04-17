package bd.com.ronnie.blogservice.dto;

import bd.com.ronnie.blogservice.entity.Post;
import bd.com.ronnie.blogservice.entity.Tag;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class HomePagePost {

    private Long id;
    private String title;
    private String topSummary;
    private String content;
    private String author;
    private Long authorId;
    private Instant createdAt;
    private List<Tag> tags;

    private HomePagePost() {
    }

    // etake abstract class a pathai deya jai
    public static HomePagePost from(Post post) {
        HomePagePost homePagePost = new HomePagePost();
        homePagePost.id = post.getId();
        homePagePost.title = post.getTitle();
        homePagePost.topSummary = post.getTopSummary();
        homePagePost.content = post.getContent();
        homePagePost.author = post.getUser().getName();
        homePagePost.authorId = post.getUser().getId();
        homePagePost.createdAt = post.getCreatedAt();
        homePagePost.tags = post.getTags();
        return homePagePost;
    }

    // ai functionality multiple dto er jonno common, common kono class a niye jaua jai
    public static List<HomePagePost> from(List<Post> posts) {
        return posts.stream()
                .map(HomePagePost::from)
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

    public String getContent() {
        return content;
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
