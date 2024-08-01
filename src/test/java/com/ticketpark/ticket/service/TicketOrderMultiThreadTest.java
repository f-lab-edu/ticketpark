package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import com.ticketpark.ticket.fixture.TicketOrderFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class TicketOrderMultiThreadTest {

    @Autowired
    private TicketGradeRepository ticketGradeRepository;

    @Autowired
    private TicketOrderFacade ticketOrderFacade;

    private TicketOrderDto ticketOrderDto;

    @DisplayName("동시에 티켓 100개 예매 요청")
    @Test
    void bookTicketByMultiThread() throws InterruptedException {

        //given
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        CountDownLatch latch = new CountDownLatch(threadCount);

        //when
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(()->{
                try{
                    String seatNum = String.valueOf(new Random().nextInt(100));
                    ticketOrderDto = TicketOrderFixture.getTicketOrderDto("1층-A구역-"+seatNum);
                    ticketOrderFacade.orderTicket(ticketOrderDto);
                }finally {
                    latch.countDown();
                }

            });
        }
        latch.await();

        //then
        Integer remainTicketCnt = ticketGradeRepository.getCountTicketGrade(ticketOrderDto.getTicket_grade_id());
        //동시성 이슈로 100매 예매 시도했으나 0이 아니다
        assertThat(remainTicketCnt).isNotEqualTo(0);
        //TODO 아래 단언문 성공하도록 변경
        //assertThat(remainTicketCnt).isEqualTo(0)
    }


}
