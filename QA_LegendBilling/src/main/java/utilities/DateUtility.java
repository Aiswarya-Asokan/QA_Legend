package utilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
public static String get_UserLogin_Date(String format)
{
	DateFormat dateformat=new SimpleDateFormat(format);//DateFormat is an abstract class and SimpleDateFormat is the subclass of DateFormat
		Date currentdate=new Date();
		return dateformat.format(currentdate);
		
	}
			
}

