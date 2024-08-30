package com.ticketpark.common.util;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.function.Supplier;

@Component
public class TransactionExecutor {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public <T> T executeWithRequireNew(Supplier<T> supplier) {
        return supplier.get();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public <T> T executeWithMandatory(Supplier<T> supplier) {
        return supplier.get();
    }
}

