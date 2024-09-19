package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
      name = "customer_address",
      joinColumns = @JoinColumn(name="customer_id"),
      inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Collection<Address> addresses = new HashSet<>();

    @ManyToMany
    @JoinTable(
      name = "customer_creditcard",
      joinColumns = @JoinColumn(name = "customer_id"),
      inverseJoinColumns = @JoinColumn(name="creditcard_id")
    )

    private Collection<CreditCard> creditCards = new HashSet<>();

    public Customer(){}

    public Customer(String name){
      this.name = name;
    }

    public String getName() {
      return this.name;
    }

    public Collection<Address> getAddresses() {
      return this.addresses;
    }

    public Collection<CreditCard> getCreditCards() {
      return this.creditCards;
    }
}
