package com.chothuenhatro.entity;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class BlogEntity extends BaseEntity {

    @Column(length = 1000)
    private String title;

    @Column
    private String thumbnail;

    @Column(name = "shortdescription", columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "blogcategoryid")
    private BlogCategoryEntity blogCategory;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BlogCategoryEntity getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(BlogCategoryEntity blogCategory) {
        this.blogCategory = blogCategory;
    }
}
