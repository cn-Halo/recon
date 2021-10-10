package com.github.halo.recon.api;

/**
 * @author yzm
 * @date 2021/10/10 14:25
 */
public interface CheckerChain {

    void check(Object o1, Object o2);

    Checker next();

}
