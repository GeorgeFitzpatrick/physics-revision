package com.georgefitzpatrick.revision.physics.data.repository;

import com.georgefitzpatrick.revision.physics.data.ReadOnlyRepository;
import com.georgefitzpatrick.revision.physics.data.entity.Year;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends ReadOnlyRepository<Year, Long> {

}