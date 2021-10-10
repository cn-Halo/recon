package com.github.halo.recon.service;

import com.github.halo.recon.api.Checker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzm
 * @date 2021/10/10 20:03
 */
public abstract class AbstractChecker<T> implements Checker<T> {

    private List<ReconResult> results = new ArrayList<>();

    public void addResult(ReconData o1, ReconData o2, ResultTypeEnum resultTypeEnum) {

    }

    public void addResult(ReconResult result) {
        results.add(result);
    }

}
