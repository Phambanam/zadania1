package AddressBooks;

import java.util.Objects;

class Person {
    private String name;


    void setName(String name) {
        if(name != null ) {
            this.name = name;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) return false;
        Person n = (Person) obj;
        return this.name == n.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}