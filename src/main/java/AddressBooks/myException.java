package AddressBooks;

public class myException extends Exception {
    private String error;

    public myException(String error){
        super();
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
