/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassasist;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import myclassasist.classpackage.databaseCon;
import myclassasist.classpackage.essentials;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Mr C
 */
public class exam_reg extends javax.swing.JFrame {

    /**
     * Creates new form exam_reg
     */
    public exam_reg() {
        initComponents();
         txteid.requestFocus();
         refresh();
         dataSetExam();
    }
    
    public void txtenable()
    {
         if(chbpractical.isSelected())
        {
            txtpractical.setEnabled(true);
        }
        else
            txtpractical.setEnabled(false);
    }

   public void txtreset()
   {
        txtstid.setText("");
        txtpaper.setText("");
        txtpractical.setText("0");
       
        txtstid.requestFocus();
   }
    
   
     public final void refresh()
    {
        
        
        try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            DefaultTableModel tb=(DefaultTableModel)tbexam.getModel();
            
             tb.setRowCount(0); 
            ResultSet rs = db1.getStatement().executeQuery("SELECT * FROM exam ;");
            
            int i=0;
           
            while(rs.next())
            {
               String dat1=rs.getString(1);
               String dat2=rs.getString(2);
               String dat3=rs.getString(3);
               String dat4=rs.getString(4);
                Date dat5=new Date(rs.getDate(5).getTime());
            Double dat6=rs.getDouble(6);
            Double dat7=rs.getDouble(7);
            Double dat8=rs.getDouble(8);
           Double dat9=rs.getDouble(9);
            Double dat10=rs.getDouble(10);
             
            Object[] row={dat1,dat2,dat3,dat4,dat5,dat6,dat7,dat8,dat9,dat10};
            
            tb.addRow(row);
            } 
         
            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }
    public void updatedata(){
     try{
             databaseCon dbadd2 = new databaseCon("root","");
     
             
             String s1 =txteid1.getText();
             String s2= (String) comcid2.getSelectedItem();
             String s3 =txtstid.getText();
          
             Double s4= Double.parseDouble(txtpaper.getText()); 
             Double s5= Double.parseDouble(txtpractical.getText());
        
             dbadd2.connect();
             ResultSet rs2 = dbadd2.getStatement().executeQuery("SELECT t_marks FROM exam WHERE e_id='"+s1+"' AND c_id='"+s2+"' AND e_type='paper';");
           
              double  t_marks=0;
             while(rs2.next())
                     {
           //total marks of student per subject
                        t_marks=rs2.getDouble(1); 
                     }
         
    
          double tm=s4+s5;
           
             if(tm>t_marks)
             {
                  essentials.infomsgbox("Error","Total marks exceeds the limit..");
                  txtpaper.setText("0");
                  txtpractical.setText("0");
                  txtpaper.requestFocus();
                  return;
            
             }
            
            String saveq="INSERT INTO std_marks VALUES(?,?,?,?,?,?,?);";
                 dbadd2.pStatement(saveq);
             
              
               dbadd2.getPs().setString(1,s3);
               dbadd2.getPs().setString(2,s2);
               dbadd2.getPs().setString(3, s1);
               dbadd2.getPs().setDouble(4,s4);
               dbadd2.getPs().setDouble(5,s5);
               dbadd2.getPs().setDouble(6,tm);        
               dbadd2.getPs().setString(7,calcGrade(tm,(int)(75/tm)*100,(int)(65/tm)*100,(int)(45/tm)*100,(int)(35/tm)*100));
               
               dbadd2.getPs().execute();
             
           
             dbadd2.disconnect();
             
              refresh2();
              txtreset();
               essentials.infomsgbox("Success","Data added Successfully!");
             
         } 
         catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
    }
       
