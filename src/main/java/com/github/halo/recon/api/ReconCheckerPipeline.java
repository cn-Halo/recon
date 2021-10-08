package com.github.halo.recon.api;

import java.util.List;
import java.util.Queue;

/**
 * @author yzm
 * @date 2021/10/8 22:24
 */
public class ReconCheckerPipeline {

    List<ReconChecker> checkers;

    public void check(Queue<ReconData> q1, Queue<ReconData> q2) {
        for (ReconChecker checker : checkers) {
            checker.check(q1, q2);
        }
    }


}
