package com.ibec.spring.api.repositorio;

import com.ibec.spring.api.models.blogs.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogsRepositorio extends JpaRepository<Blogs, Long> {
}
