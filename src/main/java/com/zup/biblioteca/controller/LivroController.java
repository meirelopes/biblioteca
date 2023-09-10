package com.zup.biblioteca.controller;

import com.zup.biblioteca.model.LivroModel;
import com.zup.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/*
Exercício de fixação - Security


Implemente o Spring Security dentro da API Biblioteca Exercício de fixação!
Requisitos:
Conter pelo menos 2 roles para a aplicação;
Conter criptografia de senha;
Conter um controller para criar, visualizar e deletar novos usuários.
 */

@RestController
@RequestMapping(path = "/livros")  // <-- Mapeia geral ;)
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping
    public List<LivroModel> getAllLivros() {
        return livroService.getAllLivros();
    }

    @GetMapping(path = "/{id}")
    public Optional<LivroModel> getLivroById(@PathVariable Long id) {
        return livroService.getLivroById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroModel createLivro(@RequestBody LivroModel livroModel) {
        return livroService.createLivro(livroModel);
    }

    @PutMapping
    public LivroModel updateLivro(@RequestBody LivroModel livroModel) {
        return livroService.updateLivro(livroModel);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLivro(@PathVariable Long id) {
        livroService.deleteLivro(id);
    }
}
