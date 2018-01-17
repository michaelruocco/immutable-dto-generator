package uk.co.mruoc.code;

public class CustomerDto {

    private final String firstName;
    private final String lastName;

    public CustomerDto(CustomerDtoBuilder builder) {
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
