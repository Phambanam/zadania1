package AddressBooks;

import java.util.*;

class AddressBook  {
    private Map<Person, Address> addressBook = new HashMap<>();


    Map<Person, Address> getAddressBook() {
        return addressBook;
    }

    void add(Person person, Address address) {
        try {
            addressBook.put(person, address);
        } catch (NullPointerException ignored) {

        }

    }

    void remove(Person person) {
        for (Person per : addressBook.keySet()) {
            if (per.equals(person)) {
                addressBook.remove(per);
                break;
            }
        }
    }

    void edit(Person person, Address address) {
        for (Person per : addressBook.keySet()) {
            if (per.equals(person)) {
                addressBook.put(per, address);
                break;
            }
        }
    }

    HashSet<Person> findSameStress(Address address) {
        HashSet<Person>sameStressList = new HashSet<>();
        addressBook.forEach((person, address1) -> {
            if (address1.getStress().equals(address.getStress())) {
                sameStressList.add(person);
            };
        });
        return sameStressList;
    }
    HashSet<Person> findSameHouse(Address address){
        HashSet<Person> sameHouse = new HashSet<>();
        addressBook.forEach(((person, address1) ->
        {
            if(address1.getStress().equals(address.getStress())
            && address1.getHouse().equals(address.getHouse()))
                sameHouse.add(person);
        }
                ));
        return  sameHouse;
    }
}
