package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.Address;
import no.hvl.dat250.jpa.tutorial.creditcards.Bank;
import no.hvl.dat250.jpa.tutorial.creditcards.CreditCard;
import no.hvl.dat250.jpa.tutorial.creditcards.Customer;
import no.hvl.dat250.jpa.tutorial.creditcards.Pincode;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Customer c = new Customer("Max Mustermann");
    Address a = new Address("Inndalsveien", 28);
    CreditCard ca = new CreditCard(12345, -10000, -5000);
    CreditCard ca2 = new CreditCard(123, 2000, 1);
    Pincode p = new Pincode("123", 1);
    Bank b = new Bank("Pengebank");

    c.getAddresses().add(a);
    c.getCreditCards().add(ca);
    c.getCreditCards().add(ca2);

    ca.setPincode(p);
    ca.setBank(b);
    ca2.setPincode(p);
    ca2.setBank(b);
    
    em.persist(c);
    em.persist(a);
    em.persist(ca);
    em.persist(ca2);
    em.persist(p);
    em.persist(b);

  }
}
