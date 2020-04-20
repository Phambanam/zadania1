package AddressBooks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;


class AddressBook {
    private Map<Person, Address> addressBook = new HashMap<>();

    public Map<Person, Address> getAddressBook() {
        return new HashMap<>(addressBook);
    }

    public Address getTheAddress(Person person) throws myException {
        Address address = addressBook.get(person);
        if (address == null) throw new myException("This person does not exist yet");
        else return address;
    }

    public void add(Person person, Address address) throws myException {
        if ( addressBook.putIfAbsent(person, address) != null)
            throw new myException("Person already exists");
    }


    public void remove(Person person) throws myException {
        if (addressBook.remove(person) == null)
            throw new myException("This person does not exist yet");
    }



    public void edit(Person person, Address address) throws myException {
        if (addressBook.replace(person, address) == null)
            throw new myException("This person does not exist yet");

    }


    public HashSet<Person> findSameStress(Address address) throws myException {
        HashSet<Person>sameStressList = new HashSet<>();
        addressBook.forEach((person, address1) -> {
            if (address1.getStress().equals(address.getStress()))
            sameStressList.add(person);
        });
        if(sameStressList.size() == 0)
            throw new myException("emptyList");
        return sameStressList;
    }

    public HashSet<Person> findSameHouse(Address address) throws myException {
        HashSet<Person> sameHouse = new HashSet<>();
        addressBook.forEach(((person, address1) ->
        {
            if(address1.getStress().equals(address.getStress())
            && address1.getHouse().equals(address.getHouse()))
                sameHouse.add(person);
        }
                ));
        if(sameHouse.size() == 0 )
            throw new myException("emptyList");

        return  sameHouse;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null ) return false;
        if(obj.getClass() != this.getClass()) return false;
        AddressBook a = (AddressBook) obj;
        return (this.hashCode() == a.hashCode() );
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressBook);
    }
}
