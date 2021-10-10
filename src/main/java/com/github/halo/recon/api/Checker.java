package com.github.halo.recon.api;

/**
 * @author yzm
 * @date 2021/10/8 22:25
 */
public interface Checker<T> {

    void check(T o1, T o2, CheckerChain chain);

}
