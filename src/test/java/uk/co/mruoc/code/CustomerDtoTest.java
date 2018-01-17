package uk.co.mruoc.code;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerDtoTest {

    private final CustomerDtoBuilder builder = new CustomerDtoBuilder();

    @Test
    public void shouldSetId() {
        long id = 12;

        CustomerDto customerDto = builder.setId(id).build();

        assertThat(customerDto.getId()).isEqualTo(id);
    }

    @Test
    public void shouldSetFirstName() {
        String firstName = "firstName";

        CustomerDto customerDto = builder.setFirstName(firstName).build();

        assertThat(customerDto.getFirstName()).isEqualTo(firstName);
    }

    @Test
    public void shouldSetLastName() {
        String lastName = "lastName";

        CustomerDto customerDto = builder.setLastName(lastName).build();

        assertThat(customerDto.getLastName()).isEqualTo(lastName);
    }

    @Test
    public void shouldSetDateOfBirth() {
        LocalDate dateOfBirth = LocalDate.of(2018, 1, 17);

        CustomerDto customerDto = builder.setDateOfBirth(dateOfBirth).build();

        assertThat(customerDto.getDateOfBirth()).isEqualTo(dateOfBirth);
    }

    @Test
    public void shouldSetPremium() {
        boolean premium = new Random().nextBoolean();

        CustomerDto customerDto = builder.setPremium(premium).build();

        assertThat(customerDto.isPremium()).isEqualTo(premium);
    }

    @Test
    public void shouldSetBalance() {
        BigDecimal balance = BigDecimal.valueOf(10);

        CustomerDto customerDto = builder.setBalance(balance).build();

        assertThat(customerDto.getBalance()).isEqualTo(balance);
    }

    @Test
    public void shouldSetIntegerVal() {
        Integer integerVal = 10;
        CustomerDto customerDto = builder.setIntegerVal(integerVal).build();
        assertThat(customerDto.getIntegerVal()).isEqualTo(integerVal);
    }

}
