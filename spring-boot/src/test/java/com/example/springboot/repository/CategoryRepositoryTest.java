package com.example.springboot.repository;

import com.example.springboot.model.hibernate.CategoryH;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository underTest;

    @Test
    void getCategoryCountWithNameHi() {
        // given
        CategoryH category = new CategoryH("HI");
        underTest.save(category);
        // when
        int expected = underTest.getCategoryCountWithNameHi();
        // then
        assertThat(expected).isEqualTo(1);
    }

    @Test
    void findByNameEqualsTest() {
        CategoryH category = new CategoryH("some name");
        underTest.save(category);

        List<CategoryH> list = underTest.findByNameEquals("some name");

        assertThat(list).isNotNull();
    }
}
