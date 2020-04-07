package AddressBooks;

import java.util.Objects;

class Person {
    private String name;


    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null ) return false;
        if (obj.getClass() != this.getClass()) return false;
        Person n = (Person) obj;
        return this.name.equals(n.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}