package com.ticketpark.ticket.model.entity;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TicketOrder {
    private Long ticket_order_id;
    private Long member_id;
    private Long performance_id;
    private Long ticket_grade_id;
    private String seat_info;
    private LocalDateTime created_dt;

    @Builder
    public TicketOrder(Long member_id, Long performance_id, Long ticket_grade_id, String seat_info, LocalDateTime created_dt) {
        this.member_id = member_id;
        this.performance_id = performance_id;
        this.ticket_grade_id = ticket_grade_id;
        this.seat_info = seat_info;
        this.created_dt = created_dt;
    }
}
