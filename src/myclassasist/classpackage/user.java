
//not yet used
package myclassasist.classpackage;

public class user {
    private String username;
    private String password;
    private String user_type;


public user (String uname,String pword,String u_type){
    this.username=uname;
    this.password=pword;
    this.user_type=u_type;
            
}

public String getUsername()
{
    return this.username;
}

public String getPassword()
{
    return this.password;
}


public String getUsertype()
{
    return this.user_type;
}


}

