package AddressBooks;

public class Address {
    private String stress;
    private String house;
    private String apartment;

    Address(String stress, String house, String apartment) {
        this.stress = stress;
        this.house = house;
        this.apartment = apartment;
    }

    String getStress() {
        return stress;
    }

    void setStress(String stress) {
        this.stress = stress;
    }

    String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
