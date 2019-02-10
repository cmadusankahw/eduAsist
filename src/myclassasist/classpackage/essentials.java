
package myclassasist.classpackage;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public  class essentials {
    

    public static void infomsgbox(String stitle,String smsg)
    {
        JOptionPane.showMessageDialog(null,smsg,stitle,JOptionPane.INFORMATION_MESSAGE);
    }  
    
    public static  int qmsgbox(String stitle,String smsg)
    {
        int res= JOptionPane.showConfirmDialog(null,smsg,stitle,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return res;
    }
    
    
public static String dayOfweek(int index){
    String s;
    switch(index)
               {
                     case 1  :  s= "Sunday";
                     break;
                     case 2  :  s= ("Monday");
                     break;
                     case 3  :  s=("Tuesday");
                     break;
                     case 4  :  s=("Wednesday");
                     break;
                     case 5  :  s=("Thursday");
                     break;
                     case 6  :  s=("Friday");
                     break;
                     default :  s=("Saturday");
                     break;
                    
       }
    return s;
}

public static int getDateIndex()       
{
    GregorianCalendar cal=new GregorianCalendar();
    return cal.get(Calendar.DATE);
}

public static int getMonthIndex()       
{
    GregorianCalendar cal=new GregorianCalendar();
    return cal.get(Calendar.MONTH);
}

public static int getYearIndex()       
{
    GregorianCalendar cal=new GregorianCalendar();
    return cal.get(Calendar.YEAR);
}

public static String thisDate()
{
    SimpleDateFormat dd=new SimpleDateFormat("yyyy.MM.dd");
    Date d1=new Date();
    return dd.format(d1);
}

public static  Date getDate()
{
    Date d1=new Date();
    return d1;
}

public static GregorianCalendar getCal()
{
    GregorianCalendar cal=new GregorianCalendar();
    return cal;
}


}

//Get date from sql table
//Date d1=new Date(rs.getDate(5).getTime());