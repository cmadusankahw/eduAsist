/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassasist;



import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import myclassasist.classpackage.databaseCon;
import myclassasist.classpackage.essentials;

/**
 *
 * @author Mr C
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     * @param uname
     * @param utype
     */
    public main(String uname,String utype) {
        initComponents();
        username.setText(uname);
        setdata();
        QPANEL.setVisible(false);
        
        if ("marker".equals(utype))
        {
            disbutton();
        }
        
        this.setResizable(false);
        Toolkit tk=  Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
       this.setSize(xsize,ysize);
       GregorianCalendar cal=new GregorianCalendar();
       int month=cal.get(Calendar.MONTH);
       int d=cal.get(Calendar.DATE);
       lbldate.setText((cal.get(Calendar.YEAR)+"."+month+1+"."+d));
       
       lbltime.setText(essentials.dayOfweek(cal.get(Calendar.DAY_OF_WEEK)));
       
    }
  
   public void reset1()
   {
       lblname.setText("");
       lblnic.setText("");
       lbltype.setText("");
       lblgen.setText("");
       lbladdress.setText("");
       lblmobile.setText("");
       lblhome.setText("");
       lbldob.setText("");
       lblschool.setText("");
       lblage.setText("");
       txtsidc.setText("");
       txtsidc.requestFocus();
       lblage.setText("");
       lbldatereg.setText("");
       lblemail.setText("");
       txtsidc1.setText("");
   }
   
    public void reset2()
   {
       lbltitle.setText("");
       lbltutor.setText("");
       lblday.setText("");
       lbltime.setText("");
       lblduration.setText("");
       lblregfee.setText("");
       lblclassfee.setText("");
       lblcdatereg.setText("");
      txttitle.setText("");
        txtcid.setText("");
       txtcid.requestFocus();
     
       
   }
    
     public void reset3()
   {
       lblname2.setText("");
       lblnic2.setText("");
       lbltype2.setText("");
       lblgen2.setText("");
       lbladdress2.setText("");
       lblmobile2.setText("");
       lblhome2.setText("");
       lbldob2.setText("");
      lblemail2.setText("");
       lblage2.setText("");
        txtstaff.setText("");
       txtstaff.requestFocus();
       lblage2.setText("");
       lbldatereg2.setText("");
       txtsname.setText("");
       
   }
    
  
    public void disbutton()
    {
        this.btn_course.setEnabled(false);
        this.btn_staff1.setEnabled(false);
        this.btn_exam.setEnabled(false);
        this.btn_user.setEnabled(false);
        this.btn_exam.setEnabled(false);
        this.adduser_item.setEnabled(false);
        this.course_item2.setEnabled(false);
        this.exam_item3.setEnabled(false);
        this.staff_item1.setEnabled(false);  
        
    }
    
    public void setdata()
    {
        
     try{
              DefaultTableModel tbe=(DefaultTableModel)tbexam.getModel();
              DefaultTableModel tbl=(DefaultTableModel)tblec.getModel();
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            GregorianCalendar cal=new GregorianCalendar();
            int cdate=cal.get(Calendar.DAY_OF_WEEK);
            ResultSet rs = db1.getStatement().executeQuery("SELECT c_id,c_title,lec_id,c_time FROM course_info WHERE cdayindex="+cdate+";");
            int i=0,j=0;
            
            while(rs.next())
            {
                tblec.getModel().setValueAt(rs.getString(1),i,0);
                tblec.getModel().setValueAt(rs.getString(2),i,1);
                tblec.getModel().setValueAt(rs.getString(3),i,2);
                tblec.getModel().setValueAt(rs.getString(4)+ " Hrs",i,3);
              i++;
            } 
            tbl.setRowCount(i);
            
            ResultSet rs2 = db1.getStatement().executeQuery("SELECT e.e_id,e.e_title,c.c_title,e.t1+' - '+e.t2 FROM exam as e,course_info as c WHERE c.c_id=e.c_id  AND c.cdayindex="+cdate+";");
           
            
            while(rs2.next())
            {
                tbexam.getModel().setValueAt(rs2.getString(1),j,0);
                tbexam.getModel().setValueAt(rs2.getString(2),j,1);
                tbexam.getModel().setValueAt(rs2.getString(3),j,2);
                tbexam.getModel().setValueAt(rs2.getString(4),j,3);
             j++;
            } 
            tbe.setRowCount(i);
            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user_popup = new javax.swing.JPopupMenu();
        finance_panel = new javax.swing.JPanel();
        btncalc = new javax.swing.JButton();
        btnq1 = new javax.swing.JButton();
        btnreports = new javax.swing.JButton();
        btnq2 = new javax.swing.JButton();
        register_panel = new javax.swing.JPanel();
        btn_course = new javax.swing.JButton();
        btn_student = new javax.swing.JButton();
        btn_exam = new javax.swing.JButton();
        btn_staff1 = new javax.swing.JButton();
        payment_panel = new javax.swing.JPanel();
        btnattend = new javax.swing.JButton();
        btnpay = new javax.swing.JButton();
        user_panel = new javax.swing.JPanel();
        username1 = new javax.swing.JLabel();
        btn_user = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        panellec1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbexam = new javax.swing.JTable();
        panellec = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblec = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        QPANEL = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        student = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblnic = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblgen = new javax.swing.JLabel();
        lbltype = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        lbladdress = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        lbldob = new javax.swing.JLabel();
        lblschool = new javax.swing.JLabel();
        lblhome = new javax.swing.JLabel();
        lblage = new javax.swing.JLabel();
        lblmobile = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbldatereg = new javax.swing.JLabel();
        lblemail3 = new javax.swing.JLabel();
        btnr1c = new javax.swing.JButton();
        txtsidc = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtsidc1 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbquery = new javax.swing.JTable();
        marksheet = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lbltitle = new javax.swing.JLabel();
        lbltutor = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbltime2 = new javax.swing.JLabel();
        lblday = new javax.swing.JLabel();
        lblduration = new javax.swing.JLabel();
        lblregfee = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lblcdatereg = new javax.swing.JLabel();
        lblemail4 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblclassfee = new javax.swing.JLabel();
        btnr1c1 = new javax.swing.JButton();
        txtcid = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txttitle = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbqueryc = new javax.swing.JTable();
        financial = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lblname2 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lblnic2 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        lblgen2 = new javax.swing.JLabel();
        lbltype2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lbladdress2 = new javax.swing.JTextArea();
        jLabel51 = new javax.swing.JLabel();
        lbldob2 = new javax.swing.JLabel();
        lblhome2 = new javax.swing.JLabel();
        lblage2 = new javax.swing.JLabel();
        lblmobile2 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        lblemail2 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        lbldatereg2 = new javax.swing.JLabel();
        lblemail6 = new javax.swing.JLabel();
        btnr1c2 = new javax.swing.JButton();
        txtstaff = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtsname = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbquerys = new javax.swing.JTable();
        background_img = new javax.swing.JLabel();
        main_menu = new javax.swing.JMenuBar();
        file_menu = new javax.swing.JMenu();
        exit_item = new javax.swing.JMenuItem();
        actions_menu = new javax.swing.JMenu();
        student_item = new javax.swing.JMenuItem();
        staff_item1 = new javax.swing.JMenuItem();
        course_item2 = new javax.swing.JMenuItem();
        exam_item3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        payment_item4 = new javax.swing.JMenuItem();
        attend_item5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        report_item6 = new javax.swing.JMenuItem();
        report_item7 = new javax.swing.JMenuItem();
        studentcalc = new javax.swing.JMenuItem();
        user_menu = new javax.swing.JMenu();
        adduser_item = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        logoff_item = new javax.swing.JMenuItem();
        help_menu = new javax.swing.JMenu();
        help_item = new javax.swing.JMenuItem();
        about_item = new javax.swing.JMenuItem();

        user_popup.setComponentPopupMenu(user_popup);
        user_popup.setName("user-popup"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EduAsist v1.0 for Sipyana Institute - Matara");
        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        setName("main_frame"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        finance_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Financial & Management Reports", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        finance_panel.setOpaque(false);
        finance_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncalc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btncalc.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\calc.png")); // NOI18N
        btncalc.setText("Calculator");
        btncalc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btncalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcActionPerformed(evt);
            }
        });
        finance_panel.add(btncalc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 260, 45));

        btnq1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnq1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/exam.png"))); // NOI18N
        btnq1.setText("Quick Query");
        btnq1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnq1ActionPerformed(evt);
            }
        });
        finance_panel.add(btnq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 260, 45));

        btnreports.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnreports.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\report.png")); // NOI18N
        btnreports.setText("Quick Reports");
        btnreports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnreports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportsActionPerformed(evt);
            }
        });
        finance_panel.add(btnreports, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 260, 45));

        btnq2.setBackground(new java.awt.Color(0, 255, 0));
        btnq2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnq2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/exam.png"))); // NOI18N
        btnq2.setText("Quick Query");
        btnq2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnq2ActionPerformed(evt);
            }
        });
        finance_panel.add(btnq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 260, 45));

        getContentPane().add(finance_panel);
        finance_panel.setBounds(20, 510, 340, 220);

        register_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Registration & management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        register_panel.setOpaque(false);
        register_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_course.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_course.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\course.png")); // NOI18N
        btn_course.setText("Course Management");
        btn_course.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_courseActionPerformed(evt);
            }
        });
        register_panel.add(btn_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 260, 50));

        btn_student.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_student.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\User Groups_32px.png")); // NOI18N
        btn_student.setText("Student Management");
        btn_student.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_studentActionPerformed(evt);
            }
        });
        register_panel.add(btn_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 260, 50));

        btn_exam.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_exam.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\exam.png")); // NOI18N
        btn_exam.setText("Exam management");
        btn_exam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_exam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_examActionPerformed(evt);
            }
        });
        register_panel.add(btn_exam, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 260, 50));

        btn_staff1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_staff1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\staff.png")); // NOI18N
        btn_staff1.setText("Staff Management");
        btn_staff1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_staff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_staff1ActionPerformed(evt);
            }
        });
        register_panel.add(btn_staff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 260, 50));

        getContentPane().add(register_panel);
        register_panel.setBounds(20, 50, 340, 280);

        payment_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Payments & Attendance\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        payment_panel.setOpaque(false);
        payment_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnattend.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnattend.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\attendance.png")); // NOI18N
        btnattend.setText("Daily Attendance");
        btnattend.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnattend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnattendActionPerformed(evt);
            }
        });
        payment_panel.add(btnattend, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 260, 45));

        btnpay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnpay.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\pay.png")); // NOI18N
        btnpay.setText("Create Payment");
        btnpay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayActionPerformed(evt);
            }
        });
        payment_panel.add(btnpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 260, 45));

        getContentPane().add(payment_panel);
        payment_panel.setBounds(20, 340, 340, 160);

        user_panel.setOpaque(false);

        username1.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        username1.setForeground(new java.awt.Color(0, 0, 51));
        username1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username1.setText("Welcome!");

        btn_user.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\Untitled-1 copy.png")); // NOI18N
        btn_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_userMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_userMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("You've Logged in as,");

        username.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        username.setForeground(new java.awt.Color(0, 0, 51));
        username.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username.setText("Username");

        javax.swing.GroupLayout user_panelLayout = new javax.swing.GroupLayout(user_panel);
        user_panel.setLayout(user_panelLayout);
        user_panelLayout.setHorizontalGroup(
            user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(user_panelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(username1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                    .addComponent(username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_user, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        user_panelLayout.setVerticalGroup(
            user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_panelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btn_user, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(user_panelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(user_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(user_panel);
        user_panel.setBounds(1410, 90, 440, 140);

        panellec1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 3), "Today's Exams", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(0, 0, 51))); // NOI18N
        panellec1.setOpaque(false);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        tbexam.setAutoCreateRowSorter(true);
        tbexam.setBackground(new java.awt.Color(255, 255, 255));
        tbexam.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbexam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Exam ID", "Exam Title", "Course Title", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbexam.setAlignmentX(3.0F);
        tbexam.setGridColor(new java.awt.Color(0, 102, 102));
        tbexam.setOpaque(false);
        tbexam.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbexam.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setViewportView(tbexam);

        javax.swing.GroupLayout panellec1Layout = new javax.swing.GroupLayout(panellec1);
        panellec1.setLayout(panellec1Layout);
        panellec1Layout.setHorizontalGroup(
            panellec1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellec1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addContainerGap())
        );
        panellec1Layout.setVerticalGroup(
            panellec1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellec1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(panellec1);
        panellec1.setBounds(420, 340, 780, 320);

        panellec.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 3), "Today's Lectures", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(0, 0, 51))); // NOI18N
        panellec.setOpaque(false);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setOpaque(false);

        tblec.setAutoCreateRowSorter(true);
        tblec.setBackground(new java.awt.Color(255, 255, 255));
        tblec.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tblec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course ID", "Course Title", "Tutor", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblec.setAlignmentX(3.0F);
        tblec.setGridColor(new java.awt.Color(0, 102, 102));
        tblec.setOpaque(false);
        tblec.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblec.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane2.setViewportView(tblec);

        javax.swing.GroupLayout panellecLayout = new javax.swing.GroupLayout(panellec);
        panellec.setLayout(panellecLayout);
        panellecLayout.setHorizontalGroup(
            panellecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellecLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addContainerGap())
        );
        panellecLayout.setVerticalGroup(
            panellecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellecLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(panellec);
        panellec.setBounds(420, 50, 780, 280);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\icon set\\main logo copy.png")); // NOI18N
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(110, 820, 150, 140);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("All Rights Reserved.");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 980, 360, 20);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("2018 Sipyana Higher Educational Institue");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 960, 360, 20);

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-6, 0, 390, 1060);

        lbldate.setFont(new java.awt.Font("Dialog", 1, 34)); // NOI18N
        lbldate.setForeground(new java.awt.Color(0, 0, 102));
        lbldate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbldate);
        lbldate.setBounds(1440, 310, 400, 60);

        lbltime.setFont(new java.awt.Font("Dialog", 1, 44)); // NOI18N
        lbltime.setForeground(new java.awt.Color(0, 0, 102));
        lbltime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbltime);
        lbltime.setBounds(1570, 250, 270, 60);

        QPANEL.setOpaque(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N

        student.setBackground(new java.awt.Color(255, 255, 255));
        student.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), "Student Query", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setOpaque(false);

        lblname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblname.setForeground(new java.awt.Color(51, 51, 51));
        lblname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("V");

        lblnic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblnic.setForeground(new java.awt.Color(51, 51, 51));
        lblnic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblnic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 51));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("NIC           ");
        jLabel22.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Full Name  ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Address");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Type");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Home_No");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Gender");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("DOB");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("School");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Age");

        lblgen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblgen.setForeground(new java.awt.Color(51, 51, 51));
        lblgen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblgen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lbltype.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltype.setForeground(new java.awt.Color(51, 51, 51));
        lbltype.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltype.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jScrollPane8.setBorder(null);
        jScrollPane8.setOpaque(false);

        lbladdress.setEditable(false);
        lbladdress.setBackground(new java.awt.Color(204, 204, 204));
        lbladdress.setColumns(20);
        lbladdress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbladdress.setForeground(new java.awt.Color(51, 51, 51));
        lbladdress.setRows(5);
        lbladdress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        lbladdress.setOpaque(false);
        jScrollPane8.setViewportView(lbladdress);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Mobile_No");

        lbldob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldob.setForeground(new java.awt.Color(51, 51, 51));
        lbldob.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbldob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblschool.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblschool.setForeground(new java.awt.Color(51, 51, 51));
        lblschool.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblschool.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblhome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblhome.setForeground(new java.awt.Color(51, 51, 51));
        lblhome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblhome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblage.setForeground(new java.awt.Color(51, 51, 51));
        lblage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile.setForeground(new java.awt.Color(51, 51, 51));
        lblmobile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblmobile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("E-mail");

        lblemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblemail.setForeground(new java.awt.Color(51, 51, 51));
        lblemail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblemail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Reg_date");

        lbldatereg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldatereg.setForeground(new java.awt.Color(51, 51, 51));
        lbldatereg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbldatereg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblemail3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblemail3.setForeground(new java.awt.Color(51, 51, 51));
        lblemail3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblemail3.setText("Years");

        btnr1c.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnr1c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/reset.png"))); // NOI18N
        btnr1c.setText("RESET");
        btnr1c.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnr1c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnr1cActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblnic, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltype, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblgen, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblmobile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblhome, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(lblage, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblemail3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnr1c, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGap(23, 23, 23)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbldatereg, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblschool, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbldob, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblnic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblemail3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblgen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblhome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblschool, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbldatereg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnr1c, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtsidc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtsidc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsidcActionPerformed(evt);
            }
        });
        txtsidc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsidcKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsidcKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Student ID :");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 51));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Name :");
        jLabel26.setToolTipText("");

        txtsidc1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtsidc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsidc1ActionPerformed(evt);
            }
        });
        txtsidc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsidc1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsidc1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsidc1KeyTyped(evt);
            }
        });

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));

        tbquery.setBackground(new java.awt.Color(255, 255, 255));
        tbquery.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbquery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "School"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbquery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbqueryMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbquery);

        javax.swing.GroupLayout studentLayout = new javax.swing.GroupLayout(student);
        student.setLayout(studentLayout);
        studentLayout.setHorizontalGroup(
            studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentLayout.createSequentialGroup()
                        .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsidc, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsidc1)))
                .addContainerGap())
        );
        studentLayout.setVerticalGroup(
            studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsidc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsidc1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Students", student);

        marksheet.setBackground(new java.awt.Color(255, 255, 255));
        marksheet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), "Course Query", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setOpaque(false);

        lbltitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(51, 51, 51));
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lbltutor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltutor.setForeground(new java.awt.Color(51, 51, 51));
        lbltutor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Tutor");
        jLabel23.setToolTipText("");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 51));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Title");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 51));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Pref_day");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Pref_time");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Duration");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Reg Fee(Rs.)");

        lbltime2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltime2.setForeground(new java.awt.Color(51, 51, 51));
        lbltime2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltime2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblday.setForeground(new java.awt.Color(51, 51, 51));
        lblday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblduration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblduration.setForeground(new java.awt.Color(51, 51, 51));
        lblduration.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblduration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblregfee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblregfee.setForeground(new java.awt.Color(51, 51, 51));
        lblregfee.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblregfee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 51));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Reg_date");

        lblcdatereg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcdatereg.setForeground(new java.awt.Color(51, 51, 51));
        lblcdatereg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblcdatereg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblemail4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblemail4.setForeground(new java.awt.Color(51, 51, 51));
        lblemail4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblemail4.setText("Days");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 51));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Class Fee(Rs.)");

        lblclassfee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblclassfee.setForeground(new java.awt.Color(51, 51, 51));
        lblclassfee.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblclassfee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        btnr1c1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnr1c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/reset.png"))); // NOI18N
        btnr1c1.setText("RESET");
        btnr1c1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnr1c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnr1c1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addGap(18, 161, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltutor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblday, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltime2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblclassfee, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblregfee, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblduration, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblemail4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(218, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblcdatereg, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnr1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbltutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblday, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltime2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblduration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblemail4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblregfee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblclassfee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcdatereg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnr1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtcid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtcid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcidActionPerformed(evt);
            }
        });
        txtcid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcidKeyReleased(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 51));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("Course ID :");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Title :");
        jLabel29.setToolTipText("");

        txttitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txttitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttitleActionPerformed(evt);
            }
        });
        txttitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttitleKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttitleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttitleKeyTyped(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        tbqueryc.setBackground(new java.awt.Color(255, 255, 255));
        tbqueryc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbqueryc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Course Title", "Lecturer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbqueryc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbquerycMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbqueryc);

        javax.swing.GroupLayout marksheetLayout = new javax.swing.GroupLayout(marksheet);
        marksheet.setLayout(marksheetLayout);
        marksheetLayout.setHorizontalGroup(
            marksheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marksheetLayout.createSequentialGroup()
                .addGroup(marksheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(marksheetLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(marksheetLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(marksheetLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txttitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        marksheetLayout.setVerticalGroup(
            marksheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marksheetLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(marksheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Courses", marksheet);

        financial.setBackground(new java.awt.Color(255, 255, 255));
        financial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));
        financial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                financialKeyReleased(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3), "Staff Query", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setOpaque(false);

        lblname2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblname2.setForeground(new java.awt.Color(51, 51, 51));
        lblname2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblname2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("V");

        lblnic2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblnic2.setForeground(new java.awt.Color(51, 51, 51));
        lblnic2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblnic2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 51));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("NIC           ");
        jLabel42.setToolTipText("");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 51));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("Full Name  ");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 51));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("Address");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 51));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("Type");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 51));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Home_No");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 51));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel47.setText("Gender");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 51));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel48.setText("DOB");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 51));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("Age");

        lblgen2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblgen2.setForeground(new java.awt.Color(51, 51, 51));
        lblgen2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblgen2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lbltype2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltype2.setForeground(new java.awt.Color(51, 51, 51));
        lbltype2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltype2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        lbladdress2.setEditable(false);
        lbladdress2.setBackground(new java.awt.Color(204, 204, 204));
        lbladdress2.setColumns(20);
        lbladdress2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbladdress2.setForeground(new java.awt.Color(51, 51, 51));
        lbladdress2.setRows(5);
        lbladdress2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        lbladdress2.setOpaque(false);
        jScrollPane3.setViewportView(lbladdress2);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 51));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("Mobile_No");

        lbldob2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldob2.setForeground(new java.awt.Color(51, 51, 51));
        lbldob2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbldob2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblhome2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblhome2.setForeground(new java.awt.Color(51, 51, 51));
        lblhome2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblhome2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblage2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblage2.setForeground(new java.awt.Color(51, 51, 51));
        lblage2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblmobile2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile2.setForeground(new java.awt.Color(51, 51, 51));
        lblmobile2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblmobile2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 51));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel52.setText("E-mail");

        lblemail2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblemail2.setForeground(new java.awt.Color(51, 51, 51));
        lblemail2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblemail2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 51));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("Reg_date");

        lbldatereg2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldatereg2.setForeground(new java.awt.Color(51, 51, 51));
        lbldatereg2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbldatereg2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        lblemail6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblemail6.setForeground(new java.awt.Color(51, 51, 51));
        lblemail6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblemail6.setText("Years");

        btnr1c2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnr1c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/reset.png"))); // NOI18N
        btnr1c2.setText("RESET");
        btnr1c2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnr1c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnr1c2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(lblnic2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblname2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltype2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblgen2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblmobile2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel46)
                                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblhome2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addComponent(lblage2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblemail6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(lbldob2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbldatereg2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblemail2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnr1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblname2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldob2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblnic2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblage2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblemail6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltype2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmobile2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblgen2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblhome2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblemail2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldatereg2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnr1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        txtstaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtstaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstaffActionPerformed(evt);
            }
        });
        txtstaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtstaffKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtstaffKeyReleased(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 51));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel54.setText("Staff  ID :");

        txtsname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtsname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsnameActionPerformed(evt);
            }
        });
        txtsname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsnameKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Name :");
        jLabel30.setToolTipText("");

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        tbquerys.setBackground(new java.awt.Color(255, 255, 255));
        tbquerys.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tbquerys.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID", "Name", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbquerys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbquerysMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbquerys);

        javax.swing.GroupLayout financialLayout = new javax.swing.GroupLayout(financial);
        financial.setLayout(financialLayout);
        financialLayout.setHorizontalGroup(
            financialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(financialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(financialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 904, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addGroup(financialLayout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsname, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        financialLayout.setVerticalGroup(
            financialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, financialLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(financialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Staff Members", financial);

        javax.swing.GroupLayout QPANELLayout = new javax.swing.GroupLayout(QPANEL);
        QPANEL.setLayout(QPANELLayout);
        QPANELLayout.setHorizontalGroup(
            QPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QPANELLayout.setVerticalGroup(
            QPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QPANELLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        getContentPane().add(QPANEL);
        QPANEL.setBounds(400, 73, 950, 930);

        background_img.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chiran\\Desktop\\Java_project_res\\main.jpg")); // NOI18N
        getContentPane().add(background_img);
        background_img.setBounds(0, -100, 1980, 1250);

        file_menu.setText("File");

        exit_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exit_item.setText("Exit EduAsist");
        exit_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_itemActionPerformed(evt);
            }
        });
        file_menu.add(exit_item);

        main_menu.add(file_menu);

        actions_menu.setText("Actions");

        student_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        student_item.setText("Student Management");
        student_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_itemActionPerformed(evt);
            }
        });
        actions_menu.add(student_item);

        staff_item1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        staff_item1.setText("Staff Management");
        staff_item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_item1ActionPerformed(evt);
            }
        });
        actions_menu.add(staff_item1);

        course_item2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        course_item2.setText("Course Management");
        course_item2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_item2ActionPerformed(evt);
            }
        });
        actions_menu.add(course_item2);

        exam_item3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exam_item3.setText("Exam Management");
        exam_item3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exam_item3ActionPerformed(evt);
            }
        });
        actions_menu.add(exam_item3);
        actions_menu.add(jSeparator1);

        payment_item4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        payment_item4.setText("Create Payments");
        payment_item4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_item4ActionPerformed(evt);
            }
        });
        actions_menu.add(payment_item4);

        attend_item5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        attend_item5.setText("Attendence");
        attend_item5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attend_item5ActionPerformed(evt);
            }
        });
        actions_menu.add(attend_item5);
        actions_menu.add(jSeparator2);

        report_item6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        report_item6.setText("Quick Reports");
        report_item6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                report_item6ActionPerformed(evt);
            }
        });
        actions_menu.add(report_item6);

        report_item7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        report_item7.setText("Run Seperate Query");
        report_item7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                report_item7ActionPerformed(evt);
            }
        });
        actions_menu.add(report_item7);

        studentcalc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        studentcalc.setText("Calculator");
        studentcalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentcalcActionPerformed(evt);
            }
        });
        actions_menu.add(studentcalc);

        main_menu.add(actions_menu);

        user_menu.setText("Users");

        adduser_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        adduser_item.setText("Add/Remove Users");
        adduser_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduser_itemActionPerformed(evt);
            }
        });
        user_menu.add(adduser_item);
        user_menu.add(jSeparator3);

        logoff_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        logoff_item.setText("Log Off...");
        logoff_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoff_itemActionPerformed(evt);
            }
        });
        user_menu.add(logoff_item);

        main_menu.add(user_menu);

        help_menu.setText("Help");

        help_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        help_item.setText("Online Help");
        help_menu.add(help_item);

        about_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        about_item.setText("About eduasist");
        about_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_itemActionPerformed(evt);
            }
        });
        help_menu.add(about_item);

        main_menu.add(help_menu);

        setJMenuBar(main_menu);

        setLocation(new java.awt.Point(0, 0));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_examActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_examActionPerformed
        new exam_reg().setVisible(true);
        //btn_exam.setBackground (new Color (50,250,50));
    }//GEN-LAST:event_btn_examActionPerformed

    private void btncalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcActionPerformed
        new calc().setVisible(true);
        //btncalc.setBackground (new Color (50,250,50));
    }//GEN-LAST:event_btncalcActionPerformed

    private void btn_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_courseActionPerformed
        new course_reg().setVisible(true);
        //btn_course.setBackground (new Color (50,250,50));
    }//GEN-LAST:event_btn_courseActionPerformed

    private void btn_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_studentActionPerformed
       new student_reg().setVisible(true);
       //btn_student.setBackground (new Color (50,250,50));
      
    }//GEN-LAST:event_btn_studentActionPerformed

    private void btnattendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnattendActionPerformed
        new attendance().setVisible(true);
        //btnattend.setBackground (new Color (50,250,50));
    }//GEN-LAST:event_btnattendActionPerformed

    private void btnpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayActionPerformed
       new payment().setVisible(true);
      // btnpay.setBackground (new Color (50,250,50));
    }//GEN-LAST:event_btnpayActionPerformed

    private void btnq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnq1ActionPerformed
       btnq1.setVisible(false);
        btnq2.setVisible(true);
        panellec.setVisible(false);
       panellec1.setVisible(false);
        QPANEL.setVisible(true);
        txtsidc.requestFocus();
       
    }//GEN-LAST:event_btnq1ActionPerformed

    private void btn_userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_userMouseEntered
        
    }//GEN-LAST:event_btn_userMouseEntered

    private void btn_userMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_userMousePressed
       
    }//GEN-LAST:event_btn_userMousePressed

    private void logoff_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoff_itemActionPerformed
        new login_form().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoff_itemActionPerformed

    private void adduser_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduser_itemActionPerformed
        new users().setVisible(true);
    }//GEN-LAST:event_adduser_itemActionPerformed

    private void about_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_itemActionPerformed
        new about().setVisible(true);
    }//GEN-LAST:event_about_itemActionPerformed

    private void student_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_itemActionPerformed
         new student_reg().setVisible(true);
    }//GEN-LAST:event_student_itemActionPerformed

    private void staff_item1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_item1ActionPerformed
        new staff_reg().setVisible(true);
    }//GEN-LAST:event_staff_item1ActionPerformed

    private void course_item2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_item2ActionPerformed
        new course_reg().setVisible(true);
    }//GEN-LAST:event_course_item2ActionPerformed

    private void exam_item3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exam_item3ActionPerformed
        new exam_reg().setVisible(true);
    }//GEN-LAST:event_exam_item3ActionPerformed

    private void payment_item4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_item4ActionPerformed
        new payment().setVisible(true);
    }//GEN-LAST:event_payment_item4ActionPerformed

    private void attend_item5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attend_item5ActionPerformed
        new attendance().setVisible(true);
    }//GEN-LAST:event_attend_item5ActionPerformed

    private void report_item6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_report_item6ActionPerformed
        new reports().setVisible(true);
    }//GEN-LAST:event_report_item6ActionPerformed

    private void studentcalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentcalcActionPerformed
         new calc().setVisible(true);
         
    }//GEN-LAST:event_studentcalcActionPerformed

    private void exit_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_itemActionPerformed
       int a=JOptionPane.showConfirmDialog(null,"Sure you want to Exit?","Exit EduAssist",JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION);
       if (a==0)
       {
           System.exit(0);
       }
    }//GEN-LAST:event_exit_itemActionPerformed

    private void btn_staff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_staff1ActionPerformed
       new staff_reg().setVisible(true);
      // btn_staff1.setBackground (new Color (50,250,50));
    }//GEN-LAST:event_btn_staff1ActionPerformed

    private void btnreportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportsActionPerformed
         new reports().setVisible(true);
    }//GEN-LAST:event_btnreportsActionPerformed

    private void report_item7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_report_item7ActionPerformed
        new query().setVisible(true);
    }//GEN-LAST:event_report_item7ActionPerformed

    private void btnr1cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnr1cActionPerformed

        reset1();
    }//GEN-LAST:event_btnr1cActionPerformed

    private void txtsidcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsidcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsidcActionPerformed

    private void txtsidcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsidcKeyPressed

    }//GEN-LAST:event_txtsidcKeyPressed

    private void txtsidcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsidcKeyReleased

        String s1=txtsidc.getText();

        try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            DefaultTableModel tb=(DefaultTableModel)tbquery.getModel();
            tb.setRowCount(0);
            ResultSet rs = db1.getStatement().executeQuery("SELECT std_id,std_name,std_school "
                + " FROM student_info WHERE "
                + "std_id LIKE '%"+s1+"%';");
            while(rs.next())
            {
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);

                Object[] row={d1,d2,d3};

                tb.addRow(row);
            }

            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }//GEN-LAST:event_txtsidcKeyReleased

    private void txtsidc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsidc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsidc1ActionPerformed

    private void txtsidc1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsidc1KeyPressed

    }//GEN-LAST:event_txtsidc1KeyPressed

    private void txtsidc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsidc1KeyReleased

        String s1=txtsidc1.getText();

        try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            DefaultTableModel tb=(DefaultTableModel)tbquery.getModel();
            tb.setRowCount(0);
            ResultSet rs = db1.getStatement().executeQuery("SELECT std_id,std_name,std_school "
                + " FROM student_info WHERE "
                + "std_name LIKE '%"+s1+"%';");
            while(rs.next())
            {
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);

                Object[] row={d1,d2,d3};

                tb.addRow(row);
            }

            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }//GEN-LAST:event_txtsidc1KeyReleased

    private void txtsidc1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsidc1KeyTyped

    }//GEN-LAST:event_txtsidc1KeyTyped

    private void tbqueryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbqueryMouseClicked
        int rval=tbquery.getSelectedRow();
        String rc=(tbquery.getModel()).getValueAt(rval,0).toString();
        if(!("".equals(rc))){
            try{
                databaseCon db1=new databaseCon("root","");
                db1.connect();

                ResultSet rs = db1.getStatement().executeQuery("SELECT * "
                    + " FROM student_info WHERE "
                    + "std_id='"+rc+"';");
                while(rs.next())
                {

                    lblname.setText(rs.getString(2));
                    lblnic.setText(rs.getString(3));
                    lblgen.setText(rs.getString(4));
                    lbladdress.setText(rs.getString(5));
                    lbldob.setText(rs.getString(6));
                    lblage.setText(rs.getString(7));
                    lblschool.setText(rs.getString(8));
                    lblmobile.setText(rs.getString(9));
                    lblhome.setText(rs.getString(10));
                    lblemail.setText(rs.getString(11));
                    lbldatereg.setText(rs.getString(12));
                    lbltype.setText(rs.getString(13));

                }

                db1.disconnect();
            }
            catch(Exception e){
                essentials.infomsgbox("Error",e.toString());
            }
        }
    }//GEN-LAST:event_tbqueryMouseClicked

    private void btnr1c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnr1c1ActionPerformed
        reset2();
    }//GEN-LAST:event_btnr1c1ActionPerformed

    private void txtcidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcidActionPerformed

    private void txtcidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcidKeyPressed

    }//GEN-LAST:event_txtcidKeyPressed

    private void txtcidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcidKeyReleased
        String s1=txtcid.getText();

        try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            DefaultTableModel tb=(DefaultTableModel)tbqueryc.getModel();
            tb.setRowCount(0);
            ResultSet rs = db1.getStatement().executeQuery("SELECT c_id,c_title,lec_id "
                + " FROM course_info WHERE "
                + "c_id LIKE '%"+s1+"%';");
            while(rs.next())
            {
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);

                Object[] row={d1,d2,d3};

                tb.addRow(row);
            }

            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }//GEN-LAST:event_txtcidKeyReleased

    private void txttitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttitleActionPerformed

    private void txttitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttitleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttitleKeyPressed

    private void txttitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttitleKeyReleased
        String s1=txttitle.getText();

        try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            DefaultTableModel tb=(DefaultTableModel)tbqueryc.getModel();
            tb.setRowCount(0);
            ResultSet rs = db1.getStatement().executeQuery("SELECT c_id,c_title,lec_id "
                + " FROM course_info WHERE "
                + "c_title LIKE '%"+s1+"%';");
            while(rs.next())
            {
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);

                Object[] row={d1,d2,d3};

                tb.addRow(row);
            }

            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }//GEN-LAST:event_txttitleKeyReleased

    private void txttitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttitleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txttitleKeyTyped

    private void tbquerycMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbquerycMouseClicked

        int rval=tbqueryc.getSelectedRow();
        String rc=(tbqueryc.getModel()).getValueAt(rval,0).toString();
        if(!("".equals(rc))){
            try{
                databaseCon db1=new databaseCon("root","");
                db1.connect();

                ResultSet rs = db1.getStatement().executeQuery("SELECT * "
                    + " FROM course_info WHERE "
                    + "c_id='"+rc+"';");
                while(rs.next())
                {
                    lbltitle.setText(rs.getString(2));
                    lblduration.setText(rs.getString(3));
                    lbltutor.setText(rs.getString(4));
                    lblclassfee.setText(rs.getString(5));
                    lblregfee.setText(rs.getString(6));
                    lblday.setText(rs.getString(7));
                    lbltime.setText(rs.getString(8));
                    lblcdatereg.setText(rs.getString(10));

                }

                db1.disconnect();
            }
            catch(Exception e){
                essentials.infomsgbox("Error",e.toString());
            }
        }

    }//GEN-LAST:event_tbquerycMouseClicked

    private void btnr1c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnr1c2ActionPerformed
        reset3();
    }//GEN-LAST:event_btnr1c2ActionPerformed

    private void txtstaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstaffActionPerformed

    private void txtstaffKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstaffKeyPressed

    }//GEN-LAST:event_txtstaffKeyPressed

    private void txtstaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstaffKeyReleased
        String s1=txtstaff.getText();

        try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            DefaultTableModel tb=(DefaultTableModel)tbquerys.getModel();
            tb.setRowCount(0);
            ResultSet rs = db1.getStatement().executeQuery("SELECT staff_id,staff_name,staff_dtype "
                + " FROM staff_info WHERE "
                + "staff_id LIKE '%"+s1+"%';");
            while(rs.next())
            {
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);

                Object[] row={d1,d2,d3};

                tb.addRow(row);
            }

            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }//GEN-LAST:event_txtstaffKeyReleased

    private void txtsnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsnameActionPerformed

    private void txtsnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsnameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsnameKeyPressed

    private void txtsnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsnameKeyReleased
        String s1=txtsname.getText();

        try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            DefaultTableModel tb=(DefaultTableModel)tbquerys.getModel();
            tb.setRowCount(0);
            ResultSet rs = db1.getStatement().executeQuery("SELECT staff_id,staff_name,staff_dtype "
                + " FROM staff_info WHERE "
                + "staff_name LIKE '%"+s1+"%';");
            while(rs.next())
            {
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);

                Object[] row={d1,d2,d3};

                tb.addRow(row);
            }

            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }//GEN-LAST:event_txtsnameKeyReleased

    private void txtsnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsnameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsnameKeyTyped

    private void tbquerysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbquerysMouseClicked
        int rval=tbquerys.getSelectedRow();
        String rc=(tbquerys.getModel()).getValueAt(rval,0).toString();
        if(!("".equals(rc))){
            try{
                databaseCon db1=new databaseCon("root","");
                db1.connect();

                ResultSet rs = db1.getStatement().executeQuery("SELECT * "
                    + " FROM staff_info WHERE "
                    + "staff_id='"+rc+"';");
                while(rs.next())
                {
                    lblname2.setText(rs.getString(2));
                    lblnic2.setText(rs.getString(3));
                    lblgen2.setText(rs.getString(4));
                    lbladdress2.setText(rs.getString(5));
                    lbldob2.setText(rs.getString(6));
                    lblage2.setText(rs.getString(7));
                    lbltype2.setText(rs.getString(8));
                    lblmobile2.setText(rs.getString(9));
                    lblhome2.setText(rs.getString(10));
                    lblemail2.setText(rs.getString(11));
                    lbldatereg2.setText(rs.getString(12));
                }

                db1.disconnect();
            }
            catch(Exception e){
                essentials.infomsgbox("Error",e.toString());

            }
        }
    }//GEN-LAST:event_tbquerysMouseClicked

    private void financialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_financialKeyReleased

    }//GEN-LAST:event_financialKeyReleased

    private void btnq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnq2ActionPerformed
      
      
        btnq2.setVisible(false);
        btnq1.setVisible(true);
        panellec.setVisible(true);
       panellec1.setVisible(true);
        QPANEL.setVisible(false);
      
   
    }//GEN-LAST:event_btnq2ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QPANEL;
    private javax.swing.JMenuItem about_item;
    private javax.swing.JMenu actions_menu;
    private javax.swing.JMenuItem adduser_item;
    private javax.swing.JMenuItem attend_item5;
    private javax.swing.JLabel background_img;
    private javax.swing.JButton btn_course;
    private javax.swing.JButton btn_exam;
    private javax.swing.JButton btn_staff1;
    private javax.swing.JButton btn_student;
    private javax.swing.JLabel btn_user;
    private javax.swing.JButton btnattend;
    private javax.swing.JButton btncalc;
    private javax.swing.JButton btnpay;
    private javax.swing.JButton btnq1;
    private javax.swing.JButton btnq2;
    private javax.swing.JButton btnr1c;
    private javax.swing.JButton btnr1c1;
    private javax.swing.JButton btnr1c2;
    private javax.swing.JButton btnreports;
    private javax.swing.JMenuItem course_item2;
    private javax.swing.JMenuItem exam_item3;
    private javax.swing.JMenuItem exit_item;
    private javax.swing.JMenu file_menu;
    private javax.swing.JPanel finance_panel;
    private javax.swing.JPanel financial;
    private javax.swing.JMenuItem help_item;
    private javax.swing.JMenu help_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea lbladdress;
    private javax.swing.JTextArea lbladdress2;
    private javax.swing.JLabel lblage;
    private javax.swing.JLabel lblage2;
    private javax.swing.JLabel lblcdatereg;
    private javax.swing.JLabel lblclassfee;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldatereg;
    private javax.swing.JLabel lbldatereg2;
    private javax.swing.JLabel lblday;
    private javax.swing.JLabel lbldob;
    private javax.swing.JLabel lbldob2;
    private javax.swing.JLabel lblduration;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblemail2;
    private javax.swing.JLabel lblemail3;
    private javax.swing.JLabel lblemail4;
    private javax.swing.JLabel lblemail6;
    private javax.swing.JLabel lblgen;
    private javax.swing.JLabel lblgen2;
    private javax.swing.JLabel lblhome;
    private javax.swing.JLabel lblhome2;
    private javax.swing.JLabel lblmobile;
    private javax.swing.JLabel lblmobile2;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname2;
    private javax.swing.JLabel lblnic;
    private javax.swing.JLabel lblnic2;
    private javax.swing.JLabel lblregfee;
    private javax.swing.JLabel lblschool;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel lbltime2;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lbltutor;
    private javax.swing.JLabel lbltype;
    private javax.swing.JLabel lbltype2;
    private javax.swing.JMenuItem logoff_item;
    private javax.swing.JMenuBar main_menu;
    private javax.swing.JPanel marksheet;
    private javax.swing.JPanel panellec;
    private javax.swing.JPanel panellec1;
    private javax.swing.JMenuItem payment_item4;
    private javax.swing.JPanel payment_panel;
    private javax.swing.JPanel register_panel;
    private javax.swing.JMenuItem report_item6;
    private javax.swing.JMenuItem report_item7;
    private javax.swing.JMenuItem staff_item1;
    private javax.swing.JPanel student;
    private javax.swing.JMenuItem student_item;
    private javax.swing.JMenuItem studentcalc;
    private javax.swing.JTable tbexam;
    private javax.swing.JTable tblec;
    private javax.swing.JTable tbquery;
    private javax.swing.JTable tbqueryc;
    private javax.swing.JTable tbquerys;
    private javax.swing.JTextField txtcid;
    private javax.swing.JTextField txtsidc;
    private javax.swing.JTextField txtsidc1;
    private javax.swing.JTextField txtsname;
    private javax.swing.JTextField txtstaff;
    private javax.swing.JTextField txttitle;
    private javax.swing.JMenu user_menu;
    private javax.swing.JPanel user_panel;
    private javax.swing.JPopupMenu user_popup;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username1;
    // End of variables declaration//GEN-END:variables
}
