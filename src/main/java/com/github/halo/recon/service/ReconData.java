package com.github.halo.recon.service;

import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;

/**
 * @author yzm
 * @date 2021/10/8 22:11
 */
public interface ReconData {

    /**
     * 订单金额
     *
     * @return
     */
    @NotNull
    BigDecimal amount();
    
    /**
     * 商户支付/退款订单号
     *
     * @return
     */
    @NotNull
    String no();

    /**
     * 账单源
     *
     * @return
     */
    @NotNull
    String source();

}
