package br.com.loja.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.loja.backend.entity.Category;
import br.com.loja.backend.repository.CategoryRepository;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category register(Category category) {
        category.setCreationdate(new Date());
        Category newCategory = categoryRepository.saveAndFlush(category);
        return newCategory;
    }

    public Category update(Category category) {
        category.setUpdatedate(new Date());
        return categoryRepository.saveAndFlush(category);
    }

    public void delete(Long id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }

}
