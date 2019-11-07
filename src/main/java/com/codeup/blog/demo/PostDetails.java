package com.codeup.blog.demo;

import javax.persistence.*;

@Entity
@Table(
        name = "post_details"
)

public class PostDetails {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition="int(11) UNSIGNED")
    private long id;


    @Column(nullable = false, columnDefinition = "boolean")
    private boolean isAwesome;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String historyOfPost;

    @Column(columnDefinition = "TEXT")
    private String topicDescription;

    @OneToOne(mappedBy = "postDetails")
    private Post post;

    public PostDetails(long id, boolean isAwesome, String historyOfPost, String topicDescription) {
        this.id = id;
        this.isAwesome = isAwesome;
        this.historyOfPost = historyOfPost;
        this.topicDescription = topicDescription;
    }

    public PostDetails(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public String getHistoryOfPost() {
        return historyOfPost;
    }

    public void setHistoryOfPost(String historyOfPost) {
        this.historyOfPost = historyOfPost;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
