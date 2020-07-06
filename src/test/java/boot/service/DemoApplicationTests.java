package boot.service;

import boot.repaymentplan.CalTest;
import boot.support.AbstractSpringbootTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class DemoApplicationTests extends AbstractSpringbootTest {

   @Autowired
   CalTest calTest ;

    @Test
    public void contextLoads() throws Exception {

        String nextProvDate ="";
        String forwProvDate="20200701";
        String beginDate="20200701";
        String endDate="20210701";
        BigDecimal rate = BigDecimal.valueOf(0.0005);//利率
        BigDecimal dResNor = BigDecimal.valueOf(10000);//放款金额
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String payDate="1";
        int loanTerm = calTest.fnCalLoanTerm(beginDate,endDate,forwProvDate,payDate,"1");
        System.out.println(loanTerm);

        BigDecimal a[]=new BigDecimal[loanTerm];
        int iDays;

        BigDecimal dNumerator = new BigDecimal("0.00");

        dNumerator=dResNor ;

        BigDecimal dZero = new BigDecimal("0.00");
        BigDecimal dSumPrin = new BigDecimal("0.00");


        for(int i=0;i<=loanTerm; i++){
            //计算1+iDn
            nextProvDate=calTest.fnCalRepayNextDate(beginDate, endDate, forwProvDate,  payDate, "1" );

            iDays = calTest.daysBetween(sf.parse(forwProvDate),sf.parse(nextProvDate));
            BigDecimal one = BigDecimal.valueOf(1);
            dZero=one.add(rate.multiply(BigDecimal.valueOf(iDays)));
            a[i]= dZero ;
            forwProvDate = nextProvDate;

            if (nextProvDate.compareTo(endDate) >= 0) {
                break;
            }
        }

        //计算分子
        for (int i=0;i<a.length;i++){
            dNumerator = dNumerator.multiply(a[i]);
        }
        System.out.println("总期次分子为"+dNumerator);


        //计算分母
        BigDecimal dDenominator = BigDecimal.valueOf(1);
        for (int i=0;i<a.length-1;i++){
            BigDecimal dOne =BigDecimal.valueOf(1);
            for (int j=i+1;j<a.length;j++){
                dOne = dOne.multiply(a[j]);
            }
            dDenominator = dDenominator.add(dOne);
        }

        System.out.println("总期次分母为"+dDenominator);

        //计算每月还款额
        BigDecimal dPerMonthPayAmt = dNumerator.divide(dDenominator,2, BigDecimal.ROUND_HALF_UP);
        System.out.println("每月还款额为+"+ dPerMonthPayAmt);

        forwProvDate="20200701";
        beginDate="20200701";
        endDate="20210701";
        for(int i=0;i<=loanTerm; i++){
            //计算1+iDn
            nextProvDate=calTest.fnCalRepayNextDate(  beginDate, endDate,forwProvDate,  payDate, "1");

            if(nextProvDate.compareTo(endDate) < 0) {
                iDays = calTest.daysBetween(sf.parse(forwProvDate), sf.parse(nextProvDate));
                //每月应还利息
                BigDecimal dInte = dResNor.multiply(rate).multiply(BigDecimal.valueOf(iDays)).setScale(2, BigDecimal.ROUND_HALF_UP);
                //每月应还本金
                BigDecimal dPrin = dPerMonthPayAmt.subtract(dInte);
                //剩余正常本金
                dResNor = dResNor.subtract(dPrin);
                System.out.println("第"+(i+1)+"期次,本期起期:" + forwProvDate + "本期止期:" + nextProvDate + "本期应还本金:" + dPrin + "本期应还利息" + dInte + "剩余正常本金:" + dResNor);
                forwProvDate = nextProvDate;
                dSumPrin = dSumPrin.add(dPrin);
            }else if(nextProvDate.compareTo(endDate) == 0){
                //最后一期的处理
                //每月应还本金
                BigDecimal dPrin = dResNor;
                //每月应还利息
                BigDecimal dInte=dPerMonthPayAmt.subtract(dPrin);
                dSumPrin = dSumPrin.add(dPrin);
                System.out.println("第"+(i+1)+"期次,本期起期:" + forwProvDate + "本期止期:" + nextProvDate + "本期应还本金:" + dPrin + "本期应还利息" + dInte + "剩余正常本金:" + dResNor);

            }
            System.out.println("还款计划中总本金为"+dSumPrin);
            if (nextProvDate.compareTo(endDate) >= 0) {
                break;
            }
        }
    }
}
