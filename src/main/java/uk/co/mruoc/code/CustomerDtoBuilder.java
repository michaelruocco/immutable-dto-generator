package uk.co.mruoc.code;

public class CustomerDtoBuilder {

    private String firstName;
    private String lastName;

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

    public CustomerDto build() {
        return new CustomerDto(this);
    }

}
