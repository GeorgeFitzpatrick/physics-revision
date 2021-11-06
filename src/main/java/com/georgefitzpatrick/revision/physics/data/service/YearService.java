package com.georgefitzpatrick.revision.physics.data.service;

import com.georgefitzpatrick.revision.physics.data.entity.Year;
import com.georgefitzpatrick.revision.physics.data.repository.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class YearService {

    private final YearRepository repository;

    @Autowired
    public YearService(YearRepository repository) {
        this.repository = repository;
    }

    public Set<Year> findAll() {
        return repository.findAll();
    }

    public Year findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
