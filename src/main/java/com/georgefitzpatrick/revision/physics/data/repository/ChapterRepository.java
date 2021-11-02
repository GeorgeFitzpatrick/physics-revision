package com.georgefitzpatrick.revision.physics.data.repository;

import com.georgefitzpatrick.revision.physics.data.ReadOnlyRepository;
import com.georgefitzpatrick.revision.physics.data.entity.Chapter;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends ReadOnlyRepository<Chapter, Long> {

}