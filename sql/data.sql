DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
                          `member_sid`	bigint	NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '회원SID',
                          `id`	        varchar(50)	 NOT NULL	COMMENT '회원 아이디',
                          `role`	        char(1)	NULL	DEFAULT '2'	COMMENT '권한(1:관리자/2:일반)',
                          `password`	    varchar(100)	NOT NULL,
                          `email`     	varchar(100)	NULL	COMMENT '이메일 주소',
                          `hp_no`	        varchar(100)	NULL	COMMENT '핸드폰 번호',
                          `created_dt`	timestamp	NULL	DEFAULT NOW()	COMMENT '회원 생성일시',
                          `updated_dt`	timestamp	NULL	COMMENT '회원 수정일시',
                          `use_yn`	    char(1)	NULL	DEFAULT 'Y'	COMMENT '회원 삭제 구분'
);

DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance` (
                               `performance_sid`	    bigint	NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '공연SID',
                               `genre`	                char(1)	NULL	COMMENT '공연 장르 구분 값',
                               `name`	                varchar(500)	NULL	COMMENT '공연 이름',
                               `place`	                bigint	NULL	DEFAULT NOW(),
                               `performance_start_dt`	timestamp	NOT NULL COMMENT '공연 시작 일시',
                               `performance_end_dt`	timestamp	NOT NULL COMMENT '공연 종료 일시',
                               `reserve_start_dt`	    timestamp	NOT NULL	COMMENT '예매시작시간',
                               `reserve_end_dt`	    timestamp	NOT NULL	COMMENT '예매종료시간',
                               `created_at`	        bigint	NULL	DEFAULT NOW()	COMMENT '공연정보 생성일시',
                               `read_count`	        int	DEFAULT 0	COMMENT '공연 상세 화면 조회 수',
                               `performer_sid`     	bigint	NOT NULL	COMMENT '회원key'
);

DROP TABLE IF EXISTS `performer`;
CREATE TABLE `performer` (
                             `performer_sid`	bigint	NOT NULL	COMMENT '공연SID',
                             `name`	varchar(300)	NOT NULL	    COMMENT '공연자명'
);

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
                          `ticket_sid`	    bigint	    NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '티켓SID',
                          `ticket_no`			int	    	NOT NULL	COMMENT '티켓번호',
                          `ticket_date`	    timestamp	NOT NULL	COMMENT '예매한 공연일자',
                          `grade`	            char(1)	    NOT NULL	COMMENT '예매한 좌석 등급',
                          `price`	            bigint	    NULL        COMMENT '티켓 가격',
                          `created_dt`	    bigint	    NULL	    COMMENT '티켓 생성일시',
                          `reservation_sid`	bigint	    NOT NULL	COMMENT '예매SID',
                          `performance_sid`	bigint	    NOT NULL	COMMENT '공연SID'
);

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
                               `reservation_sid`	bigint	    NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '예매SID',
                               `status`	        char(1)	    NOT NULL	COMMENT '예매상태(S:결제완료/C:결제취소)',
                               `created_dt`	    timestamp	NOT NULL	DEFAULT NOW()	COMMENT '예매 생성일시',
                               `updated_dt`	    timestamp	NULL	    DEFAULT NOW()	COMMENT '예매수정일시',
                               `member_sid`	    bigint	    NOT NULL	COMMENT '회원SID'
);