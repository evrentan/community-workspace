package evrentan.community.venuemanager.exception;

public class RoomAlreadyException extends RuntimeException {

    private final String message;

    public RoomAlreadyException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
