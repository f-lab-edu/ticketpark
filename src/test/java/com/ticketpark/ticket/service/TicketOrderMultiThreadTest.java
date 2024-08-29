package com.ticketpark.ticket.service;

import com.ticketpark.common.TestConstants;
import com.ticketpark.common.TestDataCleaner;
import com.ticketpark.performance.fixture.PerformanceRequestFixture;
import com.ticketpark.performance.service.PerformanceService;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class TicketOrderMultiThreadTest {

    //region [테스트 데이터 셋팅 위한 필드]
    @Autowired
    private PerformanceService  performanceService;

    @Autowired
    private TestDataCleaner testDataUtil;
    //endregion

    @Autowired
    private TicketGradeRepository ticketGradeRepository;

    @Autowired
    private TicketOrderFacade ticketOrderFacade;

    private TicketOrderDto ticketOrderDto;

    @BeforeEach
    void setup() {
        /*------------------------------------------------
        멀티스레드 테스트는 롤백테스트 적용 안되는 문제가 있어서
        별도의 테스트 데이터 생성 및 제거가 필요함
        ------------------------------------------------*/
        //공연, 티켓, 티켓 등급 테스트 데이터 생성
        performanceService.create(PerformanceRequestFixture.getPerformanceCreateRequest());
    }

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
                    boolean isActiveTran = TransactionSynchronizationManager.isActualTransactionActive();
                    String ranDomSeat = String.format("1층-A구역-%s", RandomString.make(4));
                    ticketOrderDto = getTicketOrderDto(
                            TestConstants.defaultPerformanceId + 1
                            , TestConstants.defaultTicketGradeId + 1
                            , ranDomSeat);
                    ticketOrderFacade.orderTicket(ticketOrderDto);
                } finally {
                    latch.countDown();
                }

            });
        }
        latch.await();

        //then
        int remainTicketCnt = ticketGradeRepository.getCountTicketGrade(ticketOrderDto.getTicket_grade_id());
        //TODO 아래 단언문 성공하도록 변경
        assertEquals(0, remainTicketCnt);
    }

    //티켓 요청 Dto request
    private TicketOrderDto getTicketOrderDto(Long performanceId, Long ticketGradeId, String seatInfo) {
        return TicketOrderDto.builder()
                .member_id(TestConstants.defaultMemberId)
                .performance_id(performanceId)
                .ticket_grade_id(ticketGradeId)
                .seat_info(seatInfo)
                .created_dt(LocalDateTime.now())
                .build();
    }

    @AfterEach
    void tearDown() {
        testDataUtil.cleanAll();
    }

}
