package com.github.halo.recon.service;

import com.github.halo.recon.api.CheckerChain;

/**
 * @author yzm
 * @date 2021/10/10 19:54
 */
public class OrderAmountChecker extends AbstractChecker<ReconData> {

    String tpl = "%s：%s金额=%s，%s金额=%s";

    @Override
    public void check(ReconData o1, ReconData o2, CheckerChain chain) {
        ReconResultBuilder builder = ReconResultBuilder.instance().no(o1.no()).amount(o1.amount());
        ReconResult result = null;
        if (o1.amount().equals(o2)) {
            result = builder
                    .result(ResultTypeEnum.SUCCESS.name())
                    .resultDesc(ResultTypeEnum.SUCCESS.msg()).build();
        } else {
            result = builder
                    .result(ResultTypeEnum.ORDER_AMOUNT_ERROR.name())
                    .resultDesc(String.format(tpl, ResultTypeEnum.ORDER_AMOUNT_ERROR.msg()
                            , o1.source(), o1.amount(), o2.source(), o2.amount())).build();
        }
        super.addResult(result);
    }
}