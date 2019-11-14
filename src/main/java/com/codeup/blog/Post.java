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
    @Column(columnDefinition = "int(11) UNSIGNED", nullable=false)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "text", nullable =false)
    private String body;

//    @OneToOne
//    private PostDetails postDetails;
//
//    public Post(long id, String title, String description) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//    }

//    @ManyToMany(mappedBy = "posts", cascade = CascadeType.ALL)
//    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post() { }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
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

    public String getBody() {
        return body;
    }

    public void setBody(String description) {
        this.body = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
}
