package com.github.halo.recon.service;

/**
 * @author yzm
 * @date 2021/10/10 20:07
 */
public enum ResultTypeEnum {

    ORDER_MISSING_ERROR("漏单"),
    ORDER_TRADE_STATUS_ERROR("订单状态不一致"),
    ORDER_AMOUNT_ERROR("订单金额不一致"),
    SUCCESS("对平"),
    ;


    ResultTypeEnum(String msg) {
        this.msg = msg;
    }

    private String msg;

    public String msg() {
        return this.msg;
    }


}
