
package myclassasist.classpackage;
import java.util.Date;

public class exam {
    private String e_id;
    private String c_id;
    private String e_title;
    private String e_type;
    private Date e_pdate;
    private Date e_prdate;
    private double e_pt1;
    private double e_pt2;
     private double e_prt1;
    private double e_prt2;
    private double e_pduration;
     private double e_prduration;
    private double p_marks;
    private double pr_marks;
    private double t_marks;


public exam(String id,String cid,String title,Date pdate,Date prdate,double pt1,double pt2,double prt1,double prt2,double pmarks,double prmarks)
{
   this.e_id=id;
   this.c_id=cid;
   this.e_title=title;
   this.e_pdate=pdate;
   this.e_prdate =prdate;
   this.e_pt1=pt1;
   this.e_pt2=pt2;
   this.e_prt1=prt1;
   this.e_prt2=prt2;
   this.p_marks=pmarks;
   this.pr_marks=prmarks;
   
  
   if(this.p_marks==0)
   {this.e_type = "Paper";}
   
   if(this.pr_marks==0)
   {this.e_type = "Practical";}
   
}

public double calcDuration(double e_t1,double e_t2)
    {
        long t1_dpart= (long) e_t1;
        double t1_fpart = e_t1-t1_dpart;
        long t2_dpart= (long) e_t2;
        double t2_fpart = e_t2-t2_dpart;   
        
        double duration =Math.abs( t2_dpart-t1_dpart) + Math.abs(((t2_fpart - t1_fpart)/100)*60);
        
        return duration;
    }

public double setTmarks(double pmarks,double prmarks)
{
   this.t_marks=p_marks+pr_marks;

   return this.t_marks;
   
}

public String getId()
    { return this.e_id;}

public String getTitle()
    { return this.e_title;}

public String geCid()
    { return this.c_id;}

public Date getPdate()
    { return this.e_pdate;}

public Date getPrdate()
    { return this.e_prdate;}

public double  getPt1()
    { return this.e_pt1;}

public double  getPt2()
    { return this.e_pt2;}

public double  getPrt1()
    { return this.e_prt1;}

public double  getPrt2()
    { return this.e_prt2;}

public double  getPDuration()
    {   this.e_pduration=this.calcDuration(this.e_pt1,this.e_pt2);
        return this.e_pduration;}

public double  getPrDuration()
    {  this.e_prduration= this.calcDuration(this.e_prt1,this.e_prt2);
        return this.e_prduration;}

public double  getPmarks()
    { return this.p_marks;}

public double  getPrmarks()
    { return this.pr_marks;}

public double  getTmarks()
    { return this.t_marks;}


}