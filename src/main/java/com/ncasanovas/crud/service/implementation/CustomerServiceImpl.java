package com.ncasanovas.crud.service.implementation;

import com.ncasanovas.crud.model.Customer;
import com.ncasanovas.crud.repo.CustomerRepo;
import com.ncasanovas.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;
    @Override
    public Customer add(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> customerOptional = repo.findById(customer.getId());

        if (customerOptional.isPresent()) {
            return repo.save(customer);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);

        if (customerOptional.isPresent()) {
            repo.delete(customerOptional.get());
        } else {
            throw new NoSuchElementException();
        }


    }

    @Override
    public Customer detail(Long id) {
        Optional<Customer> customerOptional = repo.findById(id);

        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<Customer> list() {
        return repo.findAll();
    }
}
