package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;

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
    Collection<Customer> owners = new HashSet<>();

    @ManyToOne
    Bank bank;

    @ManyToOne
    Pincode pincode;

    public CreditCard(){}

    public CreditCard(Integer number, Integer creditLimit, Integer balance){
      this.number = number;
      this.creditLimit = creditLimit;
      this.balance = balance;
    }

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

    public void setPincode(Pincode pincode) {
      this.pincode = pincode;
    }

    public void setBank(Bank bank){
      this.bank = bank;
    }

    public Bank getOwningBank() {
      return this.bank;
    }

    @Override
    public String toString() {
      return "CreditCard{" +
        "id=" + id +
        ", number=" + number +
        ", creditLimit=" + creditLimit +
        ", balance=" + balance +
        ", bank=" + (bank != null ? bank.getName() : "N/A") +  // Assuming Bank has a getName() method
        ", pincode=" + (pincode != null ? pincode.getCode() : "N/A") +  // Assuming Pincode has a getCode() method
        '}';
    }
}
