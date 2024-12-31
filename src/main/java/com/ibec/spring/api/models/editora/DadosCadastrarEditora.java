package com.ibec.spring.api.models.editora;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarEditora(
        @NotBlank
        String nome
) {
}
