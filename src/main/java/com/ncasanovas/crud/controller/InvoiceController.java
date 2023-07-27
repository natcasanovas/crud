package com.ncasanovas.crud.controller;

import com.ncasanovas.crud.model.Invoice;
import com.ncasanovas.crud.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crud/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody Invoice invoice) {
        return ResponseEntity.ok().body(service.add(invoice));
    }

    @PutMapping("/update")
    private ResponseEntity<?> update(@RequestBody Invoice invoice) {
        return ResponseEntity.ok().body(service.update(invoice));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detail/{id}")
    private ResponseEntity<?> detail(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.detail(id));
    }

    @GetMapping("/list")
    private ResponseEntity<?> list() {
        return ResponseEntity.ok().body(service.list());
    }

}
