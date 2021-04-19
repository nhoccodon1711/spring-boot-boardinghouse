package com.chothuenhatro.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blogcategory")
public class BlogCategoryEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String code;

    @OneToMany(mappedBy = "blogCategory", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BlogEntity> blogs = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<BlogEntity> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogEntity> blogs) {
        this.blogs = blogs;
    }
}
