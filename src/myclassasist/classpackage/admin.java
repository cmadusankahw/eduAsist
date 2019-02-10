
package myclassasist.classpackage;

import java.util.Date;


public  class admin extends staff{
    private double salary;
    
    public admin (String id,String name,int nic,String gender,String address,Date dob,double sal,int mno,int hno,String email,double nsal)
    {
        super(id,name,nic,gender,address,dob,sal,mno,hno,email);
        this.salary=sal;
    }  
    
   
   
    public void setSalary(double newsal)
    {
        this.salary=newsal;
    }
    
   
     public double getSalary()
    { return this.salary;}
     
    public void calc_salary()
    {
        
    }
    
    
    
}

