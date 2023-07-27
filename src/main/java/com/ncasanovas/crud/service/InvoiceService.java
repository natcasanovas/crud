package com.ncasanovas.crud.service;

import com.ncasanovas.crud.dto.InvoiceDTO;
import com.ncasanovas.crud.model.Invoice;

import java.util.List;

public interface InvoiceService {

    InvoiceDTO add(Invoice invoice);

    InvoiceDTO update(Invoice invoice);

    void delete(Long id);

    InvoiceDTO detail(Long id);

    List<InvoiceDTO> list();
}
