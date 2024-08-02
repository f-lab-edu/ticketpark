BEGIN;
insert into member(id, role, password, email, hp_no, created_dt, updated_dt)
values('test', 'U', '1q2w3e4r', 'aa@email.com', 01012345678, now(), now());

SET @fix_date = '2024-08-01 18:00:00';
insert into performance (genre, name, place, start_dt, end_dt, created_at)
values('CO', '2024 SM 통합콘서트', '고척돔', date_add(@fix_date , INTERVAL 10 DAY), date_add(@fix_date , INTERVAL 12 DAY), NOW());

insert into performer(name, performance_id)
values('에스파', 1), ('nct', 1), ('라이즈', 1);

insert into ticket (start_dt, end_dt, created_dt, performance_id)
values(date_add(@fix_date , INTERVAL 3 DAY),date_add(@fix_date , INTERVAL 10 DAY), now(), 1);

insert into ticket_grade(grade, grade_name, seat_count, price, created_dt, ticket_id)
values ('VIP', 'VIP석', 100, 200000, NOW(), 1)
     , ('S', 'S석', 100, 150000, NOW(), 1)
     , ('R', 'R석', 100, 100000, NOW(), 1);
COMMIT;