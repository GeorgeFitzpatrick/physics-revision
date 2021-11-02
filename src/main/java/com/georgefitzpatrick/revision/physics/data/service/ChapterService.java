package com.georgefitzpatrick.revision.physics.data.service;

import com.georgefitzpatrick.revision.physics.data.entity.Chapter;
import com.georgefitzpatrick.revision.physics.data.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChapterService {

    private final ChapterRepository repository;

    @Autowired
    public ChapterService(ChapterRepository repository) {
        this.repository = repository;
    }

    public Set<Chapter> findAll() {
        return repository.findAll();
    }

    public Chapter findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
