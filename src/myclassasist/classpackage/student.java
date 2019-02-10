
package myclassasist.classpackage;


import java.util.Date;

public class student {
    private String s_id;
    private String s_name;
    private int s_nic;
    private String s_address;
    private String s_gender;
    Date s_dob;
    private int s_age;
    private String s_school;
    private int s_mobileno;
    private int s_homeno;
    private String s_email;
   Date today = new Date();
   private Date s_regdate= today;
    
    public student (String sid,String sname,int nic,String gender,String address,Date dob,String school,int mno,int hno,String email)
    {
        this.s_id =sid;
        this.s_name=sname;
        this.s_nic=nic;
        this.s_gender=gender;
        this.s_address=address;
        this.s_dob=dob;
        this.s_age= (int)(today.getYear() - dob.getYear());
        this.s_school = school;
        this.s_mobileno=mno;
        this.s_homeno=hno;
        this.s_email=email;   
    }  
    
    public String getId()
    { return this.s_id;}
    
    public String getName()
    { return this.s_name;}
    
    public int getNic()
    { return this.s_nic;}
   
    public Date getDob()
    { return this.s_dob;}
   
    public int getAge()
    { return this.s_age;}
    
    public String getAddress()
    { return this.s_address;}
    
    public int getMobileno()
    { return this.s_mobileno;}
    
    public int getHomeno()
    { return this.s_homeno;}
    
    public String getEmail()
    { return this.s_email;}  
    
     public String getSchool()
    { return this.s_school;}  
     
      public String getgender()
    { return this.s_gender;}  
      
        public Date getRegdte()
    { return this.s_regdate;}
}