     public void refresh2()
    {

         
        try{
            String s1 =txteid1.getText();
            String s3=txtstid.getText();
            String s2= (String) comcid2.getSelectedItem();
           
            databaseCon db2=new databaseCon("root","");
            db2.connect();
            DefaultTableModel tb=(DefaultTableModel)tbmarks.getModel();
             tb.setRowCount(0);
          
             double totval=0;
             double nosval=0;
             ResultSet nos = db2.getStatement().executeQuery("SELECT sum(p_marks),count(p_marks) FROM std_marks "
                    + "WHERE s_id='"+s3+"' AND e_id='"+s1+"' ;");
              
             while(nos.next())
             {  totval=nos.getInt(1);
                nosval=nos.getInt(2);
             }
        
         int i=1;
            ResultSet rs = db2.getStatement().executeQuery("SELECT s_id,p_marks,pr_marks,t_marks,grade FROM std_marks "
                    + "WHERE e_id='"+s1+"' AND c_id='"+s2+"' ORDER BY t_marks DESC ;");
                   
            while(rs.next())
            {
                
             String dat1=rs.getString(1);
            String dat2=rs.getString(2);
               String dat3=rs.getString(3);
               double dat4=rs.getDouble(4);
              double dat5=totval/nosval  ;
              String dat6=rs.getString(5);
               int dat7=i;
                i++;
               
                Object[] row={dat1,dat2,dat3,dat4,dat5,dat6,dat7};
                tb.addRow(row);
            } 
          tb.setRowCount(i);
                  
            db2.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
       
    }
   
    public void reset()
    {
       
       txtetitle.setText("");
       comcid.setSelectedIndex(0);
       txtpmarks.setText("");
       txtpt1.setText("");
       txtpt2.setText("");
       compdate.setCurrent(essentials.getCal());
       txtpr1.setText("");
       txtpr2.setText("");
       txtprmarks.setText("");
       comprdate.setCurrent(essentials.getCal());
       
       txteid.requestFocus();
       txteid.setEditable(true);
       txteid.setText("");
      
       comcid.setEnabled(true);
       btndel.setEnabled(false);
       btnup.setEnabled(false);
       
       txtprmarks.setEnabled(false);
        txtpr1.setEnabled(false);
        txtpr2.setEnabled(false);
        comprdate.setEnabled(false);
        
        chkpractical.setSelected(false);
        
    }

   void enablePractical(boolean a)
   {
       txtprmarks.setEnabled(a);
       txtprmarks.requestFocus();
       txtpr1.setEnabled(a);
       txtpr2.setEnabled(a);
       comprdate.setEnabled(a);
       comprt1.setEnabled(a);
       comprt2.setEnabled(a);
   }
   
   void enablePaper(boolean a)
   {
   txtpmarks.setEnabled(a);
       txtpmarks.requestFocus();
       txtpt1.setEnabled(a);
       txtpt2.setEnabled(a);
       compdate.setEnabled(a);
       compt1.setEnabled(a);
       compt2.setEnabled(a);
   }
   
   double duration(double s7,double s8)
   {
       int t1= (int)s7;
             int t2= (int)s8; 
             double frac=((s8-t2) - (s7-t1));
             double val=(t2-t1) +frac*100/60;
             return val;
   }
   
   void datasetMarks()
    {
         try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            String s1=txteid1.getText();
            ResultSet rs = db1.getStatement().executeQuery("SELECT c_id FROM exam WHERE e_id = '"+s1+"';");
            
           DefaultComboBoxModel commod= (DefaultComboBoxModel) comcid2.getModel();
           commod.removeAllElements();
           
            while(rs.next())
            {
                commod.addElement(rs.getString(1));
               
            } 
            
            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }
   
   void dataSetExam()
    {
         try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
           
            ResultSet rs = db1.getStatement().executeQuery("SELECT c_id FROM course_info;");
            
           DefaultComboBoxModel commod= (DefaultComboBoxModel) comcid.getModel();
           commod.removeAllElements();
           
            while(rs.next())
            {
                commod.addElement(rs.getString(1));
               
            } 
            
            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }
   
   String calcGrade(double avg,int A,int B,int C,int S)
   {
       if(avg>=A)
       { return "A"; }
       else if (avg>=B)
       {  return "B";}
        else if (avg>=C)
       {  return "C";} 
        else if (avg>=S)
       {  return "S";}
       else
        {   return "F";}
       
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        REGISTRATION = new javax.swing.JTabbedPane();
        CREATE_EXAM = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbexam = new javax.swing.JTable();
        jpanelcourse = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txteid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtetitle = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtpmarks = new javax.swing.JTextField();
        txtprmarks = new javax.swing.JTextField();
        chkpractical = new javax.swing.JCheckBox();
        chkpaper = new javax.swing.JCheckBox();
        compdate = new datechooser.beans.DateChooserCombo();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpt1 = new javax.swing.JTextField();
        compt1 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        txtpt2 = new javax.swing.JTextField();
        compt2 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        comprdate = new datechooser.beans.DateChooserCombo();
        jLabel30 = new javax.swing.JLabel();
        txtpr1 = new javax.swing.JTextField();
        comprt1 = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        txtpr2 = new javax.swing.JTextField();
        comprt2 = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        comcid = new javax.swing.JComboBox<>();
        btnprints = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnref = new javax.swing.JButton();
        btndel = new javax.swing.JButton();
        btnup = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        MARKINGS = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtstid = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblsname = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblnic = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtpaper = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbmarks = new javax.swing.JTable();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txteid1 = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        lblcid = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblduration = new javax.swing.JLabel();
        chbpractical = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        txtpractical = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comcid2 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        back_up1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("EduAssist v1.0 Exam Management");
        setMinimumSize(new java.awt.Dimension(940, 750));
        setPreferredSize(new java.awt.Dimension(980, 820));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        REGISTRATION.setBackground(new java.awt.Color(255, 255, 255));
        REGISTRATION.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        REGISTRATION.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                REGISTRATIONMouseClicked(evt);
            }
        });

        CREATE_EXAM.setOpaque(false);
        CREATE_EXAM.setLayout(null);

        tbexam.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tbexam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam ID", "Exam Title", "Course ID", "Type", "Data Prefered", "Start Time(Hrs)", "End time(Hrs)", "Duration(Hrs)", "Marks ", "Total Marks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbexam.setOpaque(false);
        tbexam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbexamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbexam);

        CREATE_EXAM.add(jScrollPane1);
        jScrollPane1.setBounds(20, 350, 930, 194);

        jpanelcourse.setBackground(new java.awt.Color(255, 255, 255));
        jpanelcourse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpanelcourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpanelcourseMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Exam ID");

        txteid.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txteid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteidActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Course ID");

        txtetitle.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtetitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtetitleActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Exam Title");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtpmarks.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtpmarks.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpmarks.setText("0");
        txtpmarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpmarksActionPerformed(evt);
            }
        });

        txtprmarks.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtprmarks.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtprmarks.setText("0");
        txtprmarks.setEnabled(false);
        txtprmarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprmarksActionPerformed(evt);
            }
        });

        chkpractical.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        chkpractical.setForeground(new java.awt.Color(51, 51, 51));
        chkpractical.setText("Practical Test");
        chkpractical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkpracticalActionPerformed(evt);
            }
        });

        chkpaper.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        chkpaper.setForeground(new java.awt.Color(51, 51, 51));
        chkpaper.setSelected(true);
        chkpaper.setText("Test Paper");
        chkpaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkpaperActionPerformed(evt);
            }
        });

        compdate.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    compdate.setFieldFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 15));
    compdate.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.PLAIN, 11));
    compdate.setCurrentNavigateIndex(0);

    jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel20.setForeground(new java.awt.Color(0, 0, 51));
    jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel20.setText("Pref_Date");

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(0, 0, 51));
    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel10.setText(" Pref_Time");

    txtpt1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    txtpt1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtpt1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtpt1ActionPerformed(evt);
        }
    });

    compt1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    compt1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));
    compt1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            compt1ActionPerformed(evt);
        }
    });

    jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel21.setForeground(new java.awt.Color(0, 0, 51));
    jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel21.setText("-");

    txtpt2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    txtpt2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtpt2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtpt2ActionPerformed(evt);
        }
    });

    compt2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    compt2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));
    compt2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            compt2ActionPerformed(evt);
        }
    });

    jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel22.setForeground(new java.awt.Color(0, 0, 51));
    jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel22.setText("Marks :");

    jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel29.setForeground(new java.awt.Color(0, 0, 51));
    jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel29.setText("Pref_Date");

    comprdate.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
        new datechooser.view.appearance.ViewAppearance("custom",
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                new java.awt.Color(187, 187, 187),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                new java.awt.Color(187, 187, 187),
                new java.awt.Color(0, 0, 255),
                true,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                new java.awt.Color(0, 0, 255),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                new java.awt.Color(128, 128, 128),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                new java.awt.Color(187, 187, 187),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                new java.awt.Color(187, 187, 187),
                new java.awt.Color(255, 0, 0),
                false,
                false,
                new datechooser.view.appearance.swing.ButtonPainter()),
            (datechooser.view.BackRenderer)null,
            false,
            true)));
