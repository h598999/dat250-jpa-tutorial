package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;

    @ManyToMany(mappedBy = "creditCards")
    Collection<Customer> owners;

    @ManyToOne
    Bank bank;

    @ManyToOne
    Pincode pincode;

    public Integer getNumber() {
      return this.number;
    }

    public Integer getBalance() {
      return this.balance;
    }

    public Integer getCreditLimit() {
      return this.creditLimit;
    }

    public Pincode getPincode() {
      return this.pincode;
    }

    public Bank getOwningBank() {
      return this.bank;
    }
}
