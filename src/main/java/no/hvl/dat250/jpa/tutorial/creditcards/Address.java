package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "addresses")
    private Collection<Customer> owners;

    private String street;
    private Integer number;

    public Address(){}

    public Address(String street, Integer number){
      this.street = street;
      this.number = number;
    }

    public String getStreet() {
      return this.street;
    }

    public Integer getNumber() {
      return this.number;
    }

    public Collection<Customer> getOwners() {
      return this.owners;
    }
}
