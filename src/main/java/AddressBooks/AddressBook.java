package AddressBooks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class AddressBook  {
    private Map<Person, Address> addressBook = new HashMap<>();


    Map<Person, Address> getAddressBook() {
        return addressBook;
    }

    void add(Person person, Address address) {
        if(addressBook.containsKey(person))
            System.out.println("This person is already on the list");
       else addressBook.put(person, address);
    }

    void remove(Person person) {
        boolean tOrF = false ;
        for (Person per : addressBook.keySet()) {
            if (person.equals(per)) {
                addressBook.remove(per);
                tOrF = true;
                break;
            }
        }
        if(!tOrF) System.out.println("This person is not in the list");
    }

    void edit(Person person, Address address) {
        boolean tOrF = false ;
        for (Person per : addressBook.keySet()) {
            if (per.equals(person)) {
                addressBook.put(per, address);
                tOrF = true;
                break;
            }
        }
        if(!tOrF) System.out.println("This person is not in the list");
    }

    HashSet<Person> findSameStress(Address address) {
        HashSet<Person>sameStressList = new HashSet<>();
        addressBook.forEach((person, address1) -> {
            if (address1.getStress().equals(address.getStress()))
            sameStressList.add(person);
        });
        if(sameStressList.size() == 0)
            System.out.println("There are no people from the same street");
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
        if(sameHouse.size() == 0 )
            System.out.println("There are no people from the same house");
        return  sameHouse;
    }
}
