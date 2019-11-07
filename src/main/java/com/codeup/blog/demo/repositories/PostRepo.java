package com.codeup.blog.demo.repositories;

import com.codeup.blog.demo.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {

}
