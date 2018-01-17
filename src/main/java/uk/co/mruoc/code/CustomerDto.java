package uk.co.mruoc.code;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerDto {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final boolean premium;
    private final BigDecimal balance;
    private Integer integerVal;

    public CustomerDto(CustomerDtoBuilder builder) {
        this.id = builder.getId();
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.dateOfBirth = builder.getDateOfBirth();
        this.premium = builder.isPremium();
        this.balance = builder.getBalance();
        this.integerVal = builder.getIntegerVal();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isPremium() {
        return premium;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Integer getIntegerVal() {
        return integerVal;
    }

}
