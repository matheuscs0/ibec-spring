package com.ibec.spring.api.models.livros;

import com.ibec.spring.api.models.autor.DadosCadastrarAutor;
import com.ibec.spring.api.models.editora.DadosCadastrarEditora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarLivro(
        @NotBlank
        String nome,
        DadosCadastrarAutor autor,
        DadosCadastrarEditora editora,
        int edicao,
        @NotNull
        int numeroDePaginas,
        @NotNull
        long isbn
) {}
