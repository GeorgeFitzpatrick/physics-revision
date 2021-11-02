package com.georgefitzpatrick.revision.physics.data.repository;

import com.georgefitzpatrick.revision.physics.data.ReadOnlyRepository;
import com.georgefitzpatrick.revision.physics.data.entity.Module;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends ReadOnlyRepository<Module, Long> {

}
