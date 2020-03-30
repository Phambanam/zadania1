package AddressBooks;

import java.util.Objects;

public class Address {
    private String stress;
    private String house;
    private String apartment;

    public Address(){}
    public Address(String stress, String house, String apartment) {
        this.stress = stress;
        this.house = house;
        this.apartment = apartment;
    }

    String getStress() {
        return stress;
    }
    String getHouse() {
        return house;
    }
    String getApartment(){return apartment;}

    @Override
    public boolean equals(Object obj) {
       if(obj.getClass() != this.getClass()) return false;
       Address a = (Address) obj;
        return this.getHouse() == a.getHouse() && this.apartment == a.getApartment() && this.getStress() == a.getStress();
    }

    @Override
    public int hashCode() {
        return Objects.hash(stress, house, apartment);
    }

    @Override
    public String toString() {

        return this.getStress() +" "+ this.getHouse() +" "+ this.apartment;
    }
}
