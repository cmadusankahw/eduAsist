
package myclassasist.classpackage;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class databaseCon  {
    final String DRIVER = "com.mysql.jdbc.Driver";
    final String DB_PATH = "jdbc:mysql://localhost:3306/eduassist";
    String username = null;
    String password = null;
    Connection con= null;
    Statement stmt = null;
    PreparedStatement cmd=null;
    
     public databaseCon(String uname, String pword)
     {
         username =uname;
         password = pword;      
     }
     
     public void connect() throws SQLException, Exception
     {
         Class.forName(DRIVER);
         System.out.println("Connecting ");
         con =DriverManager.getConnection(DB_PATH,username,password);
         stmt = con.createStatement();
     }
     
     public void pStatement(String s)
     {
        try {
            this.cmd=con.prepareStatement(s);
        } catch (SQLException ex) {
            Logger.getLogger(databaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     }
     public void disconnect() throws SQLException, Exception
     {
          stmt.close();
          con.close();
     }
     
     public PreparedStatement getPs()
     {
         return cmd;
     }
     public Statement getStatement()
     {
         return stmt;
     }
     
      public Connection getConnection()
      {
          return con;
      }  
      
      public String getSelectq(String fnames,String tnames,String q)
      {
          String rst = "SELECT "+ fnames + " FROM "+ tnames + " WHERE " + q;
          return rst;
      }
}
