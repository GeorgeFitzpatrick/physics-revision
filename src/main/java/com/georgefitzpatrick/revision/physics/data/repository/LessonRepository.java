package com.georgefitzpatrick.revision.physics.data.repository;

import com.georgefitzpatrick.revision.physics.data.ReadOnlyRepository;
import com.georgefitzpatrick.revision.physics.data.entity.Lesson;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends ReadOnlyRepository<Lesson, Long> {

}