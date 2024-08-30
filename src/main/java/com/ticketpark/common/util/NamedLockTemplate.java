package com.ticketpark.common.util;

import com.ticketpark.common.repository.NameLockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NamedLockTemplate {

    private final NameLockRepository nameLockRepository;

    public void execute(String lockName, int timeoutSeconds, Runnable runnable)  {

        try {
            getLock(lockName, timeoutSeconds);
            runnable.run();
        } finally {
            // 락 해제
            releaseLock(lockName);
        }
    }

    private void getLock(String lockName, int timeoutSeconds) {
        Integer resultGetLock = nameLockRepository.getLock(lockName, timeoutSeconds);
        if(resultGetLock == 0 || resultGetLock == null) {
            throw new IllegalStateException("NamedLock 락 획득 실패 [ " + lockName + " ]");
        }
    }

    private void releaseLock(String lockName) {
        Integer resultReleaseLock = nameLockRepository.releaseLock(lockName);
        if(resultReleaseLock == 0 || resultReleaseLock == null) {
            throw new IllegalStateException("NamedLock 락 반납 실패 [ " + lockName + " ]");
        }
    }

}
