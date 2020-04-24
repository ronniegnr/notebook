package bd.com.ronnie.blogservice.dto;

import bd.com.ronnie.blogservice.entity.Post;
import bd.com.ronnie.blogservice.entity.Tag;
import bd.com.ronnie.blogservice.utility.DateTimeUtility;

import java.time.Instant;
import java.util.List;

/**
 * Post entity view in post details page
 */
public class PostDetail {

    private Long id;
    private String title;
    private String content;
    private String authorName;
    private Long authorId;
    private List<Tag> tags;
    private String postDate;

    private PostDetail() {
    }

    public static PostDetail newFromPost(Post post) {
        PostDetail postDetail = new PostDetail();

        postDetail.id = post.getId();
        postDetail.title = post.getTitle();
        postDetail.content = post.getContent();
        postDetail.authorName = post.getUser().getName();
        postDetail.authorId = post.getUser().getId();
        postDetail.tags = post.getTags();
        postDetail.postDate = DateTimeUtility.fromInstant(post.getCreatedAt());

        return postDetail;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getPostDate() {
        return postDate;
    }

}
