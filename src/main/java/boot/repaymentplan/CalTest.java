package boot.repaymentplan;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@Component
public class CalTest {


    public static int daysBetween(Date smdate, Date bdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            return Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e) {
            return -1;
        }

    }

    public String fnCalRepayNextDate(String beginDate,String endDate,String forwProvDate, String payDate,String caspan) throws Exception {

        // 当指定还款日只有一位时补0
        if (payDate.length() == 1) {
            payDate = "0" + payDate;
        }

        String day = forwProvDate.substring(6, 8);
        String lastDay = "";
        String nextProvDate = "";

        //定义变量储存初始指定还款日
        String payDateOld = payDate;
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        // 按月结息
        if ("1".equals(caspan)) {
            // 如果是首期
            if (forwProvDate.equals(beginDate) ) {
                //此处做参数配置处理
                Long distDays = 15L;

                if (Long.parseLong(day) < Long.parseLong(payDate)) {
                    // 主要是针对指定还款日大于月底最后一天，对该月指定还款日进行修正
                    lastDay = BizUtils.getCurrMonthEnd(forwProvDate).substring(6, 8);
                    if (Long.parseLong(lastDay) <= Long.parseLong(payDate)) {
                        payDate = lastDay;
                    }

                    nextProvDate = forwProvDate.substring(0, 6) + payDate;
                    double iDays = 0;
                    // 计算下天数
                    iDays = daysBetween(sf.parse(forwProvDate),sf.parse(nextProvDate));

                    if (iDays <= distDays) {
                        nextProvDate = BizUtils.dateMonth(nextProvDate, 1L);
                        // 主要是针对指定还款日大于月底最后一天，对该月指定还款日进行修正
                        lastDay = BizUtils.getCurrMonthEnd(nextProvDate).substring(6, 8);
                        if (Long.parseLong(lastDay) <= Long.parseLong(payDateOld)) {
                            payDateOld = lastDay;
                        }

                        nextProvDate = nextProvDate.substring(0, 6) + payDateOld;
                    }
                } else {
                    nextProvDate = BizUtils.dateMonth(forwProvDate, 1L);
                    // 主要是针对指定还款日大于月底最后一天，对该月指定还款日进行修正
                    lastDay = BizUtils.getCurrMonthEnd(nextProvDate).substring(6, 8);
                    if (Long.parseLong(lastDay) <= Long.parseLong(payDate)) {
                        payDate = lastDay;
                    }
                    nextProvDate = nextProvDate.substring(0, 6) + payDate;
                    double iDays = 0;
                    iDays = daysBetween(sf.parse(forwProvDate),sf.parse(nextProvDate));

                    if (iDays <= distDays) {
                        nextProvDate = BizUtils.dateMonth(nextProvDate, 1L);
                        // 主要是针对指定还款日大于月底最后一天，对该月指定还款日进行修正
                        lastDay = BizUtils.getCurrMonthEnd(nextProvDate).substring(6, 8);
                        if (Long.parseLong(lastDay) <= Long.parseLong(payDateOld)) {
                            payDateOld = lastDay;
                        }

                        nextProvDate = nextProvDate.substring(0, 6) + payDateOld;
                    }
                }

                if (nextProvDate.compareTo(endDate) > 0) {
                    nextProvDate = endDate;
                }
            }
            // 非首期
            else {
                nextProvDate = BizUtils.dateMonth(forwProvDate, 1L);
                // 主要是针对指定还款日大于月底最后一天，对该月指定还款日进行修正
                lastDay = BizUtils.getCurrMonthEnd(nextProvDate).substring(6, 8);
                if (Long.parseLong(lastDay) <= Long.parseLong(payDate)) {
                    payDate = lastDay;
                }

                nextProvDate = nextProvDate.substring(0, 6) + payDate;

                if (nextProvDate.compareTo(endDate) > 0) {
                    nextProvDate = endDate;
                }
            }
        }

        return nextProvDate;
    }

    public int fnCalLoanTerm(String beginDate,String endDate, String forwProvDate,String payDate,String caspan) throws Exception {
        String nextProvDate = "";
        int numBasePeri = 0;
        for (numBasePeri = 1; numBasePeri < 1000; numBasePeri++) {

            nextProvDate=fnCalRepayNextDate( beginDate, endDate,forwProvDate,  payDate, "1");

                if (nextProvDate.compareTo(endDate) >= 0) {
                break;
            }
            //System.out.println("forwProvDate=" + forwProvDate+"nextProvDate="+nextProvDate);

            forwProvDate = nextProvDate;
        } // 循环完成
        if (!nextProvDate.equals(endDate) ){

        }
        if (numBasePeri <= 0) {

        }
        return numBasePeri;
    }
}
