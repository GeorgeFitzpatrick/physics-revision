package com.georgefitzpatrick.revision.physics.data.service;

import com.georgefitzpatrick.revision.physics.data.entity.Flashcards;
import com.georgefitzpatrick.revision.physics.data.repository.FlashcardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FlashcardsService {

    private final FlashcardsRepository repository;

    @Autowired
    public FlashcardsService(FlashcardsRepository repository) {
        this.repository = repository;
    }

    public Set<Flashcards> findAll() {
        return repository.findAll();
    }

    public Flashcards findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
