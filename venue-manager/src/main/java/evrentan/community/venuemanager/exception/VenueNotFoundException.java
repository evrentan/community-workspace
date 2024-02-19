package evrentan.community.venuemanager.exception;

public class VenueNotFoundException extends RuntimeException {

    private final String message;

    public VenueNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
