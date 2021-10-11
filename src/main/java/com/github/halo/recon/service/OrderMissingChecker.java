package com.github.halo.recon.service;

import com.github.halo.recon.api.CheckerChain;

import java.util.Iterator;
import java.util.List;

/**
 * @author yzm
 * @date 2021/10/10 15:00
 */
public class OrderMissingChecker extends AbstractChecker<List<ReconData>> {

    private String tpl = "%s单边";

    @Override
    public void check(List<ReconData> o1, List<ReconData> o2, CheckerChain chain) {
        Iterator<ReconData> itr2 = o2.iterator();
        for (ReconData d1 : o1) {
            ReconData t2 = null;
            while (itr2.hasNext()) {
                ReconData d2 = itr2.next();
                if (d1.no().equals(d2.no())) {
                    t2 = d2;
                    itr2.remove();
                    break;
                }
            }
            if (t2 == null) {
                //o2漏单
                ReconResult result = ReconResultBuilder.instance()
                        .no(d1.no())
                        .amount(d1.amount())
                        .result(ResultTypeEnum.ORDER_MISSING_ERROR.name())
                        .resultDesc(String.format(tpl, d1.source()))
                        .o1(d1)
                        .o2(null)
                        .build();
                super.addResult(result);
            } else
                chain.check(d1, t2);
        }

        for (ReconData d2 : o2) {
            //都是o1漏单的
            ReconResult result = ReconResultBuilder.instance()
                    .no(d2.no())
                    .amount(d2.amount())
                    .result(ResultTypeEnum.ORDER_MISSING_ERROR.name())
                    .resultDesc(String.format(tpl, d2.source()))
                    .o1(null)
                    .o2(d2)
                    .build();
            super.addResult(result);
        }
    }
}
