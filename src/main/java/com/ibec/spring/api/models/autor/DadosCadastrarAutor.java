package com.ibec.spring.api.models.autor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarAutor (
        @NotBlank
        String nome,
        String resumo
) {
}
