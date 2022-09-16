package com.itlize.joole.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itlize.joole.entity.enums.ProjectType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProjectType type;
    @Column(name = "size")
    private Integer size;
    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;
    @LastModifiedDate
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(targetEntity = ProjectProduct.class, cascade = CascadeType.MERGE, mappedBy = "product")
    private Collection<ProjectProduct> projectProducts = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<ProjectProduct> getProjectProducts() {
        return projectProducts;
    }

    public void setProjectProducts(Collection<ProjectProduct> projectProducts) {
        this.projectProducts = projectProducts;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", size=" + size +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", user=" + user +
                ", projectProducts=" + projectProducts +
                '}';
    }
}
