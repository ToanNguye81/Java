package com.learn.first.restapi.posts.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.learn.first.restapi.hashTags.model.CHashTag;
import com.learn.first.restapi.users.model.CUser;

@Entity
@Table(name = "posts")
public class CPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @NotNull(message = "Nhập title")
    @Size(min = 2, message = "Title phải có ít nhất 2 ký tự ")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Nhập content")
    @Size(min = 2, message = "Countent phải có ít nhất 2 ký tự ")
    @Column(name = "content")
    private String content;

    // Khai báo kiểu quan hệ n-1 => post-user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private CUser createdBy;

    // Khai báo kiểu quan hệ n-n => Post-Tag
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "posts_tags", joinColumns = { @JoinColumn(name = "post_id") }, inverseJoinColumns = {
            @JoinColumn(name = "tag_id") })
    private Set<CHashTag> tags;

    public CPost() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CUser getCreatedBy() {
        return createdBy;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<CHashTag> getTags() {
        return tags;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreatedBy(CUser createdBy) {
        this.createdBy = createdBy;
    }

    public void setTags(Set<CHashTag> tags) {
        this.tags = tags;
    }

}
