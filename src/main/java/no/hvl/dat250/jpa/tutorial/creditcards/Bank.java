package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bank")
    Collection<CreditCard> ownedCards;


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
