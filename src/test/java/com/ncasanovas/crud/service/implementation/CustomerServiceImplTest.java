package com.ncasanovas.crud.service.implementation;

import com.ncasanovas.crud.exception.RequestSystemException;
import com.ncasanovas.crud.exception.RequestValidationException;
import com.ncasanovas.crud.model.Customer;
import com.ncasanovas.crud.repo.CustomerRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    private AutoCloseable autoCloseable;

    @Mock
    private CustomerRepo repo;

    @InjectMocks
    private CustomerServiceImpl service;

    @BeforeEach
    void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        service = new CustomerServiceImpl(repo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }


    @Test
    void add() {

        Customer customer = new Customer();
        customer.setName("Carlos");
        customer.setLastName("Suarez");
        customer.setMail("carlos.suarez@mai.com");
        //when
        service.add(customer);
        //then
        verify(repo).save(customer);
    }

    @Test
    void addFailName() {
        Customer customer = new Customer();
        customer.setName("");
        customer.setLastName("Suarez");
        customer.setMail("carlos.suarez@mail.com");
        Exception exception = assertThrows(RequestValidationException.class, () -> {
            service.add(customer);
        });
        assertEquals("Debe ingresar un nombre para el cliente", exception.getMessage());
    }

    @Test
    void addFailMail() {
        Customer customer = new Customer();
        customer.setName("Carlos");
        customer.setLastName("Suarez");
        customer.setMail("");
        Exception exception = assertThrows(RequestValidationException.class, () -> {
            service.add(customer);
        });
        assertEquals("Debe ingresar un mail para el cliente", exception.getMessage());
    }

    @Test
    void addFailAccess() {
        Customer customer = new Customer();
        customer.setName("Carlos");
        customer.setLastName("Suarez");
        customer.setMail("carlos.suarez@mail.com");

        when(repo.save(any())).thenThrow(new DataAccessException("...") {
        });

        Exception exception = assertThrows(RequestSystemException.class, () -> {
            service.add(customer);
        });
        assertEquals("Ocurrió un error en la base de datos", exception.getMessage());
    }


    @Test
    void update() {
        Customer customer = mockFindById(1L);
        customer.setMail("carlos.suarez@mail.com");
        //when
        service.update(customer);
        //then
        verify(repo).save(customer);
    }

    @Test
    void delete() {
        Customer customer = mockFindById(1L);
        //when
        service.delete(customer.getId());
        //then
        verify(repo).delete(customer);
    }

    @Test
    void detail() {
        Customer customer = mockFindById(1L);
        //when
        service.detail(customer.getId());
        //then
        verify(repo).findById(customer.getId());
    }

    @Test
    void list() {
        //when
        service.list();
        //then
        verify(repo).findAll();
    }

    private Customer mockFindById(Long id) {
        Customer mock = new Customer();
        mock.setId(id);
        mock.setName("Carlos");
        mock.setLastName("Suarez");
        mock.setMail("caros.suarez@mail.com");
        doReturn(Optional.of(mock)).when(repo).findById(id);
        return mock;
    }
}