package AddressBooks;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @Test
    void add()  {
        Person person = new Person();
        person.setName("Pham Nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");
        AddressBook addressBook = new AddressBook();
        addressBook.add(person,address);
    }

    @Test
    void remove() {
        AddressBook addressBook = new AddressBook();
        Person person = new Person();
        person.setName("Pham ba nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");
        addressBook.add(person,address);
        addressBook.remove(person);
    }

    @Test
    void edit() {
        AddressBook addressBook = new AddressBook();
        Person person = new Person();
        person.setName("Pham ba nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");
        addressBook.add(person,address);

        Address address1 = new Address("tru son","321","212B");
        addressBook.edit(person,address1);

        AddressBook addressBook1 = new AddressBook();
        addressBook1.add(person,address1);

        assertEquals(addressBook1.getAddressBook(), addressBook.getAddressBook());

    }

    @Test
    void findSameStress() {
        AddressBook addressBook = new AddressBook();
        Person person = new Person();
        person.setName("Pham nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");
        addressBook.add(person,address);

        Person person1 = new Person();
        person1.setName("Pham bac");
        Address address1 = new Address("Hoang Quoc Viet","321","212B");
        addressBook.add(person1,address1);

        Person person2 = new Person();
        person1.setName("Pham bac");
        Address address2 = new Address("Hoang Quoc Viet new","321","212B");
        addressBook.add(person2,address2);

        HashSet<Person> list = new HashSet<>();
        list.add(person1);
        list.add(person);
        assertEquals(list, addressBook.findSameStress(address));
    }

    @Test
    void findSameHouse() {
        AddressBook addressBook = new AddressBook();
        Person person = new Person();
        person.setName("Pham nam");
        Address address = new Address("Hoang Quoc Viet","321","803B");
        addressBook.add(person,address);

        Person person1 = new Person();
        person1.setName("Pham bac");
        Address address1 = new Address("Hoang Quoc Viet","321","212B");
        addressBook.add(person1,address1);

        Person person2 = new Person();
        person1.setName("Pham Oanh");
        Address address2 = new Address("Hoang Quoc Viet","321","222B");
        addressBook.add(person2,address2);

        HashSet<Person> list = new HashSet<>();
        list.add(person1);
        list.add(person);
        list.add(person2);
        assertEquals(list, addressBook.findSameHouse(address));
    }
}