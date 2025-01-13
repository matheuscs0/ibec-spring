package com.ibec.spring.api.models.blogs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "blogs")
@Entity(name = "Blog")

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Lob
    private String resumo;

    private String autor;

    private LocalDateTime data;

    public Blogs(DadosCadastrarBlog dados) {
        this.titulo = dados.titulo();
        this.resumo = dados.resumo();
        this.autor = dados.autor();
        this.data = LocalDateTime.now();
    }

    public Blogs() {
    }

    @PrePersist
    protected void onCreate() {
        if (this.data == null) {
            this.data = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}

