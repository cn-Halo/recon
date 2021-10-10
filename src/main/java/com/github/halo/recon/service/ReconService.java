package com.github.halo.recon.service;

import com.github.halo.recon.api.Checker;
import com.github.halo.recon.api.CheckerChainProxy;
import com.github.halo.recon.api.CheckerPipeline;

import java.util.*;

/**
 * @author yzm
 * @date 2021/10/10 21:31
 */
public class ReconService {


    public List<ReconResult> check(List<ReconData> o1, List<ReconData> o2) {
        Queue<Checker> checkers = new LinkedList<>();
        OrderAmountChecker orderAmountChecker = new OrderAmountChecker();
        OrderMissingChecker orderMissingChecker = new OrderMissingChecker();
        checkers.offer(orderMissingChecker);
        for (int i = 0; i < o1.size(); i++) {
            checkers.offer(orderAmountChecker);
        }

        CheckerChainProxy checkerChainProxy = new CheckerChainProxy(checkers);
        CheckerPipeline checkerPipeline = new CheckerPipeline(Arrays.asList(checkerChainProxy));
        checkerPipeline.check(o1, o2);

        List<ReconResult> results = new ArrayList<>();
        results.addAll(orderAmountChecker.getResult());
        results.addAll(orderMissingChecker.getResult());
        return results;
    }

}
