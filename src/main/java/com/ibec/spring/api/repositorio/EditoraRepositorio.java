package com.ibec.spring.api.repositorio;

import com.ibec.spring.api.models.editora.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditoraRepositorio extends JpaRepository<Editora, Long> {
    Optional<Editora> findByNome(String nome);
}
