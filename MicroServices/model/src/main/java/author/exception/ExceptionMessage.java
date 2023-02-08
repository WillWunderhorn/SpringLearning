package author.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

@Getter
public enum ExceptionMessage {
    AUTHOR_NOT_FOUND(HttpStatus.NOT_FOUND, "Author not found");

    private HttpStatus httpStatus;
    private String message;

    ExceptionMessage(HttpStatus status,
                     String message) {
        this.httpStatus = status;
        this.message = message;
    }
}
