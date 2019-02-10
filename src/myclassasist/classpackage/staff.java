
package myclassasist.classpackage;

import java.util.Date;


public abstract class staff {
    private String staff_id;
    private String staff_name;
    private int staff_nic;
    private String staff_gender;
    private String staff_address;
    Date staff_dob;
    private int staff_age;
    double staff_salary;
    private int staff_mobileno;
    private int staff_homeno;
    private String staff_email;
    Date today = new Date();
    private Date staff_regdate= today;
    
    public staff (String id,String name,int nic,String gender,String address,Date dob,double sal,int mno,int hno,String email)
    {
        this.staff_id =id;
        this.staff_name=name;
        this.staff_nic=nic;
        this.staff_gender=gender;
        this.staff_address=address;
        this.staff_dob=dob;
        this.staff_age= (int)(today.getYear() - dob.getYear());
        this.staff_salary=sal;
        this.staff_mobileno=mno;
        this.staff_homeno=hno;
        this.staff_email=email;   
    }  
    
    public String getId()
    { return this.staff_id;}
    
    public String getName()
    { return this.staff_name;}
    
    public int getNic()
    { return this.staff_nic;}
    
    public Date getDob()
    { return this.staff_dob;}
   
    public int getAge()
    { return this.staff_age;}
    
    public String getAddress()
    { return this.staff_address;}
    
    public double getSalary()
    { return this.staff_salary;}
    
    public int getmobileno()
    { return this.staff_mobileno;}
    
    public int getHomeno()
    { return this.staff_homeno;}
    
    public String getEmail()
    { return this.staff_email;}  
    
     public String getGender()
    { return this.staff_gender;}  
     
     public Date getRegdte()
    { return this.staff_regdate;}
     
    public abstract void calc_salary();
    
    
    
}

