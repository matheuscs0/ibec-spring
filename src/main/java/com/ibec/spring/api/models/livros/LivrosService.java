package com.ibec.spring.api.models.livros;

import com.ibec.spring.api.repositorio.LivrosRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivrosService {
    private final LivrosRepositorio livrosRepository;

    public LivrosService(LivrosRepositorio livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public List<LivrosList> buscarPorNomeAutor(String nomeAutor) {
        return livrosRepository.findByAutorNomeContainingIgnoreCase(nomeAutor).stream()
                .map(LivrosList::new)
                .collect(Collectors.toList());
    }

    public List<LivrosList> buscarPorNomeEditora(String nomeEditora) {
        return livrosRepository.findByEditoraNomeContainingIgnoreCase(nomeEditora).stream()
                .map(LivrosList::new)
                .collect(Collectors.toList());
    }
}
