package com.codeup.blog.repository;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title); // select * from posts where title = ?
    Post findFirstByTitle(String title); //  select * from posts where title = ? limit 1
    Post getPostById(long id); // select * from posts where id like ?
    Post getId(long id);
}