comprdate.setEnabled(false);
comprdate.setFieldFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 15));
comprdate.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.PLAIN, 11));
comprdate.setCurrentNavigateIndex(0);

jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
jLabel30.setForeground(new java.awt.Color(0, 0, 51));
jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
jLabel30.setText(" Pref_Time");

txtpr1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
txtpr1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
txtpr1.setText("0");
txtpr1.setEnabled(false);
txtpr1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtpr1ActionPerformed(evt);
    }
    });

    comprt1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    comprt1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));
    comprt1.setEnabled(false);
    comprt1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comprt1ActionPerformed(evt);
        }
    });

    jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel31.setForeground(new java.awt.Color(0, 0, 51));
    jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel31.setText("-");

    txtpr2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    txtpr2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtpr2.setText("0");
    txtpr2.setEnabled(false);
    txtpr2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtpr2ActionPerformed(evt);
        }
    });

    comprt2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    comprt2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));
    comprt2.setEnabled(false);
    comprt2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comprt2ActionPerformed(evt);
        }
    });

    jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel32.setForeground(new java.awt.Color(0, 0, 51));
    jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel32.setText("Marks :");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(chkpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(compdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpmarks, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtpt1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(compt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(txtpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(compt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGap(73, 73, 73)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel30)
                    .addGap(392, 392, 392))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chkpractical, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comprdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtprmarks, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtpr1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comprt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(txtpr2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comprt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(106, 106, 106))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap(13, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(chkpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(chkpractical, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpmarks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(txtprmarks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comprdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(compdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpr1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comprt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpr2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comprt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(13, Short.MAX_VALUE))
    );

    comcid.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
    comcid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cid1", "cid2", "cid3" }));

    javax.swing.GroupLayout jpanelcourseLayout = new javax.swing.GroupLayout(jpanelcourse);
    jpanelcourse.setLayout(jpanelcourseLayout);
    jpanelcourseLayout.setHorizontalGroup(
        jpanelcourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jpanelcourseLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jpanelcourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpanelcourseLayout.createSequentialGroup()
                    .addGroup(jpanelcourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jpanelcourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpanelcourseLayout.createSequentialGroup()
                            .addComponent(txteid, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comcid, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtetitle))))
            .addContainerGap(18, Short.MAX_VALUE))
    );
    jpanelcourseLayout.setVerticalGroup(
        jpanelcourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelcourseLayout.createSequentialGroup()
            .addContainerGap(16, Short.MAX_VALUE)
            .addGroup(jpanelcourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelcourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comcid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(txteid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jpanelcourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtetitle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    CREATE_EXAM.add(jpanelcourse);
    jpanelcourse.setBounds(20, 12, 930, 320);

    btnprints.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    btnprints.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/print.png"))); // NOI18N
    btnprints.setText("PRINT SHEDULE");
    btnprints.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnprintsActionPerformed(evt);
        }
    });
    CREATE_EXAM.add(btnprints);
    btnprints.setBounds(770, 590, 180, 50);

    btnsave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/create.png"))); // NOI18N
    btnsave.setText("CREATE");
    btnsave.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnsaveActionPerformed(evt);
        }
    });
    CREATE_EXAM.add(btnsave);
    btnsave.setBounds(630, 600, 133, 40);

    btnclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/clear.png"))); // NOI18N
    btnclear.setText("CLEAR");
    btnclear.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnclearActionPerformed(evt);
        }
    });
    CREATE_EXAM.add(btnclear);
    btnclear.setBounds(490, 600, 133, 38);

    btnref.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnref.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/refresh.png"))); // NOI18N
    btnref.setText("REFRESH");
    btnref.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnrefActionPerformed(evt);
        }
    });
    CREATE_EXAM.add(btnref);
    btnref.setBounds(350, 600, 133, 38);

    btndel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btndel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/delete.png"))); // NOI18N
    btndel.setText("DELETE");
    btndel.setEnabled(false);
    btndel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btndelActionPerformed(evt);
        }
    });
    CREATE_EXAM.add(btndel);
    btndel.setBounds(220, 600, 120, 38);

    btnup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/update.png"))); // NOI18N
    btnup.setText("UPDATE");
    btnup.setEnabled(false);
    btnup.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnupActionPerformed(evt);
        }
    });
    CREATE_EXAM.add(btnup);
    btnup.setBounds(90, 600, 120, 38);

    jLabel33.setBackground(new java.awt.Color(0, 102, 102));
    jLabel33.setOpaque(true);
    CREATE_EXAM.add(jLabel33);
    jLabel33.setBounds(-70, 560, 1050, 110);

    REGISTRATION.addTab("CREATE EXAM", CREATE_EXAM);

    MARKINGS.setOpaque(false);
    MARKINGS.setLayout(null);

    jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(0, 0, 51));
    jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel11.setText("Student ID");
    MARKINGS.add(jLabel11);
    jLabel11.setBounds(30, 180, 99, 30);

    txtstid.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    txtstid.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtstidActionPerformed(evt);
        }
    });
    txtstid.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtstidKeyPressed(evt);
        }
    });
    MARKINGS.add(txtstid);
    txtstid.setBounds(140, 180, 172, 30);

    jPanel2.setBackground(new java.awt.Color(204, 204, 204));
    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(0, 0, 51));
    jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel12.setText("Name   :");

    lblsname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblsname.setForeground(new java.awt.Color(51, 51, 51));
    lblsname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(51, 51, 51));
    jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel13.setText("V");

    lblnic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblnic.setForeground(new java.awt.Color(51, 51, 51));
    lblnic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

    jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(0, 0, 51));
    jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel14.setText("NIC           :");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblsname, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblnic, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(170, 170, 170))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblsname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblnic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(16, Short.MAX_VALUE))
    );

    MARKINGS.add(jPanel2);
    jPanel2.setBounds(20, 240, 930, 60);

    jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel18.setForeground(new java.awt.Color(0, 0, 51));
    jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel18.setText("Exam ID :");
    MARKINGS.add(jLabel18);
    jLabel18.setBounds(30, 10, 97, 30);

    txtpaper.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    txtpaper.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtpaper.setText("0");
    txtpaper.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtpaperActionPerformed(evt);
        }
    });
    txtpaper.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtpaperKeyPressed(evt);
        }
    });
    MARKINGS.add(txtpaper);
    txtpaper.setBounds(400, 180, 97, 30);

    tbmarks.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    tbmarks.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Student ID", "Marks - Paper", "Marks - Practical", "Total Marks", "Avarage", "Grade", "Class Rank"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false, false
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    tbmarks.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbmarksMouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(tbmarks);

    MARKINGS.add(jScrollPane3);
    jScrollPane3.setBounds(21, 321, 930, 230);

    btnedit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/update.png"))); // NOI18N
    btnedit.setText("EDIT");
    btnedit.setEnabled(false);
    btnedit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btneditActionPerformed(evt);
        }
    });
    MARKINGS.add(btnedit);
    btnedit.setBounds(450, 600, 140, 40);

    btndelete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/delete.png"))); // NOI18N
    btndelete.setText(" DELETE");
    btndelete.setEnabled(false);
    btndelete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btndeleteActionPerformed(evt);
        }
    });
    MARKINGS.add(btndelete);
    btndelete.setBounds(600, 600, 140, 40);

    btnupdate.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    btnupdate.setText("UPDATE");
    btnupdate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnupdateActionPerformed(evt);
        }
    });
    MARKINGS.add(btnupdate);
    btnupdate.setBounds(720, 170, 110, 40);

    btnprint.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/print.png"))); // NOI18N
    btnprint.setText("PRINT MARKSHEET");
    btnprint.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnprintActionPerformed(evt);
        }
    });
    MARKINGS.add(btnprint);
    btnprint.setBounds(750, 590, 200, 50);

    jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel27.setForeground(new java.awt.Color(0, 0, 51));
    jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel27.setText("Paper ");
    MARKINGS.add(jLabel27);
    jLabel27.setBounds(340, 180, 58, 30);

    txteid1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    txteid1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txteid1ActionPerformed(evt);
        }
    });
    txteid1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txteid1KeyPressed(evt);
        }
    });
    MARKINGS.add(txteid1);
    txteid1.setBounds(140, 10, 175, 30);

    btnreset.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
    btnreset.setText("RESET");
    btnreset.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnresetActionPerformed(evt);
        }
    });
    MARKINGS.add(btnreset);
    btnreset.setBounds(840, 170, 110, 40);

    jPanel3.setBackground(new java.awt.Color(204, 204, 204));
    jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel19.setForeground(new java.awt.Color(0, 0, 51));
    jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel19.setText("Title   :");

    lbltitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lbltitle.setForeground(new java.awt.Color(51, 51, 51));
    lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    lblcid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblcid.setForeground(new java.awt.Color(51, 51, 51));
    lblcid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel23.setForeground(new java.awt.Color(0, 0, 51));
    jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel23.setText("Course    :");

    jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel24.setForeground(new java.awt.Color(0, 0, 51));
    jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel24.setText("Date  :");
    jLabel24.setToolTipText("");

    lbldate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lbldate.setForeground(new java.awt.Color(51, 51, 51));
    lbldate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel25.setForeground(new java.awt.Color(0, 0, 51));
    jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel25.setText("Time :");

    lbltime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lbltime.setForeground(new java.awt.Color(51, 51, 51));
    lbltime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel26.setForeground(new java.awt.Color(0, 0, 51));
    jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel26.setText("Duration :");

    lblduration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblduration.setForeground(new java.awt.Color(51, 51, 51));
    lblduration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    chbpractical.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    chbpractical.setForeground(new java.awt.Color(51, 51, 51));
    chbpractical.setText("Practical Test");
    chbpractical.setEnabled(false);
    chbpractical.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chbpracticalActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblcid, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(69, 69, 69))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblduration, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(chbpractical, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblcid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblduration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(chbpractical, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    MARKINGS.add(jPanel3);
    jPanel3.setBounds(22, 50, 930, 80);

    jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel28.setForeground(new java.awt.Color(0, 0, 51));
    jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel28.setText("Practical ");
    MARKINGS.add(jLabel28);
    jLabel28.setBounds(510, 180, 84, 30);

    txtpractical.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    txtpractical.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtpractical.setText("0");
    txtpractical.setEnabled(false);
    txtpractical.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtpracticalActionPerformed(evt);
        }
    });
    MARKINGS.add(txtpractical);
    txtpractical.setBounds(600, 180, 97, 30);

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 0, 51));
    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel5.setText("Course ID");
    MARKINGS.add(jLabel5);
    jLabel5.setBounds(366, 12, 95, 30);

    comcid2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
    comcid2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insert Exam ID" }));
    comcid2.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            comcid2ItemStateChanged(evt);
        }
    });
    comcid2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comcid2ActionPerformed(evt);
        }
    });
    comcid2.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            comcid2KeyPressed(evt);
        }
    });
    MARKINGS.add(comcid2);
    comcid2.setBounds(470, 10, 163, 31);

    jLabel34.setBackground(new java.awt.Color(0, 102, 102));
    jLabel34.setOpaque(true);
    MARKINGS.add(jLabel34);
    jLabel34.setBounds(-70, 560, 1050, 110);

    REGISTRATION.addTab("MARKINGS", MARKINGS);

    getContentPane().add(REGISTRATION, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 990, 700));

    title1.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
    title1.setForeground(new java.awt.Color(51, 0, 51));
    title1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    title1.setText("Exam Management");
    getContentPane().add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 420, 80));

    jLabel1.setBackground(new java.awt.Color(255, 255, 255));
    jLabel1.setOpaque(true);
    getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 980, 580));

    back_up1.setBackground(new java.awt.Color(255, 255, 255));
    back_up1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/calm-35843-36659-hd-wallpapers.jpg"))); // NOI18N
    getContentPane().add(back_up1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 1010, 130));
    getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 0));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtetitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtetitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtetitleActionPerformed

    private void txteidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteidActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
         try{
             databaseCon dbadd = new databaseCon("root","");
     
           
            
             String s1 =txteid.getText();
             String s2= (String) comcid.getSelectedItem();
             String s3 =txtetitle.getText();
            
             Double mp= Double.parseDouble(txtpmarks.getText()); 
             Double tp1= Double.parseDouble(txtpt1.getText());
             Double tp2= Double.parseDouble(txtpt2.getText());
            
             Calendar d1=compdate.getSelectedDate();
             
             Double tpr1=Double.parseDouble( txtpr1.getText());
             Double tpr2=Double.parseDouble( txtpr2.getText());
             Double mpr= Double.parseDouble(txtprmarks.getText()); 
             Calendar d2=comprdate.getSelectedDate();
         
             java.sql.Date pdate=new java.sql.Date(d1.getTimeInMillis());
             java.sql.Date prdate=new java.sql.Date(d2.getTimeInMillis());
             
             double tm=(mp+mpr);
             String p="paper";
             String pr="practical";
             
             
             dbadd.connect();
             
             
             if(chkpaper.isSelected()==true)
             {
                String saveq="INSERT INTO exam VALUES(?,?,?,?,?,?,?,?,?,?);";
                 dbadd.pStatement(saveq);
             
              
               dbadd.getPs().setString(1,s1);
               dbadd.getPs().setString(2,s2);
               dbadd.getPs().setString(3, s3);
               dbadd.getPs().setString(4, p);
               dbadd.getPs().setDate(5,pdate);
               dbadd.getPs().setDouble(6,tp1);
               dbadd.getPs().setDouble(7,tp2);
               dbadd.getPs().setDouble(8,duration(tp1,tp2));//duration
               dbadd.getPs().setDouble(9,mp);
               dbadd.getPs().setDouble(10,tm);
                dbadd.getPs().execute();
              
             } 
             
           
             if(chkpractical.isSelected()==true)
             {
                 String saveq="INSERT INTO exam VALUES(?,?,?,?,?,?,?,?,?,?);";
                 dbadd.pStatement(saveq);
             
              
               dbadd.getPs().setString(1,s1);
               dbadd.getPs().setString(2,s2);
               dbadd.getPs().setString(3, s3);
               dbadd.getPs().setString(4, pr);
               dbadd.getPs().setDate(5,prdate);
               dbadd.getPs().setDouble(6,tpr1);
               dbadd.getPs().setDouble(7,tpr2);
               dbadd.getPs().setDouble(8,duration(tpr1,tpr2));//duration
               dbadd.getPs().setDouble(9,mpr);
               dbadd.getPs().setDouble(10,tm);
                dbadd.getPs().execute();
              
             } 
             
             
             
              
             dbadd.disconnect();
             
              refresh();
              reset();
               essentials.infomsgbox("Success","Data added Successfully!");
             
         } 
         catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        
        try{
        databaseCon dbadd = new databaseCon("root","");
        
          int row=tbexam.getSelectedRow();
            String rc=(tbexam.getModel()).getValueAt(row,0).toString();
             String cd=(tbexam.getModel()).getValueAt(row,2).toString();
             
           dbadd.connect();
             
             String delq=("DELETE FROM exam WHERE e_id='"+rc+"' AND c_id='"+cd+"';");
             dbadd.pStatement(delq);
              
             String delq2=("DELETE  FROM std_marks WHERE e_id='"+rc+"' AND c_id='"+cd+"' ;");
             dbadd.pStatement(delq2);
             dbadd.getPs().executeUpdate();
             
              dbadd.disconnect();
              
             
              refresh();
              reset();
              essentials.infomsgbox("Success","Data deleted Successfully!");
      }
      
      catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
 

    }//GEN-LAST:event_btndelActionPerformed

    private void btnupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupActionPerformed
         try{
             databaseCon dbup = new databaseCon("root","");
           
           
             dbup.connect();
              
             String s1 =txteid1.getText();
             String s2= (String) comcid.getSelectedItem();
             String s3 =txtetitle.getText();
             Double mp= Double.parseDouble(txtpmarks.getText()); 
             Double tp1= Double.parseDouble(txtpt1.getText());
             Double tp2= Double.parseDouble(txtpt2.getText());
             Calendar d1=compdate.getSelectedDate();
             
             Double tpr1=Double.parseDouble( txtpr1.getText());
             Double tpr2=Double.parseDouble( txtpr2.getText());
             Double mpr= Double.parseDouble(txtprmarks.getText()); 
             Calendar d2=comprdate.getSelectedDate();
         
             java.sql.Date pdate=new java.sql.Date(d1.getTimeInMillis());
             java.sql.Date prdate=new java.sql.Date(d2.getTimeInMillis());

             double tm=mp+mpr;
            
            
              if(true==chkpaper.isSelected())
              {
             String upq=("UPDATE exam SET  e_title=?,date=?,t1=?,"
                     + "t2=?,duration=?,marks=?,t_marks=?  WHERE e_id='"+s1+"' AND c_id='"+s2+"' AND e_type='paper' ;");               
             dbup.pStatement(upq);
             
              dbup.getPs().setString(1, s3);
               dbup.getPs().setDate(2,pdate);
               dbup.getPs().setDouble(3,tp1);
               dbup.getPs().setDouble(4,tp2);
               dbup.getPs().setDouble(5,duration(tp1,tp2));
               dbup.getPs().setDouble(6,mp);
               dbup.getPs().setDouble(7, tm);
              dbup.getPs().execute();
               
              }
           
               if(true==chkpaper.isSelected())
              {
                  String upq2=("UPDATE exam SET  e_title=?,date=?,t1=?,"
                     + "t2=?,duration=?,marks=?,t_marks=?  WHERE e_id='"+s1+"' AND c_id='"+s2+"' AND e_type='practical' ;");               
             dbup.pStatement(upq2);
             
              dbup.getPs().setString(1, s3);
               dbup.getPs().setDate(2,prdate);
               dbup.getPs().setDouble(3,tpr1);
               dbup.getPs().setDouble(4,tpr2);
               dbup.getPs().setDouble(5,duration(tpr1,tpr2));
               dbup.getPs().setDouble(6,mpr);
               dbup.getPs().setDouble(7, tm);
              dbup.getPs().execute();
              }  
              
             
               
             dbup.disconnect();
             
            refresh();
            reset();
         
            essentials.infomsgbox("Success","Data Updated Successfully!");
         } 
        
         catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
           
            
 
           
    }//GEN-LAST:event_btnupActionPerformed

    private void btnrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefActionPerformed
       refresh();
    }//GEN-LAST:event_btnrefActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
       refresh();
       reset();
    }//GEN-LAST:event_btnclearActionPerformed

    private void tbexamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbexamMouseClicked
       int row=tbexam.getSelectedRow();
            String rc1=(tbexam.getModel()).getValueAt(row,0).toString();
            String rc2=(tbexam.getModel()).getValueAt(row,1).toString();
            String rc3=(tbexam.getModel()).getValueAt(row,3).toString();
            
             btndel.setEnabled(true);
             btnup.setEnabled(true);
          
             try{
       
           databaseCon db2 = new databaseCon("root","");
          
             db2.connect();
            
            ResultSet rs = db2.getStatement().executeQuery("SELECT * FROM exam WHERE  e_id='"+rc1+"'"
                    + " AND c_id='"+rc2+"'  AND e_type='"+rc3+"';");
            
             while(rs.next())
            {
                txteid.setText(rs.getString(1));
                comcid.setSelectedItem(rs.getString(2));
                txtetitle.setText(rs.getString(3));  
                
                if("paper".equals(rs.getString(4)))
                {     
                 chkpaper.setSelected(true);
                 chkpractical.setSelected(false);
                 enablePaper(true); 
                 enablePractical(false);
              
                 Calendar cal1=Calendar.getInstance();
                
                compdate.setSelectedDate(cal1);   
                txtpt1.setText(rs.getString(6)); 
                txtpt2.setText(rs.getString(7));
                txtpmarks.setText(rs.getString(9)); 
                txtpr1.setText("0"); 
                txtpr2.setText("0"); 
                txtprmarks.setText("0");
                }
                
                 if("practical".equals(rs.getString(4)))
                {   
                 chkpractical.setSelected(true);
                  chkpaper.setSelected(false);
                 enablePractical(true);  
                  enablePaper(false);
                
                Calendar cal2=Calendar.getInstance();
                
                comprdate.setSelectedDate(cal2);   
                txtpr1.setText(rs.getString(6)); 
                txtpr2.setText(rs.getString(7)); 
                txtprmarks.setText(rs.getString(9));
                  txtpt1.setText("0"); 
                txtpt2.setText("0");
                txtpmarks.setText("0"); 
                }
            }
           
             txteid.setEditable(false);
             comcid.setEnabled(false);
             txtetitle.requestFocus();
           
             db2.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }   
        
    }//GEN-LAST:event_tbexamMouseClicked

    private void txtstidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstidActionPerformed

    private void txtpaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaperActionPerformed

    private void txteid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteid1ActionPerformed
        
    }//GEN-LAST:event_txteid1ActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
       txtreset();
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
       String s1=txtstid.getText();
       
       int x= essentials.qmsgbox(s1,"Add Marks  to student "+s1+" ?");
       if(x==0)
         updatedata();
      
    }//GEN-LAST:event_btnupdateActionPerformed

    private void txtpt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpt1ActionPerformed

    private void compt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compt1ActionPerformed

    private void txtpt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpt2ActionPerformed

    private void compt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compt2ActionPerformed

    private void txtpmarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpmarksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpmarksActionPerformed

    private void txtprmarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprmarksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprmarksActionPerformed

    private void txtpracticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpracticalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpracticalActionPerformed

    private void comcid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comcid2ActionPerformed
      
    }//GEN-LAST:event_comcid2ActionPerformed

    private void jpanelcourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanelcourseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpanelcourseMouseClicked

    private void chkpracticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkpracticalActionPerformed
      if(chkpractical.isSelected()==true)
      {
          enablePractical(true);
      }
      else
      {
         enablePractical(false);
      }
    }//GEN-LAST:event_chkpracticalActionPerformed

    private void chkpaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkpaperActionPerformed
       if(chkpaper.isSelected()==true)
      {
          enablePaper(true);
      }
      else
      {
         enablePaper(false);
      }
      
    }//GEN-LAST:event_chkpaperActionPerformed

    private void txtpr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpr1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpr1ActionPerformed

    private void comprt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comprt1ActionPerformed

    private void txtpr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpr2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpr2ActionPerformed

    private void comprt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comprt2ActionPerformed

    private void chbpracticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbpracticalActionPerformed
       
    }//GEN-LAST:event_chbpracticalActionPerformed

    private void txteid1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txteid1KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
           comcid2.requestFocus();
           datasetMarks();
        }
  
    }//GEN-LAST:event_txteid1KeyPressed

    private void comcid2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comcid2KeyPressed
           
    }//GEN-LAST:event_comcid2KeyPressed

    private void txtstidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstidKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
           
            String s1=txtstid.getText();
           // String s2= (String) comcid2.getSelectedItem();
            
            try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            
            ResultSet rs = db1.getStatement().executeQuery("SELECT std_name,std_nic FROM student_info WHERE "
                    + "std_id='"+s1+"';");
           
            while(rs.next())
            {
                lblsname.setText(rs.getString(1));
                lblnic.setText(rs.getString(2));
                
            }
            
           
            txtpaper.requestFocus();
            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
        }
    }//GEN-LAST:event_txtstidKeyPressed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
         
        try{
        databaseCon dbadd = new databaseCon("root","");
        String s1=txteid1.getText();
        String s2=(String) comcid2.getSelectedItem();
        String s3=txtstid.getText();
             dbadd.connect();
            
             String delq=("DELETE FROM std_marks WHERE e_id='"+s1+"' AND c_id='"+s2+"' AND s_id='"+s3+"'  ;");
             dbadd.pStatement(delq);
             dbadd.getPs().executeUpdate();
             
              dbadd.disconnect();
              
             
              refresh2();
              txtreset();
              essentials.infomsgbox("Success","Data deleted Successfully!");
      }
      
      catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
 
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        
    }//GEN-LAST:event_btneditActionPerformed

    private void btnprintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintsActionPerformed
