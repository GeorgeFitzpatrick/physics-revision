package com.georgefitzpatrick.revision.physics.data.repository;

import com.georgefitzpatrick.revision.physics.data.ReadOnlyRepository;
import com.georgefitzpatrick.revision.physics.data.entity.Flashcards;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardsRepository extends ReadOnlyRepository<Flashcards, Long> {

}