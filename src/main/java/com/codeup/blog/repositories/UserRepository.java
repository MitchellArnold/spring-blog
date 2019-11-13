//package com.codeup.blog.demo.repositories;
//
//import com.codeup.blog.demo.Ad;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<Ad, Long>{
//
//
//}

package com.codeup.blog.repositories;

import com.codeup.blog.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

//    void save();
}
