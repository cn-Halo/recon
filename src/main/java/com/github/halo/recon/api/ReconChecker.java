package com.github.halo.recon.api;

import java.util.Queue;

/**
 * @author yzm
 * @date 2021/10/8 22:25
 */
public interface ReconChecker {

    void check(Queue<ReconData> q1, Queue<ReconData> q2);

}
