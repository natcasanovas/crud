package com.ncasanovas.crud.controller;

import com.ncasanovas.crud.model.Product;
import com.ncasanovas.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crud/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody Product product) {
        return ResponseEntity.status(200).body(service.add(product));
    }

    @PutMapping("/update")
    private ResponseEntity<?> update(@RequestBody Product product) {
        return ResponseEntity.ok().body(service.update(product));
    }

    @GetMapping("/detail/{id]")
    private ResponseEntity<?> detail(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.detail(id));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    private ResponseEntity<?> list() {
        return ResponseEntity.ok().body(service.list());
    }
}
