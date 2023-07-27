package com.ncasanovas.crud.service;

import com.ncasanovas.crud.dto.ProductDTO;
import com.ncasanovas.crud.model.Product;

import java.util.List;

public interface ProductService {

    ProductDTO add(Product product);

    ProductDTO update(Product product);

    void delete(Long id);

    ProductDTO detail(Long id);

    List<ProductDTO> list();
}
