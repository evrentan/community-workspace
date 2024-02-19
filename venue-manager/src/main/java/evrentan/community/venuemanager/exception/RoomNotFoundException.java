package evrentan.community.venuemanager.exception;

public class RoomNotFoundException extends RuntimeException{

    private final String message;

    public RoomNotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
