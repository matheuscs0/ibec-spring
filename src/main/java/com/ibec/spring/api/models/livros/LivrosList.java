package com.ibec.spring.api.models.livros;

import com.ibec.spring.api.models.autor.AutorDTO;
import com.ibec.spring.api.models.editora.EditoraDTO;

public record LivrosList(Long id, String nome, AutorDTO autor, int edicao, EditoraDTO editora, int numeroDePaginas, long isbn) {
    public LivrosList(Livros livros) {
        this(
                livros.getId(),
                livros.getNome(),
                new AutorDTO(livros.getAutor().getId(), livros.getAutor().getNome(), livros.getAutor().getResumo()),
                livros.getEdicao(),
                new EditoraDTO(livros.getEditora().getId(), livros.getEditora().getNome()),
                livros.getNumerodePaginas(),
                livros.getIsbn()
        );
    }
}
