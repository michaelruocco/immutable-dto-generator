package uk.co.mruoc.code;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerDtoTest {

    private final CustomerDtoBuilder builder = new CustomerDtoBuilder();

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

}
