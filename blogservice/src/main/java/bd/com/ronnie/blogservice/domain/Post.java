package bd.com.ronnie.blogservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Post extends AbstractAuditingEntity {

    @NotNull
    @Size(min = 5, max = 1023)
    private String title;

    @NotNull
    @Size(min = 5, max = 2047)
    private String topSummary;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String content;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "post_tag", joinColumns = {@JoinColumn(name = "post_id", insertable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "tag_id", insertable = false, updatable = false)})
    private List<Tag> tags;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    private int commentCount;

    private Post() {
    }

    public Post newObjectWithDefaults() {
        Post post = new Post();
        post.status = Status.ACTIVE;
        return post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopSummary() {
        return topSummary;
    }

    public void setTopSummary(String topSummary) {
        this.topSummary = topSummary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String value) {
        this.content = value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public enum Status {ACTIVE, INACTIVE}

}
