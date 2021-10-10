package com.github.halo.recon.service;

import java.math.BigDecimal;

/**
 * @author yzm
 * @date 2021/10/10 20:45
 */
public class ReconResultBuilder {

    String no;
    BigDecimal amount;
    String result;
    String resultDesc;

    public static ReconResultBuilder instance() {
        return new ReconResultBuilder();
    }

    public ReconResultBuilder no(String no) {
        this.no = no;
        return this;
    }

    public ReconResultBuilder amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public ReconResultBuilder result(String result) {
        this.result = result;
        return this;
    }

    public ReconResultBuilder resultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
        return this;
    }

    public ReconResult build() {
        return new ReconResult() {

            @Override
            public String no() {
                return no;
            }

            @Override
            public BigDecimal amount() {
                return amount;
            }

            @Override
            public String result() {
                return result;
            }

            @Override
            public String resultDesc() {
                return resultDesc;
            }
        };
    }


}
