package evrentan.community.usermanager.exception;

import evrentan.community.usermanager.dto.exception.CustomRestError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler Class
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
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
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @ExceptionHandler({
            BadRequestException.class,
            IdNotMatchException.class
    })
    public ResponseEntity<CustomRestError> badRequestException(final Exception exception, final HttpServletRequest httpServletRequest){
        var customRestError = CustomRestError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return responseEntity(customRestError);

    }

    /**
     * indicates that such a page does not exist on the server or that there is an error in the page path
     *
     * @param exception Bad Request Exception
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @ExceptionHandler({
            NotFoundException.class,
            UserNotFoundException.class,
            UserTypeNotFoundException.class
    })
    public ResponseEntity<CustomRestError> notFoundException(final Exception exception, final HttpServletRequest httpServletRequest) {
        var customRestError = CustomRestError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return responseEntity(customRestError);
    }

    /**
     * indicates a conflict exception
     *
     * @param exception Conflict Exception
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @ExceptionHandler({
            UserTypeAlreadyExistsException.class,
            UserAlreadyExistsException.class
    })
    public ResponseEntity<CustomRestError> alreadyExistsException(final Exception exception, final HttpServletRequest httpServletRequest) {
        var customRestError = CustomRestError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();
        return responseEntity(customRestError);
    }

    /**
     * indicates that there is a situation that is not going well on the server
     *
     * @param exception Bad Request Exception
     * @param httpServletRequest   Web request
     *
     * @return ResponseEntity
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<CustomRestError> internalServerException(final Exception exception,final  HttpServletRequest httpServletRequest){
        var customRestError = CustomRestError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return responseEntity(customRestError);
    }

    /**
     * Creates response exception message
     *
     * @param customRestError to create the response
     *
     * @return CustomerRestError within ResponseEntity
     *
     * @author <a href="https://github.com/evrentan">Evren Tan</a>
     * @since 1.0.0
     */
    private static ResponseEntity<CustomRestError> responseEntity(CustomRestError customRestError) {
        return ResponseEntity.status(HttpStatus.valueOf(customRestError.getStatus()))
                .body(customRestError);
    }
}

