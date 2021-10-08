package com.github.halo.recon.api;

import java.util.Queue;

/**
 * @author yzm
 * @date 2021/10/8 22:10
 */
public interface Reconciliation {

    void reconcile(Queue<ReconData> q1, Queue<ReconData> q2);


}
