package com.ibec.spring.api.controller;

import com.ibec.spring.api.models.blogs.Blogs;
import com.ibec.spring.api.models.blogs.BlogsList;
import com.ibec.spring.api.models.blogs.DadosCadastrarBlog;
import com.ibec.spring.api.models.livros.LivrosList;
import com.ibec.spring.api.repositorio.BlogsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    private BlogsRepositorio repository;

    @GetMapping
    public ResponseEntity<Page<BlogsList>> obterBlogs(@PageableDefault(size = 10, sort = {"titulo"}) Pageable pagina){

        var page = repository.findAll(pagina).map(BlogsList::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<Blogs> cadastrarBlog(@RequestBody DadosCadastrarBlog dados) {
        Blogs novoBlog = new Blogs(dados);
        repository.save(novoBlog);

        return ResponseEntity.ok(novoBlog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogsList> obterBlogPorID(@PathVariable Long id){
        var blog = repository.findById(id);
        if(blog.isPresent()) {
            var blogList = new BlogsList(blog.get());
            return ResponseEntity.ok(blogList);
        }
        return ResponseEntity.notFound().build();
    }

}
