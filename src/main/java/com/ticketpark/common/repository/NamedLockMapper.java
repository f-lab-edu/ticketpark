package com.ticketpark.common.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NamedLockMapper {
   Integer getLock(String lockName, int timeoutSeconds);
   Integer releaseLock(String lockName);
}
