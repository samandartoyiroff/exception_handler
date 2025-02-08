package uz.pdp.exceptionhandling.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Result does not exist")
@Data
public class NotFoundException extends RuntimeException {

    private String backPath;

    public NotFoundException(String message, String backPath) {
        super(message);
        this.backPath = backPath;
    }
}
