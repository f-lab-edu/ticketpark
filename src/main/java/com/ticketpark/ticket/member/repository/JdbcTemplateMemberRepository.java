package com.ticketpark.ticket.member.repository;

import com.ticketpark.ticket.member.model.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class JdbcTemplateMemberRepository implements IMemberRepository {

    //TODO 일단 날쿼리로 구현하고 JPA로 변경하는 방향으로..
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member addMember(Member member) {
        log.info("insert 전...............");
        String query = "insert into member(id, role, password, email, hp_no) value(:id, :role, :password, :email, :hp_no)";

        SqlParameterSource param = new BeanPropertySqlParameterSource(member);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(query, param, keyHolder);

        Long key = keyHolder.getKey().longValue();
        member.setMember_sid(key);
        log.info("insert 후...............");
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        String query = "select id from member where id = :id";
        Map<String, Object> param = Map.of("id", id);
        Member member = jdbcTemplate.queryForObject(query, itemRowMapper(), param);
        return Optional.ofNullable(member);
    }

    private RowMapper<Member> itemRowMapper() {
        return BeanPropertyRowMapper.newInstance(Member.class); //camel 변환 지원
    }
}
