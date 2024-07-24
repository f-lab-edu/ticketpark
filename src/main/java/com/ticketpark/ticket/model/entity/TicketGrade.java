package com.ticketpark.ticket.model.entity;

import com.ticketpark.ticket.model.dto.TicketGradeDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TicketGrade {
    //pk
    private Long ticket_grade_id;
    //티켓 등급
    private String grade;
    //티켓 등급 명칭
    private String grade_name;
    //티켓 등급별 좌석 수
    private Integer seat_count;
    //티켓 가격
    private Double price;
    //티켓 등급 생성 일시(이력용)
    private LocalDateTime created_dt;
    //ticket 테이블 pk
    private Long ticket_id;

    public static List<TicketGrade> getPerformerList(Long ticketId, List<TicketGradeDto> gradeList){
        List<TicketGrade> list = new ArrayList<>();

        for (TicketGradeDto dto : gradeList) {
            TicketGrade grade = new TicketGrade();
            grade.setGrade(dto.getGrade());
            grade.setGrade_name(dto.getGrade_name());
            grade.setSeat_count(dto.getSeat_count());
            grade.setPrice(dto.getPrice());
            grade.setCreated_dt(LocalDateTime.now());
            grade.setTicket_id(ticketId);

            list.add(grade);
        }
        return list;
    }
}
