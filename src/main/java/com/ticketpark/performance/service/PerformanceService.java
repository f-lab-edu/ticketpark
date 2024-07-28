package com.ticketpark.performance.service;

import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.model.entity.Performance;
import com.ticketpark.performance.model.entity.Performer;
import com.ticketpark.performance.repository.PerformanceRepository;
import com.ticketpark.performance.repository.PerformerRepository;
import com.ticketpark.ticket.model.dto.TicketCreateDto;
import com.ticketpark.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PerformanceService {

    private final PerformanceRepository performanceRepository;
        private final PerformerRepository performerRepository;
        private final TicketService ticketService;

        @Transactional
        public void create(PerformanceCreateRequest request) {
            //----------------------------
            //공연(공연 + 가수) 등록
            //----------------------------
            //공연 등록
            Performance performance = request.getPermanceEntity(request);
            performanceRepository.createPerformance(performance);

            Long performanceId = performance.getPerformance_id();
            Objects.requireNonNull(performanceId, "table Performance pk is null");

            //가수 등록
            performerRepository.createPerformer(request.getPerformerList(performanceId, request));
            //----------------------------
            //티켓 등록(티켓 정보 + 좌석 등급)
            //----------------------------
            //티켓과 공연 key 언걸
            TicketCreateDto ticketDto = TicketCreateDto.fromRequest(request);
            Objects.requireNonNull(ticketDto.getTicket(), "ticket request is null");
            Objects.requireNonNull(ticketDto.getTicketGrade(), "ticketGrade is null");

            request.getTicket().connectPerformance(performanceId);
            ticketService.createTicket(ticketDto);
        }
}
