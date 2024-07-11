-- 회원
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
    `member_id`         bigint	      NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '회원 id pk',
    `id`	            varchar(50)	  NOT NULL	COMMENT '회원 아이디',
    `role`	            char(1)	      NULL	DEFAULT '2'	COMMENT '권한(1:관리자/2:일반)',
    `password`	        varchar(100)  NOT NULL,
    `email`     	    varchar(100)  NULL	COMMENT '이메일 주소',
    `hp_no`	            varchar(100)  NULL	COMMENT '핸드폰 번호',
    `created_dt`	    timestamp	  NULL	DEFAULT NOW()	COMMENT '회원 생성일시',
    `updated_dt`	    timestamp	  NULL	COMMENT '회원 수정일시',
    `use_yn`	        char(1)	      NULL DEFAULT 'Y'	COMMENT '회원 삭제 구분'
);

-- 공연
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance` (
    `performance_id`    bigint	      NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '공연 ID',
    `genre`	            varchar(2)	  NULL	COMMENT '공연 장르 구분 값',
    `name`	            varchar(500)  NULL	COMMENT '공연 이름',
    `place`	            varchar(500)  NULL    COMMENT '공연 장소',
    `start_dt`	        timestamp	  NOT NULL    COMMENT '공연 시작 일시',
    `end_dt`	        timestamp	  NOT NULL    COMMENT '공연 종료 일시',
    `created_at`	    timestamp	  NULL	DEFAULT NOW()	COMMENT '공연정보 생성일시'
);

-- 공연자
DROP TABLE IF EXISTS `performer`;
CREATE TABLE `performer` (
    `performer_id`	    bigint	      NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '공연자 ID',
    `name`	            varchar(300)  NOT NULL	COMMENT '공연자명',
    `performance_id`    bigint        NOT NULL	COMMENT '공연 ID'
);

-- 티켓 정보
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
    `ticket_id`	        bigint	      NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '티켓 ID',
    `start_dt`	        timestamp	  NOT NULL	COMMENT '티켓 예매시작시간',
    `end_dt`	        timestamp	  NOT NULL	COMMENT '티켓 예매종료시간',
    `created_dt`	    timestamp     NULL DEFAULT NOW() COMMENT '티켓 생성일시',
    `performance_id`	bigint	      NOT NULL	COMMENT '공연 ID'
);

-- 티켓 등급
DROP TABLE IF EXISTS `ticket_grade`;
CREATE TABLE `ticket_grade` (
    `ticket_grade_id`   bigint	      NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '티켓 등급 ID',
    `grade`	            varchar(10)	  NOT NULL	COMMENT '티켓 등급',
    `grade_name`	    varchar(20)	  NOT NULL	COMMENT '티켓 등급 명칭',
    `seat_count`        mediumint     NOT NULL	COMMENT '티켓 등급별 좌석 수',
    `price`             decimal(18,6) NOT NULL  COMMENT '티켓 가격',
    `created_dt`	    timestamp     NULL DEFAULT NOW() COMMENT '티켓 생성일시',
    `ticket_id`	        bigint	      NOT NULL	COMMENT '티켓 ID'
);

-- 티켓 예매 내역
DROP TABLE IF EXISTS `ticket_order`;
CREATE TABLE `ticket_order` (
    `ticket_order_id`	bigint	      NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT '티켓 SID',
    `member_id`         bigint        NOT NULL    COMMENT '회원 ID',
    `performance_id`    bigint        NOT NULL    COMMENT '공연 ID',
    `ticket_grade_id`   bigint        NOT NULL    COMMENT '티켓 등급 ID',
    `seat_number`       INT           NOT NULL    COMMENT '좌석번호',
    `created_dt`	    timestamp     NULL DEFAULT NOW() COMMENT '티켓 생성일시'
);