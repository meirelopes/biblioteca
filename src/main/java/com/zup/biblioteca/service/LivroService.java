package com.zup.biblioteca.service;

import com.zup.biblioteca.model.LivroModel;
import com.zup.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public List<LivroModel> getAllLivros() {
        return livroRepository.findAll();
    }

    public Optional<LivroModel> getLivroById(Long id) {
        return livroRepository.findById(id);
    }

    public LivroModel createLivro(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public LivroModel updateLivro(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
