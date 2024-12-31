package com.ibec.spring.api.models.editora;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ibec.spring.api.models.livros.Livros;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "editoras")
@Entity(name = "Editora")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Livros> livros = new ArrayList<>();

    public Editora(String nome) {
        this.nome = nome;
    }

    public Editora() {
    }

    public Editora(Long id, String nome) {
    }

    // Getters e Setters
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

    public List<Livros> getLivros() {
        return livros;
    }

    public void setLivros(List<Livros> livros) {
        this.livros = livros;
    }
}
