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
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
        String  dateNow = df.format(calendar.getTime());
        return dateNow;
    }
}
