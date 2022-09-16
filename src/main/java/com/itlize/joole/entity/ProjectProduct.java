package com.itlize.joole.entity;

import javax.persistence.*;

@Entity
@Table(name = "projectproduct")
public class ProjectProduct {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    // Not use all, but detach
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProjectProduct{" +
                "id=" + id +
                ", project=" + project +
                ", product=" + product +
                '}';
    }
}
