package Control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDate
{
    public static String getDay(int dateCount)
    {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, dateCount);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        String  date = dateFormat.format(calendar.getTime());
        return date;
    }
    public static String getTime(String timeFormat)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat);
        String nowTime = dateFormat.format(new Date());
        return nowTime;
    }
}
