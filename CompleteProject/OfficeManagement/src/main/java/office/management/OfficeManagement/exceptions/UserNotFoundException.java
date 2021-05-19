package office.management.OfficeManagement.exceptions;

public class UserNotFoundException  extends RuntimeException{
    public UserNotFoundException (String message) {
        super(message);
    }
}
