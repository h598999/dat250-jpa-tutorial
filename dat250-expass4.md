# Assignment 4 JPA

## JPA Installation and use of JPA
I had no problems with the JPA installation.
When i first tried to build the project i got an error because 
the creditcard class was not added to the persistence.xml file.

When writing the Creditcardmain driver i first got an error when trying
to add for example a creditcard to a customer or a bank to a creditcard.
This was because i had not initialized the Collection fields to for example
a new HashSet<>();

Further on in the CreditCardMainTest i kept getting an error in these lines:

``` Java
    assertEquals(address.getOwners(), Set.of(customer));
    assertEquals(bank.getOwnedCards(), Set.of(firstCard, secondCard));


```
Even though the contents of the two collections were excactly the same i kept getting errors. I think this is because when the
Set.of() method is used it creates an immutable list. Then when comparing that list to a mutable list like
those found in adress.getOwners() and bank.getOwnedCards() it would return false even though the contents of
the list were excactly the same. Therefore i changed those test lines with these:
 
``` Java

        //This is a bad test?
        // Because the equals will not be true if adress.getOwners() is not immutable
        // Even though the contents of both Collections are excactly the same
        // and i dont think it is wanted for adress.getOwners() to be immutable.
        // assertEquals(address.getOwners(), Set.of(customer));
        // Changed:
        assertTrue(address.getOwners().contains(customer));
        assertTrue(address.getOwners().size() == 1);

        // This does not work as expected i think
        // assertEquals(bank.getOwnedCards(), Set.of(firstCard, secondCard));
        //Change:
        assertTrue(bank.getOwnedCards().contains(firstCard));
        assertTrue(bank.getOwnedCards().contains(secondCard));
        assertTrue(bank.getOwnedCards().size() == 2);

```
## Link to code:
Can be found in the same repository as this report.
URL: https://github.com/h598999/dat250-jpa-tutorial

## Database Inspection
I inspected the database using an h2 driver and Intellij. I created a datasource from path and using the
H2 driver i was able to inspect the database and perform SQL queries towards it.

![expass4.png](expass4.png)

![CreditcardDB.png](CreditcardDB.png)


This is the database schemas:
``` H2

-- Address Table
CREATE TABLE ADDRESS
(
    NUMBER INTEGER,
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    STREET CHARACTER VARYING(255)
);

-- Bank Table
CREATE TABLE BANK
(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME CHARACTER VARYING(255)
);

-- Customer Table
CREATE TABLE CUSTOMER
(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME CHARACTER VARYING(255)
);

-- Customer_Address Join Table (for Many-to-Many relationship)
CREATE TABLE CUSTOMER_ADDRESS
(
    ADDRESS_ID BIGINT NOT NULL,
    CUSTOMER_ID BIGINT NOT NULL,
    PRIMARY KEY (ADDRESS_ID, CUSTOMER_ID),
    CONSTRAINT FK_ADDRESS FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS(ID),
    CONSTRAINT FK_CUSTOMER_ADDRESS FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(ID)
);

-- Family Table
CREATE TABLE FAMILY
(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    DESCRIPTION CHARACTER VARYING(255)
);

-- Job Table
CREATE TABLE JOB
(
    SALARY DOUBLE PRECISION NOT NULL,
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    JOBDESCR CHARACTER VARYING(255)
);

-- Pincode Table
CREATE TABLE PINCODE
(
    COUNT INTEGER,
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PINCODE CHARACTER VARYING(255)
);

-- Credit Card Table
CREATE TABLE CREDITCARD
(
    BALANCE INTEGER,
    CREDITLIMIT INTEGER,
    NUMBER INTEGER,
    BANK_ID BIGINT,
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PINCODE_ID BIGINT,
    CONSTRAINT FK_BANK FOREIGN KEY (BANK_ID) REFERENCES BANK(ID),
    CONSTRAINT FK_PINCODE FOREIGN KEY (PINCODE_ID) REFERENCES PINCODE(ID)
);

-- Customer_CreditCard Join Table (for Many-to-Many relationship)
CREATE TABLE CUSTOMER_CREDITCARD
(
    CREDITCARD_ID BIGINT NOT NULL,
    CUSTOMER_ID BIGINT NOT NULL,
    PRIMARY KEY (CREDITCARD_ID, CUSTOMER_ID),
    CONSTRAINT FK_CREDITCARD FOREIGN KEY (CREDITCARD_ID) REFERENCES CREDITCARD(ID),
    CONSTRAINT FK_CUSTOMER_CREDITCARD FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(ID)
);

```
## Non resolved problems
None


