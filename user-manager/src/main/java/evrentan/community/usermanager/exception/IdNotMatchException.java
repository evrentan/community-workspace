package evrentan.community.usermanager.exception;

public class IdNotMatchException extends RuntimeException {

    private final String message;

    public IdNotMatchException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
 }
