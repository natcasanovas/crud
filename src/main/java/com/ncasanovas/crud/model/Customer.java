package com.ncasanovas.crud.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="CustomerDB")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="customer_name", length = 100, nullable = false)
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String mail;

    @Lob
    private String observations;  // en lugar de varchar se almacena como longtext por el atributo lob

    @OneToMany(mappedBy = "customer")
    private Set<Invoice> invoices;


    public Customer(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
