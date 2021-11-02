package com.georgefitzpatrick.revision.physics.data.service;

import com.georgefitzpatrick.revision.physics.Application;
import com.georgefitzpatrick.revision.physics.data.entity.Chapter;
import com.georgefitzpatrick.revision.physics.data.repository.ChapterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
public class ChapterServiceTest {

    @Autowired
    private ChapterRepository repository;

    @Test
    public void whenValidId_chapterShouldBeFound() {
        Long id = 1L;
        Chapter found = repository.findById(id).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getId()).isEqualTo(id);
    }

}
