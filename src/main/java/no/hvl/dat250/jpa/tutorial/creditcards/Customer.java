package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
      name = "customer_adress",
      joinColumns = @JoinColumn(name="customer_id"),
      inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Collection<Address> addresses;

    @ManyToMany
    @JoinTable(
      name = "customer_creditcard",
      joinColumns = @JoinColumn(name = "customer_id"),
      inverseJoinColumns = @JoinColumn(name="creditcard_id")
    )
    private Collection<CreditCard> creditCards;
    
    

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
