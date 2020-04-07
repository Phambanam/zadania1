package AddressBooks;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    Person person = new Person("Pham Nam");
    Address address = new Address("Hoang Quoc Viet","432","803B");
    Person person1 = new Person("Pham Ba");
    Address address1 = new Address("Hoang Viet","432","803B");
    Person person2 = new Person("Pham Bac");
    Address address2 = new Address("Hoang Viet","432","803B");
    Person person3 = new Person("Pham ba na");
    Address address3 = new Address("Hoang Quoc Viet","4322","803B");
    Person person4 = new Person("Pham bac");
    Address address4 = new Address("Hoang Quoc Viet","321","212B");
    Person person5 = new Person("Pham bact");
    Address address5 = new Address("Hoang Quoc Viet new","321","212B");
    Person person6 = new Person("Pham Hong");
    Address address6 = new Address("Hoang Quoc Viet","320","222B");
    @Test
    void add() throws myException {
        AddressBook addressBook = new AddressBook();
        addressBook.add(person,address);
        addressBook.add(person1,address1);

        Map<Person, Address> addressBookT = new HashMap<>();
        addressBookT.put(person,address);
        addressBookT.put(person1, address1);

        assertEquals(addressBook.getAddressBook(),addressBookT);
    }

    @Test
    void remove() throws myException {
        AddressBook addressBook = new AddressBook();
        addressBook.add(person,address);
        addressBook.add(person3,address3);
        addressBook.remove(person3);

        AddressBook addressBook1 = new AddressBook();
        addressBook1.add(person,address);


       assertEquals(addressBook,addressBook1);

    }

    @Test
    void edit() throws myException {
        AddressBook addressBook = new AddressBook();
        addressBook.add(person,address);

        Address address1 = new Address("tru son","321","212B");
        addressBook.edit(person,address1);

        AddressBook addressBook1 = new AddressBook();
        addressBook1.add(person,address1);

        assertEquals(addressBook,addressBook1);
    }
    @Test
    void getTheAddress() throws myException {
        AddressBook addressBook = new AddressBook();
        addressBook.add(person,address);
        addressBook.add(person4,address4);
        addressBook.add(person5,address5);
        addressBook.add(person6,address6);

        assertEquals(address6,addressBook.getTheAddress(person6));

    }

    @Test
    void findSameStress() throws myException {
        AddressBook addressBook = new AddressBook();
        Person person = new Person("Pham nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");
        addressBook.add(person,address);

        Person person1 = new Person("Pham bac");
        Address address1 = new Address("Hoang Quoc Viet","321","212B");
        addressBook.add(person1,address1);

        Person person2 = new Person("Pham ba");
        Address address2 = new Address("Hoang Quoc Viet new","321","212B");
        addressBook.add(person2,address2);

        Person person3 = new Person("Pham Hong");
        Address address3 = new Address("Hoang Quoc Viet","320","222B");
        addressBook.add(person3,address3);

        HashSet<Person> list = new HashSet<>();
        list.add(person1);
        list.add(person);
        list.add(person3);
        assertEquals(list, addressBook.findSameStress(address));
    }

    @Test
    void findSameHouse() throws myException {
        AddressBook addressBook = new AddressBook();
        Person person = new Person("Pham nam");
        Address address = new Address("Hoang Quoc Viet","321","803B");
        addressBook.add(person,address);

        Person person1 = new Person("Pham bac");
        Address address1 = new Address("Hoang Quoc Viet","321","212B");
        addressBook.add(person1,address1);

        Person person2 = new Person("Pham Oanh");
        Address address2 = new Address("Hoang Quoc Viet","321","222B");
        addressBook.add(person2,address2);

        Person person3 = new Person("Pham Hong");
        Address address3 = new Address("Hoang Quoc Viet","320","222B");
        addressBook.add(person3,address3);

        HashSet<Person> list = new HashSet<>();
        list.add(person1);
        list.add(person);
        list.add(person2);
        assertEquals(list, addressBook.findSameHouse(address));
    }
}