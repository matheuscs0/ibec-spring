package com.ibec.spring.api.models.autor;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ibec.spring.api.models.livros.Livros;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "autores")
@Entity(name = "autor")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String nome;
    public String resumo;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Livros> livros = new ArrayList<>();

    public Autor() {
    }

    public void adicionarLivro(Livros livro) {
        livro.setAutor(this);
        this.livros.add(livro);
    }

    public void removerLivro(Livros livro) {
        livro.setAutor(null);
        this.livros.remove(livro);
    }

    public Autor(DadosCadastrarAutor dados) {
        this.nome = dados.nome();
        this.resumo = dados.resumo();
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

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }


    public List<Livros> getLivros() {
        return livros;
    }

    public void setLivros(List<Livros> livros) {
        this.livros = livros;
    }
}
