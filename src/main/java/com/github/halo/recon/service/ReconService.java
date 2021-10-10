package com.github.halo.recon.service;

import com.github.halo.recon.api.Checker;
import com.github.halo.recon.api.CheckerChainProxy;
import com.github.halo.recon.api.CheckerPipeline;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yzm
 * @date 2021/10/10 21:31
 */
public class ReconService {


    Queue<Checker> checkers = new LinkedList<>();
    CheckerChainProxy checkerChainProxy = new CheckerChainProxy(checkers);
    private CheckerPipeline checkerPipeline = new CheckerPipeline(Arrays.asList(checkerChainProxy));
    OrderAmountChecker orderAmountChecker = new OrderAmountChecker();
    OrderMissingChecker orderMissingChecker = new OrderMissingChecker();

    public ReconService() {

    }

    public void initChecker() {
    }

    public void check(List<ReconData> o1, List<ReconData> o2) {
        

    }

}
