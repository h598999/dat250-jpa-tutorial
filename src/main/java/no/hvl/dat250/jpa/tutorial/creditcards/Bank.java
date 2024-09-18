package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bank")
    Collection<CreditCard> ownedCards = new HashSet<>();

    public Bank(){}

    public Bank(String name){
      this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
      return this.name;
    }

    public Collection<CreditCard> getOwnedCards() {
      return this.ownedCards;
    }
}
