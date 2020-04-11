package bd.com.ronnie.blogservice.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    public enum Status {ACTIVE, INACTIVE}

    private int id;
    private String title;
    private String value;
    private Status status;
    private Timestamp created;
    private Timestamp updated;

    private User user;
    private List<Tag> tags;
    private List<Comment> comments;

    private int valueShort;
    private int commentCount;

    public Post() {
        this.status = Status.ACTIVE;
        this.created = this.updated = new Timestamp(new Date().getTime());
    }

    @Id
    @NotNull
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 10, max = 2047)
    @Column(name = "title", columnDefinition = "varchar(2047)")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    @Column(name = "value", columnDefinition = "TEXT")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @NotNull
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @NotNull
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @Column(name = "updated")
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    @JoinTable(name = "post_tag", joinColumns = {@JoinColumn(name = "post_id", insertable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "tag_id", insertable = false, updatable = false)})
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @OneToMany(mappedBy = "post")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Transient
    public String getValueShort() {
        int valueLength = getValue().length();
        return getValue().substring(0, valueLength > 800 ? 800 : valueLength) + "...";
    }

    @Transient
    public int getCommentCount() {
        return getComments().size();
    }

}
