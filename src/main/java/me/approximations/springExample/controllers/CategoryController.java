package me.approximations.springExample.controllers;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.Category;
import me.approximations.springExample.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
        final Optional<Category> categoryOptional = categoryService.findById(id);

        return ResponseEntity.ok(categoryOptional.get());
    }
}
