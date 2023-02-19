package evrentan.community.eventmanager.exception;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CustomRestError> badRequestException(final Exception exception, final HttpServletRequest httpServletRequest){
        var customRestError = CustomRestError.builder()
                .message(exception.getCause().getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return responseEntity(customRestError);

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomRestError> notFoundException(final Exception exception, final HttpServletRequest httpServletRequest){
        var customRestError = CustomRestError.builder()
                .message(exception.getCause().getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return responseEntity(customRestError);
    }


    private static ResponseEntity<CustomRestError> responseEntity(CustomRestError customRestError){
        return ResponseEntity.status(HttpStatus.valueOf(customRestError.getStatus()))
                .body(customRestError);
    }


}
