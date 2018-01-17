package uk.co.mruoc.code;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerDtoBuilder {

    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean premium;
    private BigDecimal balance;
    private Integer integerVal;

    public long getId() {
        return id;
    }

    public CustomerDtoBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomerDtoBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerDtoBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public CustomerDtoBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public boolean isPremium() {
        return premium;
    }

    public CustomerDtoBuilder setPremium(boolean premium) {
        this.premium = premium;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public CustomerDtoBuilder setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public Integer getIntegerVal() {
        return integerVal;
    }

    public CustomerDtoBuilder setIntegerVal(Integer integerVal) {
        this.integerVal = integerVal;
        return this;
    }

    public CustomerDto build() {
        return new CustomerDto(this);
    }

}
