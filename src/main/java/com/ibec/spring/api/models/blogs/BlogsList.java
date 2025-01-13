package com.ibec.spring.api.models.blogs;

import java.time.LocalDateTime;

public record BlogsList(Long id, String titulo, String resumo, String autor, LocalDateTime data){
    public BlogsList (Blogs blogs){
        this(
                blogs.getId(), blogs.getTitulo(), blogs.getResumo(), blogs.getAutor(), blogs.getData()
        );
    }
}
