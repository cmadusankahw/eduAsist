/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassasist;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import myclassasist.classpackage.databaseCon;
import java.sql.*;
import myclassasist.classpackage.essentials;

/**
 *
 * @author Mr C
 */
public class login_form extends javax.swing.JFrame {
  
public void login()
{
      databaseCon db1=new databaseCon("root","");
        try {
             db1.connect();
            ResultSet rs = db1.getStatement().executeQuery("SELECT * FROM user_info;");
            
            int count =0;
            
            while(rs.next())
            {
                String uname = rs.getString(1);
                String pword = rs.getString(2);
                String utype = rs.getString(3);
                if(uname.equals(txtusername.getText()))
                {
                   if(pword.equals(txtpassword.getText()))
                    {
                        main m1=new main(uname,utype);
                        m1.setVisible(true);
                        this.setVisible(false); 
                        if(utype =="marker")
                        {
                            m1.disbutton();
                        }
                        count=1;
                        break;
                    }
                   
                }
     
            }   
             db1.disconnect();
             if(count==0)
             {
                  essentials.infomsgbox("Error","Incorrect Username or Password");  
                        txtusername.setText("");
                        txtpassword.setText("");
                        txtusername.requestFocus(true);
             }    
        }
        
       catch(Exception e){
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.OK_OPTION);
            txtusername.requestFocus();
            txtusername.setText("");
            txtpassword.setText("");
       
        }
    
}

    /**
     * Creates new form login_form
     */
    public login_form() {
        initComponents();
        
        txtusername.requestFocus(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtpassword = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        forgot_pw_btn = new javax.swing.JLabel();
        logo_login = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login");
        setBackground(new java.awt.Color(0, 0, 102));
        setName("login"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(480, 340));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtusername.setForeground(new java.awt.Color(255, 255, 255));
        txtusername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtusername.setCaretColor(new java.awt.Color(51, 0, 51));
        txtusername.setOpaque(false);
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 340, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 340, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 340, -1));

        txtpassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setBorder(null);
        txtpassword.setOpaque(false);
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 340, 40));

        btnlogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(51, 0, 102));
        btnlogin.setText("LOGIN");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 147, 39));

        forgot_pw_btn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        forgot_pw_btn.setForeground(new java.awt.Color(204, 204, 204));
        forgot_pw_btn.setText("Forgot Your  Password?");
        getContentPane().add(forgot_pw_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        logo_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/logo login new.png"))); // NOI18N
        getContentPane().add(logo_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 240, 110));

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/Abstract-Lines-iPhone-5-wallpaper.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -70, 630, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
 
    login();
 

    }//GEN-LAST:event_btnloginActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
      if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            login();
        }
      
    }//GEN-LAST:event_txtpasswordKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               /* if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel forgot_pw_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo_login;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