HashMap para=new HashMap();
      para.put("e_id",txteid.getText());   
        
        try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("Connecting ");
          Connection dbcon =DriverManager.getConnection("jdbc:mysql://localhost:3306/eduassist","root","");
          
          String REPORT = "D:\\MyclassAssistant\\MyclassAsist\\src\\myclassasist\\jreports\\e_shedule.jrxml";
             JasperReport JASP_REP=JasperCompileManager.compileReport(REPORT);
             JasperPrint J_PRINT = JasperFillManager.fillReport(JASP_REP,para,dbcon);
             JasperViewer.viewReport(J_PRINT,false);
             
            
            }
            catch(Exception e)
            {
              System.out.print(e);
                       }      }//GEN-LAST:event_btnprintsActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
       HashMap para=new HashMap();
      para.put("e_id",txteid1.getText());   
      para.put("c_id",(String) comcid2.getSelectedItem());   
        try{
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("Connecting ");
          Connection dbcon =DriverManager.getConnection("jdbc:mysql://localhost:3306/eduassist","root","");
          
          String REPORT = "D:\\MyclassAssistant\\MyclassAsist\\src\\myclassasist\\jreports\\e-MARKSHEET.jrxml";
             JasperReport JASP_REP=JasperCompileManager.compileReport(REPORT);
             JasperPrint J_PRINT = JasperFillManager.fillReport(JASP_REP,para,dbcon);
             JasperViewer.viewReport(J_PRINT,false);
             
            
            }
            catch(Exception e)
            {
              System.out.print(e);
                       }  
    }//GEN-LAST:event_btnprintActionPerformed

    private void REGISTRATIONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REGISTRATIONMouseClicked
       
    }//GEN-LAST:event_REGISTRATIONMouseClicked

    private void comcid2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comcid2ItemStateChanged
         refresh2();
           if( txteid1.getText()== null)
           {
               essentials.infomsgbox("Error","Add Exam ID first..");
               txteid1.requestFocus();
           }
            String s1=txteid1.getText();
            String s2=(String) comcid2.getSelectedItem();
            try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            
 ResultSet rs = db1.getStatement().executeQuery("SELECT e_title,c_id,date,t1,t2,duration,e_type FROM exam"
                    + " WHERE "
                    + "e_id='"+s1+"' AND c_id='"+s2+"' ;;");
           
           
            while(rs.next())
            {
                lbltitle.setText(rs.getString(1));
                lblcid.setText(rs.getString(2));
                lbldate.setText(rs.getString(3));
                lbltime.setText(rs.getString(4)+" - "+ rs.getString(5));
                lblduration.setText(rs.getString(6) + " Hours");
                if("practical".equals(rs.getString(7)))
                {
                    chbpractical.isSelected();
                    txtpractical.setEnabled(true);
                }
                else
                {
                    txtpractical.setEnabled(false);
                }
            } 
            
            db1.disconnect();
            refresh2();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
                
        
        txtstid.requestFocus();
    }//GEN-LAST:event_comcid2ItemStateChanged

    private void txtpaperKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpaperKeyPressed
     
    }//GEN-LAST:event_txtpaperKeyPressed

    private void tbmarksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbmarksMouseClicked
        btndelete.setEnabled(true);
    }//GEN-LAST:event_tbmarksMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(exam_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(exam_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(exam_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(exam_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new exam_reg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CREATE_EXAM;
    private javax.swing.JPanel MARKINGS;
    private javax.swing.JTabbedPane REGISTRATION;
    private javax.swing.JLabel back_up1;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnprints;
    private javax.swing.JButton btnref;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnup;
    private javax.swing.JButton btnupdate;
    private javax.swing.JCheckBox chbpractical;
    private javax.swing.JCheckBox chkpaper;
    private javax.swing.JCheckBox chkpractical;
    private javax.swing.JComboBox<String> comcid;
    private javax.swing.JComboBox<String> comcid2;
    private datechooser.beans.DateChooserCombo compdate;
    private datechooser.beans.DateChooserCombo comprdate;
    private javax.swing.JComboBox comprt1;
    private javax.swing.JComboBox comprt2;
    private javax.swing.JComboBox compt1;
    private javax.swing.JComboBox compt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpanelcourse;
    private javax.swing.JLabel lblcid;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblduration;
    private javax.swing.JLabel lblnic;
    private javax.swing.JLabel lblsname;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTable tbexam;
    private javax.swing.JTable tbmarks;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField txteid;
    private javax.swing.JTextField txteid1;
    private javax.swing.JTextField txtetitle;
    private javax.swing.JTextField txtpaper;
    private javax.swing.JTextField txtpmarks;
    private javax.swing.JTextField txtpr1;
    private javax.swing.JTextField txtpr2;
    private javax.swing.JTextField txtpractical;
    private javax.swing.JTextField txtprmarks;
    private javax.swing.JTextField txtpt1;
    private javax.swing.JTextField txtpt2;
    private javax.swing.JTextField txtstid;
    // End of variables declaration//GEN-END:variables
}
