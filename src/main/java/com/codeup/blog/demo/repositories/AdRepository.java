package com.codeup.blog.demo.repositories;

import com.codeup.blog.demo.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {



}
