package com.springboot.blog.springbootblogrestapi.controller;

import com.springboot.blog.springbootblogrestapi.payload.CategoryDto;
import com.springboot.blog.springbootblogrestapi.service.CatergoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CatergoryService catergoryService;

    public CategoryController(CatergoryService catergoryService) {
        this.catergoryService = catergoryService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/categories")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(catergoryService.addCategory(categoryDto), HttpStatus.CREATED);
    }

    @GetMapping("/api/categories/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
        return new ResponseEntity<>(catergoryService.getCategory(id), HttpStatus.OK);
    }

    @GetMapping("/api/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return new ResponseEntity<>(catergoryService.getAllCategory(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/api/categories/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Long id) {
        return new ResponseEntity<>(catergoryService.updateCategory(categoryDto, id), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        catergoryService.deleteCategory(id);
        return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
    }
}
