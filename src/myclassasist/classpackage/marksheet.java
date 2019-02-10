
package myclassasist.classpackage;

import java.util.Date;


public class marksheet extends exam {
    public String e_id;
    public String c_id;
    public String m_id;
    public double p_marks;
    public double pr_marks;
    public double t_marks;
    private double avarage;
    private  int rank;
    
    public marksheet(String id,String cid,String title,Date pdate,Date prdate,double pt1,double pt2,double,String eid,String rid,String mid) //e-type is a variable from 
    {
        super
        this.e_id=eid;
        this.c_id=cid;
        this.m_id=mid;
    }  
    
    public char getGrade(double pmarks,double prmarks) //nos for number of students, tmarks 
    {
       double tot=getTmarks(pmarks,prmarks);
       if(tot>=75)
           return 'A';
       else if(tot>=65)
            return 'B';
       else if(tot>=45)
            return 'C';
       else if(tot>=35)
            return 'S';
       else
           return 'F';
    }
    
    public void getRank(double avg,double nos)
    {
        //override in jform mmain method
    }
    
    public double getTmarks(double pmarks,double prmarks)// import tmarks from exam table
    {
         this.t_marks=pmarks+prmarks;
    
         return this.t_marks;
         
    }
    
    public String getMid(String mid)
    {
        return this.m_id;
    }
}
