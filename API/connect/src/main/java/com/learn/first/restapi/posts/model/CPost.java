package com.learn.first.restapi.posts.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private CUser createdBy;

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
}
