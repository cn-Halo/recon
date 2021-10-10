package com.github.halo.recon.service;

import java.math.BigDecimal;

/**
 * @author yzm
 * @date 2021/10/10 20:16
 */
public interface ReconResult {

    String no();

    BigDecimal amount();

    String result();

    String resultDesc();


}
