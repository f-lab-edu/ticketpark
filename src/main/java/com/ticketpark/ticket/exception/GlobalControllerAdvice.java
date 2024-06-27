package com.ticketpark.ticket.exception;

import com.ticketpark.ticket.common.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(TicketParkException.class)
    public ResponseEntity<?> errorHandler(TicketParkException e) {
        log.error("Error occurs {}", e.toString());

        return ResponseEntity.status(e.getErrorCode().getStatus().getHttpCode())
                .body(Response.error(e.getErrorCode().name()));
    }
}
