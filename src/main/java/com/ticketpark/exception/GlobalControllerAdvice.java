package com.ticketpark.exception;

import com.ticketpark.common.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(TicketParkException.class)
    public ResponseEntity<?> errorHandler(TicketParkException e) {
        log.error("Error occurs {}", e.toString());

        return ResponseEntity.status(e.getErrorCode().getStatus().getHttpCode())
                .body(Response.error(e.getErrorCode().name()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> inValidRequestHandler(MethodArgumentNotValidException e) {
        log.error("Error occurs {}", e.toString());

        List<String> errorMessages = e.getBindingResult().getFieldErrors().stream().map(fieldError -> {
            return String.format("%s./잘못 입력된 데이터 : [%s]"
                    , fieldError.getDefaultMessage()
                    , fieldError.getRejectedValue());
        }).toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(Response.error(errorMessages));
    }
}
