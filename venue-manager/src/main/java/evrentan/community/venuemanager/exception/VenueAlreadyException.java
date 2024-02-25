package evrentan.community.venuemanager.exception;

public class VenueAlreadyException extends RuntimeException {

    private final String message;

    public VenueAlreadyException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

}
