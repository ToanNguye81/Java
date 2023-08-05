package com.learn.first.restapi.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class CUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @NotNull(message = "Nhập userName")
    @Size(min = 2, message = "user name phải có ít nhất 2 ký tự ")
    @Column(name = "user_name", unique = true)
    private String userName;

    @NotNull(message = "Nhập first Name")
    @Size(min = 2, message = "first name phải có ít nhất 2 ký tự ")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Nhập last Name")
    @Size(min = 2, message = "last name phải có ít nhất 2 ký tự ")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Nhập phone")
    @Size(min = 10, message = "Phone phải la 10 ký tự ")
    @Column(name = "phone")
    private String phone;

    // Khai báo kiểu quan hệ 1-n => user-post
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "createdBy")
    private Set<CPost> posts;

    // Khai báo kiểu quan hệ 1-1 => user-profile
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    @JsonIgnore
    private CProfile profile;

    public CUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosts(Set<CPost> posts) {
        this.posts = posts;
    }

    public void setProfile(CProfile profile) {
        this.profile = profile;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<CPost> getPosts() {
        return posts;
    }

    public String getUserName() {
        return userName;
    }

    public CProfile getProfile() {
        return profile;
    }
}
