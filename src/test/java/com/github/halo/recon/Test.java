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
        test2();
    }


    public static void test1() {
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

    public static void test2() {
        List<ReconData> o1 = new ArrayList<>(Arrays.asList(
                new MyReconData().amount("0.10").no("20210624133938113C57D6CD5420AB26").source("支付平台").tradeStatus("TRADE_SUCCESS"),
                new MyReconData().amount("0.10").no("20210624134033587C57D6CD5420CB26").source("支付平台").tradeStatus("TRADE_SUCCESS"),
                new MyReconData().amount("0.10").no("20210624135437991C57DA88D21A625E").source("支付平台").tradeStatus("TRADE_SUCCESS"),
                new MyReconData().amount("0.10").no("20210624140704444C57D6CD5420EB26").source("支付平台").tradeStatus("TRADE_SUCCESS"),
                new MyReconData().amount("0.10").no("20210624141321005C57D6CD54210B26").source("支付平台").tradeStatus("TRADE_SUCCESS")
        ));

        List<ReconData> o2 = new ArrayList<>(Arrays.asList(
                new MyReconData().amount("0.10").no("20210624141321005C57D6CD54210B26").source("微信").tradeStatus("TRADE_SUCCESS"),
                new MyReconData().amount("0.10").no("20210624134033587C57D6CD5420CB26").source("微信").tradeStatus("TRADE_SUCCESS"),
                new MyReconData().amount("0.10").no("20210624140704444C57D6CD5420EB26").source("微信").tradeStatus("TRADE_SUCCESS"),
                new MyReconData().amount("0.10").no("GYS20191209161637505057").source("微信").tradeStatus("TRADE_SUCCESS"),
                new MyReconData().amount("0.10").no("20210624135437991C57DA88D21A625E").source("微信").tradeStatus("TRADE_SUCCESS"),
                new MyReconData().amount("0.10").no("20210624133938113C57D6CD5420AB26").source("微信").tradeStatus("TRADE_SUCCESS")
        ));

        ReconService reconService = new ReconService();
        List<ReconResult> results = reconService.check(o1, o2);
        System.out.println(results+" ");

        for (ReconResult result : results) {
            System.out.print(result.resultDesc()+" ");
            if (result.o1() != null) {
                System.out.print(result.o1().no()+" ");
            }
            if (result.o2() != null) {
                System.out.print(result.o2().no()+" ");
            }
            System.out.println("");
        }
    }


    static class MyReconData implements ReconData {

        private BigDecimal amount;
        private String no;
        private String source;
        private String tradeStatus;


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
            return this.tradeStatus = tradeStatus;
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

        public MyReconData tradeStatus(String tradeStatus) {
            this.tradeStatus = tradeStatus;
            return this;
        }
    }
}
