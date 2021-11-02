package com.georgefitzpatrick.revision.physics.data.service;

import com.georgefitzpatrick.revision.physics.data.entity.Module;
import com.georgefitzpatrick.revision.physics.data.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ModuleService {

    private final ModuleRepository repository;

    @Autowired
    public ModuleService(ModuleRepository repository) {
        this.repository = repository;
    }

    public Set<Module> findAll() {
        return repository.findAll();
    }

    public Module findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
