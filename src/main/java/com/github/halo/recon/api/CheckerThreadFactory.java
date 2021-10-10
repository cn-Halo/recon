package com.github.halo.recon.api;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yzm
 * @date 2021/10/10 16:53
 */
public class CheckerThreadFactory implements ThreadFactory {
    private AtomicInteger seq = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "checker-thread-" + seq.getAndIncrement());
    }
}
