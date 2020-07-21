package bd.com.ronnie.blogservice.model;

import bd.com.ronnie.blogservice.domain.Post;
import bd.com.ronnie.blogservice.domain.Tag;
import bd.com.ronnie.blogservice.utility.DateTimeUtility;

import java.util.List;
import java.util.stream.Collectors;

public class BlogHomePost {

    private Long id;
    private String title;
    private String topSummary;
    private String authorName;
    private Long authorId;

    private String postDate;
    private List<Tag> tags;

    private BlogHomePost() {
    }

    public static BlogHomePost from(Post post) {
        BlogHomePost blogHomePost = new BlogHomePost();
        blogHomePost.id = post.getId();
        blogHomePost.title = post.getTitle();
        blogHomePost.topSummary = post.getTopSummary();
        blogHomePost.authorName = post.getUser().getName();
        blogHomePost.authorId = post.getUser().getId();
        blogHomePost.postDate = DateTimeUtility.fromInstant(post.getCreatedAt());
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

    public String getAuthorName() {
        return authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getPostDate() {
        return postDate;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
