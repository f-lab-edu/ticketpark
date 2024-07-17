package com.ticketpark.performance.service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.ticketpark.exception.TicketParkException;
import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.model.dto.PerformanceCreateDto;
import com.ticketpark.performance.model.entity.Performance;
import com.ticketpark.performance.model.entity.Performer;
import com.ticketpark.performance.repository.PerformanceRepository;
import com.ticketpark.performance.repository.PerformerRepository;
import com.ticketpark.ticket.model.dto.TicketCreateDto;
import com.ticketpark.ticket.model.dto.TicketDto;
import com.ticketpark.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PerformanceService {

    private final PerformanceRepository performanceRepository;
        private final PerformerRepository performerRepository;
        private final TicketService ticketService;

        @Transactional
        public void createPerformance(PerformanceCreateRequest request) {
            //----------------------------
            //공연(공연 + 가수) 등록
            //----------------------------
            //공연 등록
            Performance performance = Performance.of(request);
            performanceRepository.createPerformance(performance);

            Long performanceId = performance.getPerformance_id();
            Optional.ofNullable(performanceId).orElseThrow(() ->
                new IllegalArgumentException("table Performance pk is null")
            );
            //가수 등록
            performerRepository.createPerformer(Performer.getPerformerList(performanceId, request));
            //----------------------------
            //티켓 등록(티켓 정보 + 좌석 등급)
            //----------------------------
            //티켓과 공연 key 언걸
            TicketCreateDto ticketDto = TicketCreateDto.fromRequest(request);
            Optional.ofNullable(ticketDto.getTicket()).orElseThrow(() ->
                new IllegalArgumentException("ticket request is null")
            );
            request.getTicket().setPerformance_id(performanceId);
            ticketService.createTicket(ticketDto);
        }
}
