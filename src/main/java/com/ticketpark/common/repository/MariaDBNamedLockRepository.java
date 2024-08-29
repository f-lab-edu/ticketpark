package com.ticketpark.common.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MariaDBNamedLockRepository implements NameLockRepository {

    private final NamedLockMapper namedLockMapper;

    @Override
    public Integer getLock(String lockName, int timeoutSeconds) {
        return namedLockMapper.getLock(lockName, timeoutSeconds);
    }

    @Override
    public Integer releaseLock(String lockName) {
        return namedLockMapper.releaseLock(lockName);
    }
}
