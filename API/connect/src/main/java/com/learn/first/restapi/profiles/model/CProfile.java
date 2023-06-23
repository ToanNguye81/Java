package com.learn.first.restapi.profiles.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.first.restapi.users.model.CUser;

@Entity
@Table(name = "profiles")
public class CProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "")
    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "day_of_birth", nullable = true, updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;

    @Column(name = "")
    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private CUser user;

    public CProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public CUser getUser() {
        return user;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUser(CUser user) {
        this.user = user;
    }
}
