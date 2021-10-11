package com.github.halo.recon.service;

/**
 * @author yzm
 * @date 2021/10/10 20:16
 */
public interface ReconResult {

//    String no();
//
//    BigDecimal amount();

    ResultTypeEnum result();

    String resultDesc();

    ReconData o1();

    ReconData o2();


}
