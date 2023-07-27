package com.ncasanovas.crud.service.implementation;

import com.ncasanovas.crud.dto.InvoiceDTO;
import com.ncasanovas.crud.model.Invoice;
import com.ncasanovas.crud.model.InvoiceItem;
import com.ncasanovas.crud.repo.InvoiceRepo;
import com.ncasanovas.crud.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepo repo;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public InvoiceDTO add(Invoice invoice) {
        Float total = 0f;
        for(InvoiceItem invoiceItem : invoice.getInvoiceItems()) {
            invoiceItem.setInvoice(invoice);
            total = total + (invoiceItem.getQuantity() * invoiceItem.getProduct().getSalePrice());
        }

        invoice.setTotal(total);
        return mapper.map(repo.save(invoice), InvoiceDTO.class);
    }

    @Override
    public InvoiceDTO update(Invoice invoice) {
        return mapper.map(repo.save(invoice), InvoiceDTO.class);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public InvoiceDTO detail(Long id) {
        return mapper.map(repo.findById(id).get(), InvoiceDTO.class);
    }

    @Override
    public List<InvoiceDTO> list() {
        return mapper.map(repo.findAll(), new TypeToken<List<InvoiceDTO>>() {}.getType());
    }
}
