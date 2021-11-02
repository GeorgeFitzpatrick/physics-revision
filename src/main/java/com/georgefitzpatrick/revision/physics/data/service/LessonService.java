package com.georgefitzpatrick.revision.physics.data.service;

import com.georgefitzpatrick.revision.physics.data.entity.Lesson;
import com.georgefitzpatrick.revision.physics.data.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LessonService {

    private final LessonRepository repository;

    @Autowired
    public LessonService(LessonRepository repository) {
        this.repository = repository;
    }

    public Set<Lesson> findAll() {
        return repository.findAll();
    }

    public Lesson findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
