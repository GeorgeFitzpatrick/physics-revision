package com.georgefitzpatrick.revision.physics.data.repository;

import com.georgefitzpatrick.revision.physics.data.ReadOnlyRepository;
import com.georgefitzpatrick.revision.physics.data.entity.SubChapter;
import org.springframework.stereotype.Repository;

@Repository
public interface SubChapterRepository extends ReadOnlyRepository<SubChapter, Long> {

}
