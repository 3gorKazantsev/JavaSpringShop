package com.example.springboot.service.hibernate;

import com.example.springboot.model.hibernate.CategoryH;
import com.example.springboot.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceHTest {

    @Mock
    private CategoryRepository categoryRepository;
    private CategoryServiceH underTest;

    @BeforeEach
    void setUp() {
        underTest = new CategoryServiceH(categoryRepository);
    }

    @Test
    void getAllCategory() {
        // when
        underTest.getAllCategory();
        // then
        verify(categoryRepository).findAll();
    }

    @Test
    @Disabled
    void getCategoryById() {
    }

    @Test
    void createCategory() {
        CategoryH category = new CategoryH("some name");
        underTest.createCategory(category);
        ArgumentCaptor<CategoryH> categoryHArgumentCaptor = ArgumentCaptor.forClass(CategoryH.class);
        verify(categoryRepository).save(categoryHArgumentCaptor.capture());
        CategoryH capCategory = categoryHArgumentCaptor.getValue();
        assertThat(capCategory).isEqualTo(category);
    }

    @Test
    @Disabled
    void updateCategory() {
    }

    @Test
    @Disabled
    void deleteCategoryById() {
    }
}