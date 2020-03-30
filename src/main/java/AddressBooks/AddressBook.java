package AddressBooks;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


class AddressBook {
    private Map<Person, Address> addressBook = new HashMap<>();



   Address getTheAddress(Person person){
       Address address = new Address();
      if(addressBook.containsKey(person))
           address = addressBook.get(person);
       System.out.println(address.toString());
       return address;
   }

    void add(Person person, Address address) {
        if(addressBook.containsKey(person))
            System.out.println(person.toString() + " is already on the list");
       else addressBook.put(person, address);
    }

    void remove(Person person) {
        boolean tOrF = false ;
        if(addressBook.containsKey(person))
        {
                addressBook.remove(person);
                tOrF = true;
            }
        if(!tOrF) System.out.println(person.toString() + "is not in the list");
        else System.out.println("Deleted address by name");
        }



    void edit(Person person, Address address) {
        boolean tOrF = false ;
        if(addressBook.containsKey(person))
        {
            addressBook.remove(person);
            addressBook.replace(person, address);
            tOrF = true;
        }
        if(!tOrF) System.out.println(person.toString() + " is not in the list");
        else System.out.println("Changed the address by name");
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
