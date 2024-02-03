package evrentan.community.communitymanager.exception;

public class CommunityNotFoundException extends RuntimeException {

    private final String message;

    public CommunityNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
