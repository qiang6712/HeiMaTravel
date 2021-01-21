package travel.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期转换工具类
 * User: lan-jian
 * Date: 2019/9/6
 * To change this template use File | Settings | File Templates.
 */
public class DateUtil {

    /**
     * 将字符串转换为日期
     *
     * @param value
     * @return
     */
    public static Date dateTrans(Object value) {
        String valueStr = ( String ) value;
        if (null == valueStr || valueStr.length () == 0) {
            return null;
        }
        SimpleDateFormat sdf = null;
        if (valueStr.length () > 10) {
            if (valueStr.length () == 14) {
                sdf = new SimpleDateFormat ("yyyyMMddHHmmss");
            } else {
                sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
            }
        } else {
            if (valueStr.length () == 8) {
                sdf = new SimpleDateFormat ("yyyyMMdd");
            } else {
                sdf = new SimpleDateFormat ("yyyy-MM-dd");
            }
        }
        try {
            return sdf.parse (valueStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将字符串转换为日期,为空则设置为当前时间
     *
     * @param value
     * @return
     */
    public static Date dateTransWithDefault(Object value) {
        Date ret = dateTrans (value);
        if (null == ret) {
            ret = new Date ();
        }
        return ret;
    }

    /**
     * 将日期转换为结束时间,即：YYYY-MM-DD 23:59:59
     *
     * @param value
     * @return 一天的结束时间
     */
    public static Date transDateEnd(Date value) {
        Calendar c = Calendar.getInstance ();
        c.setTime (value);
        c.set (Calendar.HOUR_OF_DAY, 23);
        c.set (Calendar.MINUTE, 59);
        c.set (Calendar.SECOND, 59);
        return c.getTime ();
    }

    /**
     * 将日期转换为结束时间,即：YYYY-MM-DD 00:00:00
     *
     * @param value
     * @return 一天的开始时间
     */
    public static Date transDateStart(Date value) {
        Calendar c = Calendar.getInstance ();
        c.setTime (value);
        c.set (Calendar.HOUR_OF_DAY, 0);
        c.set (Calendar.MINUTE, 0);
        c.set (Calendar.SECOND, 0);
        return c.getTime ();
    }

    /**
     * 日期增加天数
     *
     * @param value
     * @param days
     * @return
     */
    public static Date addDateDay(Date value, int days) {
        Calendar c = Calendar.getInstance ();
        c.setTime (value);
        c.add (Calendar.DAY_OF_YEAR, days);
        return c.getTime ();
    }

    /**
     * 日期增加月份
     *
     * @param value
     * @param months
     * @return
     */
    public static Date addDateMonth(Date value, int months) {
        Calendar c = Calendar.getInstance ();
        c.setTime (value);
        c.add (Calendar.MONTH, months);
        return c.getTime ();
    }

    /**
     * 日期增加年份
     *
     * @param value
     * @param years
     * @return
     */
    public static Date addDateYear(Date value, int years) {
        Calendar c = Calendar.getInstance ();
        c.setTime (value);
        c.add (Calendar.YEAR, years);
        return c.getTime ();
    }

    /**
     * 日期增加分钟
     *
     * @param value
     * @param minute
     * @return
     */
    public static Date addDateMinute(Date value, int minute) {
        Calendar c = Calendar.getInstance ();
        c.setTime (value);
        c.add (Calendar.MINUTE, minute);
        return c.getTime ();
    }

    /**
     * 计算两个时间相差多少个小时
     *
     * @param endDate
     * @param nowDate
     * @return
     */
    public static long getDatePoor(Date endDate, Date nowDate) {
        if (endDate == null || nowDate == null) {
            return 0;
        }
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime () - nowDate.getTime ();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        return day * 24 + hour;
    }
}
