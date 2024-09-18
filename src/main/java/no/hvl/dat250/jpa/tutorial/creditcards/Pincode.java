package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;

import jakarta.persistence.*;

@Entity
public class Pincode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pincode;
    private Integer count;

    @OneToMany(mappedBy = "pincode")
    Collection<CreditCard> creditCards;

    public Long getId() {
        return id;
    }

    public String getCode() {
      return this.pincode;
    }

    public Integer getCount() {
      return this.count;
    }
}
