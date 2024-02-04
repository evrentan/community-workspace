package evrentan.community.usermanager.exception;

public class UserAlreadyExistsException extends RuntimeException {

    private final String message;

    public UserAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
 }
