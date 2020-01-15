package hoeckbankgroup.demo.model;

public class AddressPart {

    private String street;

    private String city;

    public AddressPart(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "AddressPart{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
