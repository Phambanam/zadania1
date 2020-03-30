package AddressBooks;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @Test
    void add()  {
        AddressBook addressBook = new AddressBook();
        Person person = new Person("Pham Nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");

        Person person1 = new Person("Pham Bac");
        Address address1 = new Address("Hoang Viet","432","803B");

        Person person2 = new Person("Pham Bac");
        Address address2 = new Address("Hoang Viet","432","803B");

        addressBook.add(person,address);
        addressBook.add(person1,address1);
        addressBook.add(person2,address2);

    }

    @Test
    void remove() {
        AddressBook addressBook = new AddressBook();
        Person person = new Person("Pham ba nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");
        addressBook.add(person,address);

        Person person1 = new Person("Pham ba na");
        Address address1 = new Address("Hoang Quoc Viet","432","803B");
        addressBook.add(person1,address1);

        AddressBook addressBook1 = new AddressBook();
        addressBook1.add(person1,address1);

        addressBook.remove(person);

    }

    @Test
    void edit() {
        AddressBook addressBook = new AddressBook();
        Person person = new Person("Pham ba nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");
        addressBook.add(person,address);

        Address address1 = new Address("tru son","321","212B");
        addressBook.edit(person,address1);

        AddressBook addressBook1 = new AddressBook();
        addressBook1.add(person,address1);
    }
    @Test
    void getTheAddress(){
        AddressBook addressBook = new AddressBook();
        Person person = new Person("Pham nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");
        addressBook.add(person,address);

        Person person1 = new Person("Pham bac");
        Address address1 = new Address("Hoang Quoc Viet","321","212B");
        addressBook.add(person1,address1);

        Person person2 = new Person("Pham bac");
        Address address2 = new Address("Hoang Quoc Viet new","321","212B");
        addressBook.add(person2,address2);

        Person person3 = new Person("Pham Hong");
        Address address3 = new Address("Hoang Quoc Viet","320","222B");
        addressBook.add(person3,address3);

        assertEquals(address3,addressBook.getTheAddress(person3));

    }

    @Test
    void findSameStress() {
        AddressBook addressBook = new AddressBook();
        Person person = new Person("Pham nam");
        Address address = new Address("Hoang Quoc Viet","432","803B");
        addressBook.add(person,address);

        Person person1 = new Person("Pham bac");
        Address address1 = new Address("Hoang Quoc Viet","321","212B");
        addressBook.add(person1,address1);

        Person person2 = new Person("Pham bac");
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
    void findSameHouse() {
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