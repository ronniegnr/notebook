package bd.com.ronnie.blogservice.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Tag extends AbstractAuditingEntity {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @Size(min = 1, max = 255)
    private String value;

    @NotNull
    private Integer postCount;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;

    protected Tag() {
    }

    public static Tag newObjectWithDefaults() {
        Tag tag = new Tag();
        tag.postCount = 0;
        return tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Transient
    public Integer getPostCount() {
        return getPosts().size();
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

}
