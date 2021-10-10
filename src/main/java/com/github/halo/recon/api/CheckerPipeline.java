package com.github.halo.recon.api;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yzm
 * @date 2021/10/8 22:24
 */
public class CheckerPipeline {

    List<CheckerChain> checkerChains = null;
    ExecutorService executor = null;

    public CheckerPipeline(List<CheckerChain> checkerChains) {
        if (Objects.isNull(checkerChains))
            throw new NullPointerException("checkerChains is null");
        this.checkerChains = checkerChains;
        if (checkerChains.size() > 1) {
            int threadNum = checkerChains.size() > Runtime.getRuntime().availableProcessors() ?
                    Runtime.getRuntime().availableProcessors() : checkerChains.size();
            executor = Executors.newFixedThreadPool(threadNum, new CheckerThreadFactory());
        }

    }

    public void check(CheckObject q1, CheckObject q2) {
        if (q1.isCopy()) {
            CheckObject _q1 = (CheckObject) q1.clone();
            System.out.println(_q1);
            q1 = _q1;
        }
        if (q2.isCopy()) {
            CheckObject _q2 = (CheckObject) q2.clone();
            System.out.println(_q2);
            q2 = _q2;
        }
        for (CheckerChain checkerChain : checkerChains) {
            if (executor != null) {
                CheckObject fQ1 = q1;
                CheckObject fQ2 = q2;
                executor.submit(() -> {
                    checkerChain.check(fQ1, fQ2);
                });
            } else {
                checkerChain.check(q1, q2);
            }
        }
    }

    public void check(final Object q1, final Object q2) {
        for (CheckerChain checkerChain : checkerChains) {
            if (executor != null) {
                Object fQ1 = q1;
                Object fQ2 = q2;
                executor.submit(() -> {
                    checkerChain.check(fQ1, fQ2);
                });
            } else {
                checkerChain.check(q1, q2);
            }
        }
    }


}
