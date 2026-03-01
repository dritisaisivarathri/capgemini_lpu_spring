package com.capgemini.assignment3_27feb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assignment3_27feb.dao.Category;
import com.capgemini.assignment3_27feb.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    // 1️⃣ Add Category
    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category c) {
        return service.save(c);
    }

    // 2️⃣ Get All Categories
    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return service.getAll();
    }

    // 3️⃣ Get Category By Id
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id) {
        return service.getById(id);
    }

    // 4️⃣ Delete Category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable int id) {
        service.delete(id);
        return "Category Deleted";
    }
}
