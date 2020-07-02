package boot.repaymentplan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BizUtils {

    private static final ThreadLocal<DateFormat> sdf = new ThreadLocal<DateFormat>(){
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    /**
     * @title 当前营业日期本月的月末日
     * @description 当前营业日期本月的月末日
     *
     * @param str
     * @return
     */
    public static String getCurrMonthEnd(String str) throws Exception {

        Calendar lastDate = new GregorianCalendar();
        try {
            lastDate.setTime(sdf.get().parse(str));
        } catch (ParseException e) {
            throw new Exception("99999");
        }
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
        str = sdf.get().format(lastDate.getTime());
        return str;
    }

    /**
     *
     * @title 日期加/减月份
     * @description 日期加/减月份
     *
     * @param date
     * @param amount
     * @return
     */
    public static String dateMonth(String date, Long amount) throws Exception {


        Calendar calendar = new GregorianCalendar();
        try {
            calendar.setTime(sdf.get().parse(date));
        } catch (ParseException e) {
            throw new Exception("99999");
        }
        calendar.add(Calendar.MONTH, amount.intValue());
        String calDate = sdf.get().format(calendar.getTime());
        return calDate;
    }

}
