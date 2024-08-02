package com.ticketpark.ticket.service;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import com.ticketpark.ticket.fixture.TicketOrderFixture;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class TicketOrderMultiThreadTest {

    @Autowired
    private TicketGradeRepository ticketGradeRepository;

    @Autowired
    private TicketOrderFacade ticketOrderFacade;

    private TicketOrderDto ticketOrderDto;

    @DisplayName("티켓 수 이상 예매요청이 들어오면 남아있는 티켓 수는 0이어야 한다")
    @Test
    void bookTicketByMultiThread() throws InterruptedException {
        //given
        //남아있는 티켓 수 100개
        final int REMAIN_TICKET_COUNT = 100;
        //스레드는 150개 요청
        int threadCount = REMAIN_TICKET_COUNT + 50;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch latch = new CountDownLatch(threadCount);

        //when
        //150번 티켓 예매 요청
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(()->{
                try{
                    String ranDomSeat = String.format("1층-A구역-%s",RandomString.make(4));
                    ticketOrderDto = TicketOrderFixture.getTicketOrderDto(ranDomSeat);
                    ticketOrderFacade.orderTicket(ticketOrderDto);
                }finally {
                    latch.countDown();
                }

            });
        }
        latch.await();

        //then
        int remainTicketCnt = ticketGradeRepository.getCountTicketGrade(ticketOrderDto.getTicket_grade_id());
        //남아있는 티켓이 0미만이라 동시성 이슈 발생
        assertNotEquals(0, remainTicketCnt);
        //TODO 아래 단언문 성공하도록 변경
        //assertEquals(0, remainTicketCnt);
    }
}
