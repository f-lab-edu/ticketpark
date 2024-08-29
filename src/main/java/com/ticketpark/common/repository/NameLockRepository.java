package com.ticketpark.common.repository;

public interface NameLockRepository {
    Integer getLock(String lockName, int timeoutSeconds);
    Integer releaseLock(String lockName);
}
