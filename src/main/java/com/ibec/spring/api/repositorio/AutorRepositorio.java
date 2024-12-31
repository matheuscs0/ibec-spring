package com.ibec.spring.api.repositorio;

import com.ibec.spring.api.models.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String nome);
}
