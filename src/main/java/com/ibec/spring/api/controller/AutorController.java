package com.ibec.spring.api.controller;

import com.ibec.spring.api.models.autor.Autor;
import com.ibec.spring.api.models.autor.DadosCadastrarAutor;
import com.ibec.spring.api.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepositorio repository;

    @PostMapping()
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody DadosCadastrarAutor dados) {
        Autor novoAutor = new Autor(dados);
        repository.save(novoAutor);

        return ResponseEntity.ok(novoAutor);
    }
}
