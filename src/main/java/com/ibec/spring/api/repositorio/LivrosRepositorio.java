package com.ibec.spring.api.repositorio;

import com.ibec.spring.api.models.livros.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivrosRepositorio extends JpaRepository<Livros, Long> {
    List<Livros> findByAutorNomeContainingIgnoreCase(String autorNome);
    List<Livros> findByEditoraNomeContainingIgnoreCase(String editoraNome);
}
