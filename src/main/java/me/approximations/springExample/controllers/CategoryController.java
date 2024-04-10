package me.approximations.springExample.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.approximations.springExample.dtos.CreateCategoryDTO;
import me.approximations.springExample.entities.Category;
import me.approximations.springExample.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Category>> findAll() {
        final List<Category> categories = categoryService.findAll();

        return ResponseEntity.ok(categories);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Category> create(@Valid @RequestBody CreateCategoryDTO dto) {
        return ResponseEntity.status(404).body(categoryService.create(dto));
    }
}
