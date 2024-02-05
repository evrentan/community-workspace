package evrentan.community.eventmanager.exception;

public class EventAlreadyExistsException extends RuntimeException {

    private final String message;

    public EventAlreadyExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
