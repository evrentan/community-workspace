package evrentan.community.venuemanager.exception;

import evrentan.community.venuemanager.dto.exception.CustomRestError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    /**
     * Indicates that the request made is in an incorrect format.
     *
     * @param exception Bad Request Exception
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @ExceptionHandler({
            BadRequestException.class,
            IdNotMatchException.class
    })
    public ResponseEntity<CustomRestError> badRequestException(final Exception exception, final HttpServletRequest httpServletRequest){
        var customRestError = CustomRestError.builder()
                .message(exception.getCause().getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return responseEntity(customRestError);
    }


    /**
     * Indicates that the request made is in an incorrect format.
     *
     * @param exception Not FoundException
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @ExceptionHandler({
            NotFoundException.class,
            VenueNotFoundException.class,
            RoomNotFoundException.class
    })
    public ResponseEntity<CustomRestError> notFoundException(final Exception exception, final HttpServletRequest httpServletRequest){
        var customRestError = CustomRestError.builder()
                .message(exception.getCause().getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return responseEntity(customRestError);
    }

    /**
     * Indicates that the request made is in an incorrect format.
     *
     * @param exception Internal Server Error Exception
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<CustomRestError> internalServerException(final Exception exception, final HttpServletRequest httpServletRequest){
        var customRestError = CustomRestError.builder()
                .message(exception.getCause().getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return responseEntity(customRestError);
    }

    /**
     * Indicates that the request made is in an incorrect format.
     *
     * @param exception  Already Exists Exception
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
     * @since 1.0.0
     */
    @ExceptionHandler({
            VenueAlreadyException.class,
            RoomAlreadyException.class
    })
    public ResponseEntity<CustomRestError> alreadyExistsException(final Exception exception, final HttpServletRequest httpServletRequest){
        var customRestError = CustomRestError.builder()
                .message(exception.getCause().getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();
        return responseEntity(customRestError);
    }


    private static ResponseEntity<CustomRestError> responseEntity (CustomRestError customRestError){
        return ResponseEntity.status(HttpStatus.valueOf(customRestError.getStatus()))
                .body(customRestError);
    }
}
