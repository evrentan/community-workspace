package evrentan.community.venuemanager.dto.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomRestError {

    private Integer status;

    private String message;
}
