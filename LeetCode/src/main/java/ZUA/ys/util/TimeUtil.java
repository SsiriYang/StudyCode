package ZUA.ys.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author 41765
 * @Creater 2020/7/17 9:22
 * Description
 */
public class TimeUtil {

    public static void main(String[] args) {
//        AddSubLocalDateTime();
//        stringtoLocalDate();
//        replastr();
//
//        parseToEvery();
        getTheTimeInMinutes();
        System.out.println( getTheTimeInMinutes());
    }

    /**
     * 随机生成10位数字
     * @return String
     */
    private static String getCode(){
        int newNum = (int)((Math.random()*9+1)*1000000000);
        return String.valueOf(newNum);
    }




    /**
     * @Author 41765
     * @Description //TODO  将String转为LocalDate
     * @Date 10:48 2020/7/20
     * @Param
     * @return
     **/
    public static void stringtoLocalDate(){
            String date1 = "2019-06-13";
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date2 = LocalDate.parse(date1, fmt);
            System.out.println(date1);
            System.out.println(date2);
    }

    public static void stringTOLocalDateTime(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fmtdate = LocalDateTime.parse("2020-07-21 13:00", fmt);
        System.out.println(fmtdate);
    }

    /**
     * @Author 41765
     * @Description //TODO 字符串替换之replace和RepalceAll
     * @Date 10:49 2020/7/20
     * @Param
     * @return
     **/
    public static  void  replastr(){
        String date1 = "2019-06-13";
        String ss = date1.replace("-","");
        System.out.println(ss);

    }

    /**
     * @Author 41765 
     * @Description //TODO 计算时间的差值（分钟 毫秒 纳秒 小时 天数）
     * @Date 10:52 2020/7/20
     * @Param 
     * @return 
     **/
    public static void AddSubLocalDateTime() {
        LocalDateTime nowDateTime =  LocalDateTime.now();
        java.time.Duration duration = java.time.Duration.between(LocalDateTime.now(),LocalDateTime.now().plusHours(1));
        Long minutes  = duration.toMinutes();
        String a  =  minutes.toString();
        System.out.println(a);
        duration.toNanos();//纳秒

        duration.toMillis();//毫秒

        duration.toMinutes();//分钟

        duration.toHours();//小时

        duration.toDays();//天数
    }

    /**
     * @Author 41765
     * @Description //TODO 格式互转
     * @Date 14:44 2020/7/22
     * @Param
     * @return
     **/
    public static void parseToEvery(){
        Integer a = 1;
        Long b = 2L;
        Integer c = b.intValue();
        System.out.println(c);
    }

    /**
     *
     * 获取当前时间（精确到分）的字符串
     * @return 返回时间字符串yyyyMMddHHmm
     */
    public static String getTheTimeInMinutes() {
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date();
        return time.format(date);
    }


}
