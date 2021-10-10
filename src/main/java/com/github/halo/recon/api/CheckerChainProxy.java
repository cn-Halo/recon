package com.github.halo.recon.api;

import java.util.Queue;

/**
 * @author yzm
 * @date 2021/10/10 14:52
 */
public class CheckerChainProxy implements CheckerChain {

    private Queue<Checker> checkers;

    public CheckerChainProxy(Queue<Checker> checkers) {
        this.checkers = checkers;
    }

    public void check(Object o1, Object o2) {
        Checker nextChecker = next();
        nextChecker.check(o1, o2, this);
    }

    public Checker next() {
        return checkers.poll();
    }
}
