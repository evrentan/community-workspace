package evrentan.community.usermanager.dto.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomRestError {

    private final Integer status;

    private final String message;
}
