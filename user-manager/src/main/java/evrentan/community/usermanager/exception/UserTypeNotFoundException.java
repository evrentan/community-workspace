package evrentan.community.usermanager.exception;

public class UserTypeNotFoundException extends RuntimeException {

    private final String message;

    public UserTypeNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
 }
