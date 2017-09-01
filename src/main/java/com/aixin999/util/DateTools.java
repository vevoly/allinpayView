package com.aixin999.util;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools {
    //时间字符串 年月日时分秒
    public static SimpleDateFormat yyyyMMDDHHmmssFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //时间字符串 年月日时分
    public static SimpleDateFormat yyyyMMDDHHmmFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //时间字符串 年月日
    public static SimpleDateFormat yyyyMMDDFmt = new SimpleDateFormat("yyyy-MM-dd");

    //时间字符串 时分秒
    public static SimpleDateFormat HHmmssFmt = new SimpleDateFormat("HH:mm:ss");

    //时间字符串 时分
    public static SimpleDateFormat HHmmFmt = new SimpleDateFormat("HH:mm");


    //星期
    private static String[] weekDay = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};


    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd"; // 默认的日期格式
    public static final DateFormat[] ACCEPT_DATE_FORMATS = { // 定义可被转换成日期对象的字符串格式
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
            new SimpleDateFormat("yyyyMMddHHmmss"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy-MM-dd HHmmss"),
            new SimpleDateFormat("yyyyMMdd"), new SimpleDateFormat("yyyyMM"),
            new SimpleDateFormat(DEFAULT_DATE_FORMAT),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yyyy/MM/dd HHmmss"),
            new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"),
            new SimpleDateFormat("yyyy-MM"), new SimpleDateFormat("yyyy")
    };


    /**
     * 函数介绍：根据默认模式包日期对象转换成日期字符串 参数：date ,日期对象；parttern,日期字符格式 返回值：日期字符串
     */
    public static String format(Date date, String parttern) {
        DateFormat df = new SimpleDateFormat(parttern);
        return df.format(date);
    }

    /**
     * 函数介绍：根据默认模式包日期对象转换成日期字符串 参数：date ,日期对象 返回值：日期字符串
     */
    public static String format(Date date) {
        return format(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * @param strDate 需要转换的字符串
     * @param format  需要格式的目标字符串  举例 yyyy-MM-dd
     * @return
     * @throws ParseException
     * @Enclosing_Method : stringToDate
     * @Written by : czq
     * @Creation Date : Oct 27, 2010 2:45:07 PM
     * @version : v1.00
     * @Description : 将字符串转换成日期时间
     */
    public static Date stringToDate(String strDate, String format)
            throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(strDate);
    }

    /**
     * @param strDate 时间字符串
     * @param format  格式化器
     * @return
     * @throws ParseException
     * @Enclosing_Method : stringToDate
     * @Written by : czq
     * @Creation Date : Oct 27, 2010 2:46:55 PM
     * @version : v1.00
     * @Description : 将字符串转换成日期时间
     */
    public static Date stringToDate(String strDate, DateFormat format)
            throws ParseException {
        return format.parse(strDate);
    }

    /**
     * 函数介绍：根据日期字符串转换成日期对象 参数：strDate,日期字符串 返回值：date 对象
     */
    public static Date stringToDate(String strDate) {
        for (DateFormat df : ACCEPT_DATE_FORMATS) {
            try {
                return df.parse(strDate);
            } catch (Exception e) {
                continue;
            }
        }

        return null;
    }

    /**
     * 函数介绍：把页面上得到的日期字符转换成数据库需要数字 参数：datestr,日期字符串 返回值：数字字符
     */
    public static String StringToNum14(String datestr) {
        if (datestr == null || StringUtils.isBlank(datestr.trim())) {
            return null;
        }
        return format(stringToDate(datestr), "yyyyMMddHHmmss");
    }

    /**
     * @param datestr 原时间串
     * @param format  原时间串格式
     * @return
     * @throws ParseException
     * @Enclosing_Method : stringToNum14
     * @Written by : czq
     * @Creation Date : Oct 27, 2010 2:51:13 PM
     * @version : v1.00
     * @Description : 将时间串转换成yyyyMMddHHmmss形式
     */
    public static String stringToNum14(String datestr, String format)
            throws ParseException {
        if (datestr == null || StringUtils.isBlank(datestr.trim())) {
            return null;
        }
        return format(stringToDate(datestr, format), "yyyyMMddHHmmss");
    }

    public static String StringToNum8(String datestr) {
        if (datestr == null || StringUtils.isBlank(datestr.trim())) {
            return null;
        }
        return format(stringToDate(datestr), "yyyyMMdd");
    }

    /**
     * @param datestr 原时间串
     * @param format  原时间串格式
     * @return
     * @throws ParseException
     * @Enclosing_Method : stringToNum8
     * @Written by : czq
     * @Creation Date : Oct 27, 2010 2:51:52 PM
     * @version : v1.00
     * @Description : 将时间串转换成yyyyMMdd 形式
     */
    public static String stringToNum8(String datestr, String format)
            throws ParseException {
        if (datestr == null || StringUtils.isBlank(datestr.trim())) {
            return null;
        }
        return format(stringToDate(datestr, format), "yyyyMMdd");
    }

    public static String StringToNum08(String datestr) {
        if (datestr == null || StringUtils.isBlank(datestr.trim())) {
            return null;
        }
        return format(stringToDate(datestr), "yyyyMMdd");
    }

    /**
     * @param datestr 原时间串
     * @param format  原时间串格式
     * @return
     * @throws ParseException
     * @Enclosing_Method : StringToNum08
     * @Written by : czq
     * @Creation Date : Oct 27, 2010 2:52:20 PM
     * @version : v1.00
     * @Description : 将时间串转换成yyyyMMdd形式
     */
    public static String StringToNum08(String datestr, String format)
            throws ParseException {
        if (datestr == null || StringUtils.isBlank(datestr.trim())) {
            return null;
        }
        return format(stringToDate(datestr, format), "yyyyMMdd");
    }

    public static String StringToNum06(String datestr) {
        if (datestr == null || StringUtils.isBlank(datestr.trim())) {
            return null;
        }
        return format(stringToDate(datestr), "yyyyMM");
    }

    /**
     * @param datestr 原时间串
     * @param format  原时间串格式
     * @return
     * @throws ParseException
     * @Enclosing_Method : stringToNum06
     * @Written by : czq
     * @Creation Date : Oct 27, 2010 2:52:47 PM
     * @version : v1.00
     * @Description : 将时间串转换成yyyyMM形式
     */
    public static String stringToNum06(String datestr, String format)
            throws ParseException {
        if (datestr == null || StringUtils.isBlank(datestr.trim())) {
            return null;
        }
        return format(stringToDate(datestr, format), "yyyyMM");
    }

    /**
     * 函数介绍：把日期对象转换成数据库需要数字 参数：日期对象 返回值：数字字符
     */
    public static String dateToNum14(Date date) {
        return format(date, "yyyyMMddHHmmss");
    }

    public static String StringHmsToNum6(String str) {
        return str.replaceAll(":", "");
    }

    /**
     * 得到应用服务器的系统时间.
     *
     * @return yyyymmddhhmiss格式的当前时间
     * @author fanhuifeng
     */
    public static String getDateFormatss() {
        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.YEAR)
                + addZero("" + (calendar.get(Calendar.MONTH) + 1))
                + addZero("" + calendar.get(Calendar.DAY_OF_MONTH))
                + addZero("" + calendar.get(Calendar.HOUR_OF_DAY))
                + addZero("" + calendar.get(Calendar.MINUTE))
                + addZero("" + calendar.get(Calendar.SECOND));
        return date;
    }

    /**
     * 给不够2位的字符串前面加0.
     *
     * @return 字符串，不够两位左补0
     * @author fanhuifeng
     */
    private static String addZero(String s) {
        if (s.length() < 2) {
            return "0" + s;
        }
        return s;
    }

    /**
     * @param sec
     * @return : String
     * @Enclosing_Method : getDateFormatByDifferSeconds
     * @Written by        : wangchuan
     * @Creation Date     : Aug 15, 2011 3:41:04 PM
     * @version : v1.00
     * @Description : 根据秒差计算时间
     */
    public static String getDateFormatByDifferSeconds(int sec) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, sec);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowtime = sdf.format(cal.getTime());
        return nowtime;
    }

    /**
     * @param cal
     * @param sec
     * @return : String
     * @Enclosing_Method : getDateFormatByDifferSeconds
     * @Written by        : wangchuan
     * @Creation Date     : Aug 15, 2011 3:42:12 PM
     * @version : v1.00
     * @Description :  根据秒差计算时间
     */
    public static String getDateFormatByDifferSeconds(Calendar cal, int sec) {
        cal.add(Calendar.SECOND, sec);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowtime = sdf.format(cal.getTime());
        return nowtime;
    }

    /**
     * ************************************************************************
     * 查询昨天的时间
     *
     * @param day
     * @return
     */
    public static String getDateFormatYesterday(int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowtime = sdf.format(cal.getTime());
        return nowtime;
    }

    /**
     * ************************************************************************
     * 查询昨天的时间
     *
     * @param day
     * @return
     */
    public static String getDateFormatYesterday(int day, String format) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -day);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(cal.getTime());
        return nowtime;
    }

    /**
     * 获取延迟day天后的格式化字符串
     *
     * @param day 后延天数
     * @return yyyyMMddHHmmss 形式的时间字符串
     */
    public static String getDateFormatAfter(int day) {
        return getDateFormatAfter(day, "yyyyMMddHHmmss");
    }

    /**
     * 获取延迟day天后的格式化字符串
     *
     * @param day    后延天数
     * @param format 格式化字符串
     * @return
     */
    public static String getDateFormatAfter(int day, String format) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, +day);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(cal.getTime());
        return nowtime;
    }

    /**
     * 查询前一天的时间
     *
     * @param day
     * @param num
     * @return
     */
    public static String getFormatPreDay(Calendar day, int num) {
        day.add(Calendar.DAY_OF_YEAR, -num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowtime = sdf.format(day.getTime());
        return nowtime;
    }

    /**
     * 查询前一周的时间
     *
     * @param day
     * @param num
     * @return
     */
    public static String getFormatPreWeek(Calendar day, int num) {
        day.add(Calendar.WEEK_OF_YEAR, -num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowtime = sdf.format(day.getTime());
        return nowtime;
    }

    /**
     * 查询前一个月的时间
     *
     * @param day
     * @param num
     * @return
     */
    public static String getFormatPreMonth(Calendar day, int num) {
        day.add(Calendar.MONTH, -num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowtime = sdf.format(day.getTime());
        return nowtime;
    }

    /**
     * 查询前一个月的时间
     *
     * @param day
     * @param num
     * @return
     */
    public static String getFormatPreMonth(Calendar day, int num, String format) {
        day.add(Calendar.MONTH, -num);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String nowtime = sdf.format(day.getTime());
        return nowtime;
    }

    /**
     * 查询前一年的时间
     *
     * @param day
     * @param num
     * @return
     */
    public static String getFormatPreYear(Calendar day, int num) {
        day.add(Calendar.YEAR, -num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowtime = sdf.format(day.getTime());
        return nowtime;
    }

    /**
     * 组合Oracle 日期类型
     *
     * @param date
     * @return
     */
    public static String getOracleDate(Date date) {
        String updateTime = DateTools.format(date, "yyyy-MM-dd");
        return "to_date('" + updateTime + "','YYYY-MM-DD')";
    }

    /**
     * 组合Oracle 日期类型
     *
     * @param date
     * @return
     */
    public static String getOracleDateTime(Date date) {
        String updateTime = DateTools.format(date, "yyyy-MM-dd HH:mm:ss");
        return "to_date('" + updateTime + "','YYYY-MM-DD HH24:MI:SS')";
    }

    /**
     * @param data
     * @return 计算两个日期的天数差异
     */
    public static long getDifferDate(String data) {
        Date newdate = new Date();
        Date date1 = DateTools.stringToDate(data);
        long t1 = newdate.getTime();
        long t2 = date1.getTime();
        long t3 = (t1 - t2) / (60 * 1000);
        return t3;
    }

    /**
     * 获取时间戳
     *
     * @param date 日期
     * @return
     */
    public static long getTimestmp(Date date) {
        return date.getTime();
    }

    /**
     * 日期串格式化成日期
     *
     * @param dateStr 日期字符串
     * @return
     */
    public static Date timestmpToDate(long dateStr) {
        return new Date(dateStr);
    }


    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
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
    }

    /**
     * 字符串的日期格式的计算两个日期相差天数
     */
    public static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 时间计算
     *
     * @param dateToNum14
     * @param date_num    相差时间间隔
     * @param date_type   和那位进行计算 [0 年 year] [1 月 month] [2 日 date] [3 时 hour] [4 分 minute] [5 秒 second]
     * @return
     */
    public static Date getSomeOneDay(String dateToNum14, int date_num, int date_type) {
        Calendar c = Calendar.getInstance();

        Date config_time = DateTools.stringToDate(dateToNum14);
        c.setTime(config_time);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        switch (date_type) {
            case 0: {
                c.set(year + date_num, month, date, hour, minute, second);
            }
            break;
            case 1: {
                c.set(year, month + date_num, date, hour, minute, second);
            }
            break;
            case 2: {
                c.set(year, month, date + date_num, hour, minute, second);
            }
            break;
            case 3: {
                c.set(year, month, date, hour + date_num, minute, second);
            }
            break;
            case 4: {
                c.set(year, month, date, hour, minute + date_num, second);
            }
            break;
            case 5: {
                c.set(year, month, date, hour, minute, second + date_num);
            }
            break;
            default: {
                c.set(year, month, date, hour, minute, second);
            }
            break;
        }
        return c.getTime();
    }

    /**
     * @param dateToNum14
     * @param timeStr     例如 1s/S 1秒，30m 分钟 ，12h/H 小时，2w/W 两周, 15d/D 15天 ，1M 一个月，1y/Y 一年
     * @return
     */
    public static Date getSomeOneDay(String dateToNum14, String timeStr) {
        int time = 0;
        int type = -1;
        if (timeStr.toLowerCase().contains("s")) {
            time = Integer.parseInt(timeStr.replace("s", ""));
            type = 5;
        } else if (timeStr.contains("m")) {
            time = Integer.parseInt(timeStr.replace("m", ""));
            type = 4;
        } else if (timeStr.toLowerCase().contains("h")) {
            time = Integer.parseInt(timeStr.replace("h", ""));
            type = 3;
        } else if (timeStr.toLowerCase().contains("d")) {
            time = Integer.parseInt(timeStr.replace("d", ""));
            type = 2;
        } else if (timeStr.toLowerCase().contains("w")) {
            time = Integer.parseInt(timeStr.replace("m", ""));
            type = 2;
        } else if (timeStr.toLowerCase().contains("M")) {
            time = Integer.parseInt(timeStr.replace("M", ""));
            type = 1;
        } else if (timeStr.toLowerCase().contains("y")) {
            time = Integer.parseInt(timeStr.replace("y", ""));
            type = 0;
        } else {
            return null;
        }
        return getSomeOneDay(dateToNum14, time, type);
    }

    /**
     * @param timeStr 例如 1s/S 1秒，30m 分钟 ，12h/H 小时，2w/W 两周, 15d/D 15天 ，1M 一个月，1y/Y 一年
     * @return
     */
    public static long getMilliseconds(String timeStr) {
        //计算预期时间
        Date someday = getSomeOneDay(DateTools.dateToNum14(new Date()), timeStr);
        //计算预期时间和当前时间的毫秒数差
        return DateTools.secondsBetween(DateTools.dateToNum14(someday), DateTools.dateToNum14(new Date())) * 1000;
    }

    /**
     * 获取传入年月的天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getSomeOneMonthDays(int year, int month) {
        int days = 0;
        Calendar c = Calendar.getInstance();
        c.set(year, month, 0);
        days = c.get(Calendar.DATE);
        return days;
    }

    /**
     * 获得月最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month + 1);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return cal.getTime();
    }

    /**
     * 获得月第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
    /**
     *
     */

    /**
     * 获得月份差
     *
     * @param day1
     * @param day2
     * @return
     */
    public static int monthBetween(String day1, String day2) {
        int differ = 0;
        try {
            Calendar c = Calendar.getInstance();
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            //年1
            Date d1 = df.parse(day1);
            c.setTime(d1);
            int y1 = c.get(Calendar.YEAR);
            int m1 = c.get(Calendar.MONTH);
            //年2
            Date d2 = df.parse(day2);
            c.setTime(d2);
            int y2 = c.get(Calendar.YEAR);
            int m2 = c.get(Calendar.MONTH);
            //结果
            differ = 12 * (y1 - y2) + (m1 - m2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return differ;//两个日期相差几个月，即月份差;
    }

    /**
     * 计算今天和传入的月份差
     */
    public static int getDifferMonth(String day) {
        String currentDay = DateTools.StringToNum8(DateTools.dateToNum14(new Date()));
        return DateTools.monthBetween(currentDay, day);
    }

    /**
     * 获得秒数差
     *
     * @param d1 格式：yyyyMMddHHmmss
     * @param d2 格式：yyyyMMddHHmmss
     * @return
     */
    public static long secondsBetween(String d1, String d2) {
        long differ = 0;
        try {
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            //年1
            Date dd1 = df.parse(d1);
            //年2
            Date dd2 = df.parse(d2);
            //结果
            differ = dd1.getTime() - dd2.getTime();
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return differ / 1000;//两个日期相差几秒，即秒差;
    }

    /**
     * 计算今天距离周日的时间差毫秒数
     *
     * @return
     */
    public static long getSundayDifference() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        Calendar cal = Calendar.getInstance();
        Date nowDate = new Date();
        cal.setTime(nowDate);
        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            return 0l;
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, 6);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() - nowDate.getTime();
    }

    /**
     * 根据一天计算一周的周一
     *
     * @param today
     * @return
     */
    public static String getMondayByToday(String today) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //设置时间格式
            Calendar cal = Calendar.getInstance();
            Date time = sdf.parse(today);
            cal.setTime(time);
            System.out.println("要计算日期为:" + sdf.format(cal.getTime())); //输出要计算日期

            //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            if (1 == dayWeek) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
            int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
            String monday = sdf.format(cal.getTime());
            System.out.println("所在周星期一的日期：" + monday);
            cal.add(Calendar.DATE, 6);
            String sunday = sdf.format(cal.getTime());
            System.out.println("所在周星期日的日期：" + sunday);
            return monday;

        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 根据一天计算一周的周日
     *
     * @param today
     * @return
     */
    public static String getSundayByToday(String today) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); //设置时间格式
            Calendar cal = Calendar.getInstance();
            Date time = sdf.parse(today);
            cal.setTime(time);
            System.out.println("要计算日期为:" + sdf.format(cal.getTime())); //输出要计算日期

            //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            if (1 == dayWeek) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
            int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
            String monday = sdf.format(cal.getTime());
            System.out.println("所在周星期一的日期：" + monday);
            cal.add(Calendar.DATE, 6);
            String sunday = sdf.format(cal.getTime());
            System.out.println("所在周星期日的日期：" + sunday);
            return sunday;

        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 根据一天计算一个月的第一天
     *
     * @param today
     * @return
     */
    public static String getFirstDayOfMonth(String today) {
        try {
            int year = Integer.parseInt(today.substring(0, 4));
            int month = Integer.parseInt(today.substring(4, 6));
            String fisrtday = DateTools.dateToNum14(DateTools.getFirstDayOfMonth(year, month - 1));
            return fisrtday;

        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 根据一天计算一个月的最后一天
     *
     * @param today
     * @return
     */
    public static String getLastDayOfMonth(String today) {
        try {
            int year = Integer.parseInt(today.substring(0, 4));
            int month = Integer.parseInt(today.substring(4, 6));
            String lastday = DateTools.dateToNum14(DateTools.getLastDayOfMonth(year, month - 1));
            return lastday;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 比较两个日期大小，即前一个日期是否早于后一个日期
     * 如果早于那么返回1，晚于返回-1,相等返回0,否则返回null
     *
     * @param date1
     * @param date2
     * @return Integer
     * @version 1.0.0
     * @2017-3-22 15:04:17
     */
    public static Integer isBefore(Date date1, Date date2) {
        Integer result = 0;
        try {
            if (date1.compareTo(date2) < 0) {//早
                result = 1;
            } else if (date1.compareTo(date2) > 0) {
                result = -1;
            }
        } catch (Exception e) {
            result = null;
        }
        return result;
    }


    /**
     * 获取当前年
     *
     * @version 1.0.0
     * @2017-3-22 16:13:15
     */
    public static Integer getCurYear() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        Integer curYear = c.get(Calendar.YEAR);
        return curYear;
    }

    /**
     * 获取当前月
     *
     * @version 1.0.0
     * @2017-3-22 16:13:20
     */
    public static Integer getCurMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.MONTH);
    }

    /**
     * 获取当前日期
     *
     * @version 1.0.0
     * @2017-3-22 16:13:24
     */
    public static Integer getCurDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.DATE);
    }

    /**
     * 获取当前周几
     *
     * @version 1.0.0
     * @2017-3-22 16:13:29
     */
    public static String getCurDay() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return weekDay[c.get(Calendar.DAY_OF_WEEK) - 1];
    }


    /**
     * 由出生日期获得年龄,精确到具体日期
     *
     * @param birthDay
     * @return
     * @throws Exception
     */
    public static int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();
        int age = 0;
        if (cal.before(birthDay)) {
            return age;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            } else {
                age--;
            }
        }
        return age;
    }


    /**
     * 根据年龄获取出生日期
     *
     * @param age 年龄
     * @return
     */
    public static Date getBirthday(Integer age) {
        Calendar curCalendar = Calendar.getInstance();           //获取现在时间
        int curYear = curCalendar.get(Calendar.YEAR);//获取年份
        int curMonth = curCalendar.get(Calendar.MONTH);//获取月份
        int day = curCalendar.get(Calendar.DAY_OF_MONTH);//日期
        int birthdayYear = curYear - age;
        Date birthday = null;
        try {
            String birthdayDate = String.valueOf(birthdayYear) + "-" + String.valueOf(curMonth) + "-" + String.valueOf(day);
            birthday = stringToDate(String.valueOf(birthdayDate), DEFAULT_DATE_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return birthday;
    }

    public static void main(String[] args) {

    }
}
