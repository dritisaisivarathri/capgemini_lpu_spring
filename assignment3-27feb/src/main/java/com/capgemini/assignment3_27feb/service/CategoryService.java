package com.capgemini.assignment3_27feb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.assignment3_27feb.dao.Category;
import com.capgemini.assignment3_27feb.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category save(Category c) {
        return repo.save(c);
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Category getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
