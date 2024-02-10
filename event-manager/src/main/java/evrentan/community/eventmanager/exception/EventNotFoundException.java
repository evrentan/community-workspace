package evrentan.community.eventmanager.exception;

public class EventNotFoundException extends RuntimeException {

    private final String message;

    public EventNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
