package com.learn.first.restapi.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tags")
public class CHashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @NotNull(message = "Nhập hash Tag Name")
    @Size(min = 2, message = "hash Tag name phải có ít nhất 2 ký tự ")
    @Column(name = "name", unique = true)
    private String name;

    // Khai báo kiểu quan hệ n-n => hashTag-post
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "tags")
    private Set<CPost> posts;

    public CHashTag() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPosts(Set<CPost> posts) {
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public Set<CPost> getPosts() {
        return posts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
