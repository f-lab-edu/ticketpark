package com.ticketpark.ticket.service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.ticketpark.common.response.Response;
import com.ticketpark.exception.ErrorCode;
import com.ticketpark.exception.TicketParkException;
import com.ticketpark.ticket.controller.request.TicketOrderRequest;
import com.ticketpark.ticket.model.entity.TicketOrder;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import com.ticketpark.ticket.repository.TicketOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketOrderService {

    private final TicketOrderRepository ticketOrderRepository;
    private final TicketGradeRepository ticketGradeRepository;

    @Transactional
    public void create(TicketOrderRequest request){
        //내가 선택한 좌석 등급의 잔여석 <> 0
        int countTicketGrade = ticketGradeRepository.getCountTicketGrade(request.getTicket_grade_id());

        if(countTicketGrade<=0){
            throw new TicketParkException(ErrorCode.ALREADY_BOOKED);
        }

        //내가 선택한 좌석 예매가 안된 경우
        ticketOrderRepository.getTickOrderBySeatInfo(request.getPerformance_id()
                , request.getTicket_grade_id()
                , request.getSeat_info())
                .ifPresent(ticketOrder -> {throw new TicketParkException(ErrorCode.ALREADY_BOOKED);});

        //여기서부터 예약 start
        //내가 선택한 좌석 등급의 잔여좌석 -1
        ticketGradeRepository.updateSeatCount(request.getPerformance_id());

        //예매정보 저장
        ticketOrderRepository.createTicketOrder(request.getTicketOrderEntity(request));
    }
}
