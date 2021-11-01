package com.example.blog.homework.repositories;

import com.example.blog.homework.models.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BlogUser, String> {


}
