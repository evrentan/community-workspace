package evrentan.community.eventmanager.exception;


import lombok.Builder;
import lombok.Data;

/**
 * Custom Rest Error Class
 *
 * @author <a href="https://github.com/Onuraktasj">Onur Aktas</a>
 * @since 1.0.0
 */
@Data
@Builder
public class CustomRestError {

    private Integer status;

    private String message;
}
