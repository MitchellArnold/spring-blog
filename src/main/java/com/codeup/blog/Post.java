package com.codeup.blog;

import org.aspectj.apache.bcel.generic.Tag;

import javax.persistence.*;
import java.awt.image.ImageProducer;
import java.util.List;

    @Entity
    @Table(
            name = "posts"
    )

public class Post {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(nullable=false, columnDefinition = "int(11) UNSIGNED")
    private long id;


    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT ")
    private String description;

//    @OneToOne
//    private PostDetails postDetails;
//
    public Post(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

//    @ManyToMany(mappedBy = "posts", cascade = CascadeType.ALL)
//    private List<Tag> tags;

//    @ManyToOne(mappedBy = "posts", cascade = CascadeType.ALL)
//    private List<User> user;

    public Post(){}

    public Post(String author, String title, String content) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public PostDetails getPostDetails() {
//        return postDetails;
//    }
//
//    public void setPetDetails(PostDetails petDetails) {
//        this.postDetails = petDetails;
//    }

}
