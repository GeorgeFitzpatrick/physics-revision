package com.georgefitzpatrick.revision.physics.data.service;

import com.georgefitzpatrick.revision.physics.data.entity.SubChapter;
import com.georgefitzpatrick.revision.physics.data.repository.SubChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubChapterService {

    private final SubChapterRepository repository;

    @Autowired
    public SubChapterService(SubChapterRepository repository) {
        this.repository = repository;
    }

    public Set<SubChapter> findAll() {
        return repository.findAll();
    }

    public SubChapter findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
