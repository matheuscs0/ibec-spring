package com.ibec.spring.api.controller;

import com.ibec.spring.api.models.autor.Autor;
import com.ibec.spring.api.models.autor.DadosCadastrarAutor;
import com.ibec.spring.api.models.editora.Editora;
import com.ibec.spring.api.models.livros.DadosCadastrarLivro;
import com.ibec.spring.api.models.livros.Livros;
import com.ibec.spring.api.models.livros.LivrosList;
import com.ibec.spring.api.models.livros.LivrosService;
import com.ibec.spring.api.repositorio.AutorRepositorio;
import com.ibec.spring.api.repositorio.EditoraRepositorio;
import com.ibec.spring.api.repositorio.LivrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivrosController {
    private final LivrosService livrosService;

    public LivrosController(LivrosService livrosService) {
        this.livrosService = livrosService;
    }

    @Autowired
    private LivrosRepositorio repository;

    @Autowired
    private AutorRepositorio autorRepository;

    @Autowired
    private EditoraRepositorio editoraRepository;

    @GetMapping
    public ResponseEntity<Page<LivrosList>> obterLivros(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina){

        var page = repository.findAll(pagina).map(LivrosList::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/autor/{nome}")
    public List<LivrosList> buscarPorNomeAutor(@PathVariable String nomeAutor) {
        return livrosService.buscarPorNomeAutor(nomeAutor);
    }

    @GetMapping("/editora/{nomeEditora}")
    public List<LivrosList> buscarPorNomeEditora(@PathVariable String nomeEditora) {
        return livrosService.buscarPorNomeEditora(nomeEditora);
    }

    @PostMapping
    public ResponseEntity<Livros> cadastrarLivro(@RequestBody DadosCadastrarLivro dados) {
        // Busca ou cria o autor
        Autor autor = autorRepository.findByNome(dados.autor().nome())
                .orElseGet(() -> {
                    Autor novoAutor = new Autor(new DadosCadastrarAutor(dados.autor().nome(), dados.autor().resumo()));
                    autorRepository.save(novoAutor);
                    return novoAutor;
                });

        // Busca ou cria a editora
        Editora editora = editoraRepository.findByNome(dados.editora().nome())
                .orElseGet(() -> {
                    Editora novaEditora = new Editora(dados.editora().nome());
                    editoraRepository.save(novaEditora);
                    return novaEditora;
                });

        // Cria e salva o livro
        Livros livro = new Livros(dados.nome(), autor, editora, dados.edicao(), dados.numeroDePaginas(), dados.isbn());
        repository.save(livro);

        return ResponseEntity.ok(livro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivrosList> obterLivroPorID(@PathVariable Long id){
        var livro = repository.findById(id);
        if(livro.isPresent()) {
            var livroList = new LivrosList(livro.get());
            return ResponseEntity.ok(livroList);
        }
        return ResponseEntity.notFound().build();
    }

}
