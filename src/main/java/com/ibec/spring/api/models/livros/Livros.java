package com.ibec.spring.api.models.livros;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ibec.spring.api.models.autor.Autor;
import com.ibec.spring.api.models.editora.Editora;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "livros")
@Entity(name = "Livro")

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    @JsonBackReference
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "editora_id", nullable = true)
    private Editora editora;
    public int edicao;
    public int numerodePaginas;
    public long isbn;

    public Livros(String nome, Autor autor, Editora editora, int edicao, int numeroDePaginas, long isbn) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.numerodePaginas = numeroDePaginas;
        this.isbn = isbn;
    }

    public Livros(){
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getNumerodePaginas() {
        return numerodePaginas;
    }

    public void setNumerodePaginas(int numerodePaginas) {
        this.numerodePaginas = numerodePaginas;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}
