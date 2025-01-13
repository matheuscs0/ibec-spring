package com.ibec.spring.api.models.blogs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastrarBlog(
        @NotBlank
        String titulo,
        @NotBlank
        String resumo,
        @NotBlank
        String autor
) {
}
