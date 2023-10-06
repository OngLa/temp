package kosa.edu.YogitNet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 4xx Client Errors
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized"),
    WRONG_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다"),

    FORBIDDEN(HttpStatus.FORBIDDEN, "Forbidden"),

    NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found"),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 Email 입니다"),

    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed"),

    CONFLICT(HttpStatus.CONFLICT, "Conflict"),
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "존재하는 Email 입니다"),

    // 5xx Server Errors
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),

    NOT_IMPLEMENTED(HttpStatus.NOT_IMPLEMENTED, "Not Implemented"),

    BAD_GATEWAY(HttpStatus.BAD_GATEWAY, "Bad Gateway");

    private final HttpStatus httpStatus;
    private final String message;
}
