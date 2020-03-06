package AddressBooks;

class Person {
    private String name;

    String getName() {
        return name;
    }

    void setName(String name) {
        if(name != null ) {
            this.name = name;
        }
    }
}