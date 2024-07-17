package com.ticketpark.ticket.model.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TicketGradeDto {
    //티켓 등급
    private String grade;
    //티켓 등급 명
    private String grade_name;
    //티켓 등급별 좌석 수
    private Integer seat_count;
    //티켓 좌석 수
    private Double price;
    //티켓 등급 생성 일시(이력용)
    private LocalDateTime created_dt;
    //티켓 테이블 pk
    private Long ticket_id;

    public TicketGradeDto(String grade, String grade_name, Integer seat_count, Double price, LocalDateTime created_dt) {
        this.grade = grade;
        this.grade_name = grade_name;
        this.seat_count = seat_count;
        this.price = price;
        this.created_dt = created_dt;
    }
}


