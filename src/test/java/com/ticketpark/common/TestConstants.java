package com.ticketpark.common;

import java.time.LocalDateTime;

public interface TestConstants {
    public static final LocalDateTime fixDate = LocalDateTime.of(2024,8,1,18,0);
    
    //티켓 예매 관련
    public static final Long defaultMemberId = 1L;
    public static final Long defaultPerformanceId = 1L;
    public static final Long defaultTicketGradeId = 1L;
    public static final String defaultSeatInfo = "1층-C구역-17열-10";
}
