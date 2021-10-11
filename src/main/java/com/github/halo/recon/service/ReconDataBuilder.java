package com.github.halo.recon.service;

import java.math.BigDecimal;

/**
 * Created on 2021/10/11.
 *
 * @author yzm
 */
public class ReconDataBuilder {

    private BigDecimal amount;
    private String no;
    private String source;


    public ReconDataBuilder amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public ReconDataBuilder no(String no) {
        this.no = no;
        return this;
    }

    public ReconDataBuilder source(String source) {
        this.source = source;
        return this;
    }

    public static ReconDataBuilder instance() {
        return new ReconDataBuilder();
    }

    public ReconData build() {
        return new ReconData() {
            @Override
            public BigDecimal amount() {
                return amount;
            }

            @Override
            public String no() {
                return no;
            }

            @Override
            public String source() {
                return source;
            }
        };
    }


}
