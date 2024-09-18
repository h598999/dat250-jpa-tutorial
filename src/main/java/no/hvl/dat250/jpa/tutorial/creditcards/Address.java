package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
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
