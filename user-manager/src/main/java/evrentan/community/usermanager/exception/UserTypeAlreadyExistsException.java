package evrentan.community.usermanager.exception;

public class UserTypeAlreadyExistsException extends RuntimeException {

    private final String message;

    public UserTypeAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
 }
