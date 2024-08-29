package com.ticketpark.ticket.model.entity;

import com.ticketpark.ticket.model.dto.TicketGradeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
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
    //낙관적 락 구현 위한 version
    private Long version;

    public TicketGrade(String grade, String grade_name, Integer seat_count, Double price, LocalDateTime created_dt, Long ticket_id){
        this.grade = grade;
        this.grade_name = grade_name;
        this.seat_count = seat_count;
        this.price = price;
        this.created_dt = created_dt;
        this.ticket_id = ticket_id;
    }

    public static List<TicketGrade> getPerformerList(Long ticketId, List<TicketGradeDto> gradeList){
        List<TicketGrade> list = new ArrayList<>();

        for (TicketGradeDto dto : gradeList) {
            list.add(new TicketGrade(
                    dto.getGrade()
                    , dto.getGrade_name()
                    , dto.getSeat_count()
                    , dto.getPrice()
                    , LocalDateTime.now()
                    , ticketId
            ));
        }
        return list;
    }
}
