package com.github.halo.recon;

import com.github.halo.recon.service.ReconData;
import com.github.halo.recon.service.ReconResult;
import com.github.halo.recon.service.ReconService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yzm
 * @date 2021/10/10 22:19
 */
public class Test {


    public static void main(String[] args) {
        ReconService reconService = new ReconService();
        List<ReconData> o1 = Arrays.asList(new MyReconData().no("1").amount("1.00").source("微信"),
                new MyReconData().no("2").amount("2").source("微信"),
                new MyReconData().no("3").amount("13").source("微信"));

        List<ReconData> o2 = Arrays.asList(new MyReconData().no("1").amount("1.0").source("HIS"),
                new MyReconData().no("2").amount("20").source("HIS"),
                new MyReconData().no("4").amount("13").source("HIS"));
        List<ReconResult> results = reconService.check(new ArrayList<>(o1), new ArrayList<>(o2));
        System.out.println(results);
    }


    static class MyReconData implements ReconData {

        private BigDecimal amount;
        private String no;
        private String source;


        @Override
        public BigDecimal amount() {
            return this.amount;
        }

        @Override
        public String no() {
            return this.no;
        }

        @Override
        public String source() {
            return this.source;
        }

        @Override
        public String tradeStatus() {
            return "TRADE_SUCCESS";
        }

        public MyReconData amount(String amount) {
            this.amount = new BigDecimal(amount);
            return this;
        }

        public MyReconData no(String no) {
            this.no = no;
            return this;
        }

        public MyReconData source(String source) {
            this.source = source;
            return this;
        }
    }
}
