/*
package com.ticketpark.ticket.configuration;

import com.ticketpark.ticket.member.repository.MemberMapper;
import com.ticketpark.ticket.member.repository.MemberRepository;
import com.ticketpark.ticket.member.repository.MyBatisMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RepositoryConfig {

    private final MemberMapper memberMapper;

    @Bean
    public MemberRepository memberRepository() {
        //TODO Mybatis > JPA
        return new MyBatisMemberRepository(memberMapper);
    }
}

*/
