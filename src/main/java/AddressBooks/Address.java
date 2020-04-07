package AddressBooks;

import java.util.Objects;

public class Address {
    private String stress;
    private String house;
    private String apartment;


    public Address(String stress, String house, String apartment) {
        this.stress = stress;
        this.house = house;
        this.apartment = apartment;
    }

    public String getStress() {
        return stress;
    }
    public String getHouse() {
        return house;
    }
    public String getApartment(){return apartment;}

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null ) return false;
       if(obj.getClass() != this.getClass()) return false;
       Address a = (Address) obj;
        return this.house.equals(a.house) && this.apartment.equals(a.apartment) && this.stress.equals(a.stress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stress, house, apartment);
    }

    @Override
    public String toString() {
        return this.stress +" "+ this.house +" "+ this.apartment;
    }
}
