/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassasist;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import myclassasist.classpackage.databaseCon;
import myclassasist.classpackage.essentials;
import myclassasist.classpackage.student;


public class student_reg extends javax.swing.JFrame {

    /**
     * Creates new form student_reg
     */
    public student_reg() {
        initComponents();
        refresh();
        refresh2();
        loadCourse();
        reset();
        reset2();
        
        
    }

    
     public void refresh()
    {
           
        try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            
            DefaultTableModel tb=(DefaultTableModel)tbstd.getModel();
             ResultSet rcount = db1.getStatement().executeQuery("SELECT count(std_id) FROM student_info  ;");
            
            rcount.next();
            int n=rcount.getInt(1);
             tb.setRowCount(n); 
            ResultSet rs = db1.getStatement().executeQuery("SELECT * FROM student_info;");
            int i=0;
            
            while(rs.next())
            {
                tb.setValueAt(rs.getString(1),i,0);
                tb.setValueAt(rs.getString(2), i, 1);
                tb.setValueAt(rs.getInt(3), i, 2);
               tb.setValueAt(rs.getString(4), i, 3);
                tb.setValueAt(rs.getString(5), i, 4);
                tb.setValueAt(rs.getDate(6), i, 5);
                tb.setValueAt(rs.getInt(7), i, 6);
               tb.setValueAt(rs.getString(8), i, 7);
                tb.setValueAt(rs.getInt(9), i, 8);
                tb.setValueAt(rs.getInt(10), i, 9);
                tb.setValueAt(rs.getString(11), i, 10);
                tb.setValueAt(rs.getDate(12), i, 11);
                i++;
            } 
          // tb.setRowCount(i);
            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }
    
    public void refresh2()
    {
          
        try{
            databaseCon db1=new databaseCon("root","");
            db1.connect(); 
            
             
            DefaultTableModel tb=(DefaultTableModel)tbstdcourse.getModel();
            ResultSet rcount = db1.getStatement().executeQuery("SELECT count(c_id) FROM std_course  ;");
            
            rcount.next();
            int n=rcount.getInt(1);
             tb.setRowCount(n); 
            
             ResultSet rs = db1.getStatement().executeQuery("SELECT c_id,std_id,datereg,fee_plan FROM std_course ORDER BY std_id ;");
            
           int i=0;
            while(rs.next())
            {
               tb.setValueAt(rs.getString(2),i,0);
               tb.setValueAt(rs.getString(1), i, 1);             
               tb.setValueAt(rs.getDate(3), i, 2); 
               tb.setValueAt(rs.getString(4), i, 3);
                
                i++;
            } 
           // tb.setRowCount(i);
            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }
    
    private void loadCourse()
    {
        
        try{
             DefaultTableModel tb=(DefaultTableModel)tbcourse.getModel(); 
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            ResultSet rs = db1.getStatement().executeQuery("SELECT c_id,c_title FROM course_info;");
            int i=0;
             
            while(rs.next())
            {
                tbcourse.getModel().setValueAt(rs.getString(1),i,0);
                tbcourse.getModel().setValueAt(rs.getString(2), i, 1);
                
                i++;
            } 
           tb.setRowCount(i);
            db1.disconnect();
            
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
    }
    
    public void reset()
    {
       txtsid.setText("");
       txtname.setText("");
       txtaddress.setText("");
       txtmobile.setText("");
       txthome.setText("");
       txtnic.setText("");
       txtmail.setText("");
       comdob.setCurrent(essentials.getCal());
       comtype.setSelectedIndex(0);
       comgen.setSelectedIndex(0);
       txtschool.setText("");
       txtsid.requestFocus();
       txtsid.setEditable(true);
       comdob.setEnabled(true);
       btndel.setEnabled(false);
       btnup.setEnabled(false);
       
        
    }
    
    public void reset2()
    {
        txtstid.setText("");
        txtcid.setText("");
        txtstid.requestFocus();
        lblname.setText("");
                lblnic.setText("");
                lblmobileno.setText("");
                lblhomeno.setText("");
                lblemail.setText("");
                lblcourse.setText("");
                lbllecfee.setText("");
                lbllec.setText("");
                lbldays.setText("");
                lblfee.setText("");
                lblduration.setText("");
                btnpay.setEnabled(true);
                txtstid.setEditable(true);
                txtcid.setEditable(true);
                txtstid.setEnabled(true);
                txtcid.setEnabled(true);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        btndb = new javax.swing.ButtonGroup();
        feeplan = new javax.swing.ButtonGroup();
        REGISTRATION = new javax.swing.JTabbedPane();
        details_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();
        txthome = new javax.swing.JTextField();
        scrolladdress = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        comgen = new javax.swing.JComboBox();
        txtname = new javax.swing.JTextField();
        txtnic = new javax.swing.JTextField();
        txtsid = new javax.swing.JTextField();
        txtmail = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btndel = new javax.swing.JButton();
        btnup = new javax.swing.JButton();
        btnref = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbstd = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        txtschool = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        comdob = new datechooser.beans.DateChooserCombo();
        jLabel27 = new javax.swing.JLabel();
        comtype = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        COURSES = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtstid = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblnic = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblmobileno = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblhomeno = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtcid = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblcourse = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbldays = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblfee = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblduration = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbllec = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbllecfee = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbstdcourse = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbcourse = new javax.swing.JTable();
        btnreset2 = new javax.swing.JButton();
        btnup2 = new javax.swing.JButton();
        btndel2 = new javax.swing.JButton();
        btnsave2 = new javax.swing.JButton();
        btnpay = new javax.swing.JButton();
        rbtnnormal = new javax.swing.JRadioButton();
        rbtnhalf = new javax.swing.JRadioButton();
        rbtnfree = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        back_up = new javax.swing.JLabel();

        setTitle("EduAsist v1.0 - Student Management");
        setPreferredSize(new java.awt.Dimension(980, 780));
        setResizable(false);
        getContentPane().setLayout(null);

        REGISTRATION.setBackground(new java.awt.Color(255, 255, 255));
        REGISTRATION.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        REGISTRATION.setPreferredSize(new java.awt.Dimension(980, 750));

        details_panel.setOpaque(false);
        details_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Student ID");
        details_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 25, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Full Name");
        details_panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 69, 91, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Gender");
        details_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 57, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Address");
        details_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 114, 81, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Home_No");
        details_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 253, -1, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Mobile_No");
        details_panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 253, 91, 30));

        txtmobile.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtmobile.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtmobile.setToolTipText("");
        txtmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobileActionPerformed(evt);
            }
        });
        details_panel.add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 253, 144, 31));

        txthome.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txthome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txthome.setToolTipText("");
        txthome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthomeActionPerformed(evt);
            }
        });
        details_panel.add(txthome, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 253, 149, 31));

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtaddress.setRows(5);
        scrolladdress.setViewportView(txtaddress);

        details_panel.add(scrolladdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 114, 397, 127));

        comgen.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comgen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        comgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comgenActionPerformed(evt);
            }
        });
        details_panel.add(comgen, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 180, 36));

        txtname.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        details_panel.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 70, 397, 30));

        txtnic.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnicActionPerformed(evt);
            }
        });
        details_panel.add(txtnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 180, 30));

        txtsid.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtsid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsidActionPerformed(evt);
            }
        });
        txtsid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsidKeyPressed(evt);
            }
        });
        details_panel.add(txtsid, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 26, 151, 30));

        txtmail.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtmail.setToolTipText("");
        txtmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmailActionPerformed(evt);
            }
        });
        details_panel.add(txtmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 260, 31));

        btnsave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/register.png"))); // NOI18N
        btnsave.setText("REGISTER");
        btndb.add(btnsave);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        details_panel.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 160, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("NIC No");
        details_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 57, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("V");
        details_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 25, -1));

        btndel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btndel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/delete.png"))); // NOI18N
        btndel.setText("DELETE");
        btndb.add(btndel);
        btndel.setEnabled(false);
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });
        details_panel.add(btndel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, 126, 38));

        btnup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/update.png"))); // NOI18N
        btnup.setText("UPDATE");
        btndb.add(btnup);
        btnup.setEnabled(false);
        btnup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupActionPerformed(evt);
            }
        });
        details_panel.add(btnup, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 126, 38));

        btnref.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnref.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/reset.png"))); // NOI18N
        btnref.setText("REFRESH");
        btndb.add(btnref);
        btnref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefActionPerformed(evt);
            }
        });
        details_panel.add(btnref, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 126, 38));

        btnclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/clear.png"))); // NOI18N
        btnclear.setText("CLEAR");
        btndb.add(btnclear);
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        details_panel.add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 126, 38));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("E-mail");
        details_panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 57, 30));

        tbstd.setAutoCreateRowSorter(true);
        tbstd.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tbstd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Full Name", "NIC", "Gender", "Address", "DOB", "Age", "School", "Mobile_No", "Home_No", "E - mail", "Date_registered"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbstd.setColumnSelectionAllowed(true);
        tbstd.setOpaque(false);
        tbstd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbstdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbstd);

        details_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 306, 920, 202));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("DOB");
        details_panel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 57, 30));

        txtschool.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtschool.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtschool.setToolTipText("");
        txtschool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtschoolActionPerformed(evt);
            }
        });
        details_panel.add(txtschool, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 260, 31));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("School");
        details_panel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 57, 30));

        comdob.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
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
    comdob.setFieldFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 15));
    comdob.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.PLAIN, 11));
    comdob.setCurrentNavigateIndex(0);
    details_panel.add(comdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 180, 36));

    jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel27.setForeground(new java.awt.Color(0, 0, 51));
    jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel27.setText("Type :");
    details_panel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 25, 51, 30));

    comtype.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    comtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Primary", "Grade 6-9", "G C E O/L", "G C E A/L" }));
    comtype.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            comtypeActionPerformed(evt);
        }
    });
    details_panel.add(comtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 22, 170, 36));

    jLabel31.setBackground(new java.awt.Color(0, 102, 102));
    jLabel31.setOpaque(true);
    details_panel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 990, 110));

    REGISTRATION.addTab("REGISTRATION", details_panel);

    COURSES.setOpaque(false);
    COURSES.setLayout(null);

    jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(0, 0, 51));
    jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel11.setText("Student ID");
    COURSES.add(jLabel11);
    jLabel11.setBounds(12, 24, 97, 30);

    txtstid.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    txtstid.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            txtstidFocusGained(evt);
        }
    });
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
    COURSES.add(txtstid);
    txtstid.setBounds(121, 25, 175, 30);

    jPanel2.setBackground(new java.awt.Color(204, 204, 204));
    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(0, 0, 51));
    jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel12.setText("Name :");

    lblnic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblnic.setForeground(new java.awt.Color(51, 51, 51));
    lblnic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

    jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(51, 51, 51));
    jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel13.setText("V");

    jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(0, 0, 51));
    jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel14.setText("NIC :");

    jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(0, 0, 51));
    jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel15.setText("Mobile_no :");

    lblmobileno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblmobileno.setForeground(new java.awt.Color(51, 51, 51));
    lblmobileno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(0, 0, 51));
    jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel16.setText("Home_no :");

    lblhomeno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblhomeno.setForeground(new java.awt.Color(51, 51, 51));
    lblhomeno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel17.setForeground(new java.awt.Color(0, 0, 51));
    jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel17.setText("E-mail :-");

    lblemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblemail.setForeground(new java.awt.Color(51, 51, 51));
    lblemail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    lblname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblname.setForeground(new java.awt.Color(51, 51, 51));
    lblname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblmobileno, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGap(48, 48, 48)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblhomeno, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblnic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)
                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(71, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblnic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblhomeno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmobileno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLabel12.getAccessibleContext().setAccessibleName("nAME :");

    COURSES.add(jPanel2);
    jPanel2.setBounds(10, 70, 940, 80);

    jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel18.setForeground(new java.awt.Color(0, 0, 51));
    jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel18.setText("Course ID");
    COURSES.add(jLabel18);
    jLabel18.setBounds(10, 190, 97, 30);

    txtcid.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    txtcid.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtcidActionPerformed(evt);
        }
    });
    txtcid.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txtcidKeyPressed(evt);
        }
    });
    COURSES.add(txtcid);
    txtcid.setBounds(120, 190, 175, 30);

    jPanel3.setBackground(new java.awt.Color(204, 204, 204));
    jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel19.setForeground(new java.awt.Color(0, 0, 51));
    jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel19.setText("Course :");

    lblcourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblcourse.setForeground(new java.awt.Color(51, 51, 51));
    lblcourse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel22.setForeground(new java.awt.Color(0, 0, 51));
    jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel22.setText("Days :");

    lbldays.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lbldays.setForeground(new java.awt.Color(51, 51, 51));
    lbldays.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel23.setForeground(new java.awt.Color(0, 0, 51));
    jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel23.setText("Course Fee(Rs)   :");

    lblfee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblfee.setForeground(new java.awt.Color(51, 51, 51));
    lblfee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel24.setForeground(new java.awt.Color(0, 0, 51));
    jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel24.setText("Duration :");

    lblduration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblduration.setForeground(new java.awt.Color(51, 51, 51));
    lblduration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel25.setForeground(new java.awt.Color(0, 0, 51));
    jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel25.setText("Tutor       :");

    lbllec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lbllec.setForeground(new java.awt.Color(51, 51, 51));
    lbllec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel28.setForeground(new java.awt.Color(0, 0, 51));
    jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel28.setText("Registration(Rs) :");

    lbllecfee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lbllecfee.setForeground(new java.awt.Color(51, 51, 51));
    lbllecfee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(lbldays, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(lblfee, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(lblcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(lbllecfee, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblduration, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbllec, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(106, 106, 106))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbllecfee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbllec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblfee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldays, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblduration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    COURSES.add(jPanel3);
    jPanel3.setBounds(10, 230, 940, 86);

    tbstdcourse.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    tbstdcourse.setModel(new javax.swing.table.DefaultTableModel(
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
            {null, null, null, null}
        },
        new String [] {
            "Student ID", "Course ID", "Date Registered", "Fee_plan"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
    tbstdcourse.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbstdcourseMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(tbstdcourse);

    COURSES.add(jScrollPane2);
    jScrollPane2.setBounds(400, 340, 550, 166);

    tbcourse.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    tbcourse.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        },
        new String [] {
            "Course ID", "Course Title"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean [] {
            false, false
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane3.setViewportView(tbcourse);

    COURSES.add(jScrollPane3);
    jScrollPane3.setBounds(10, 340, 380, 166);

    btnreset2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    btnreset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/refresh.png"))); // NOI18N
    btnreset2.setText("RESET");
    btnreset2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnreset2ActionPerformed(evt);
        }
    });
    COURSES.add(btnreset2);
    btnreset2.setBounds(510, 560, 120, 36);

    btnup2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    btnup2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/update.png"))); // NOI18N
    btnup2.setText("EDIT ");
    btnup2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnup2ActionPerformed(evt);
        }
    });
    COURSES.add(btnup2);
    btnup2.setBounds(380, 560, 120, 36);

    btndel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    btndel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/delete.png"))); // NOI18N
    btndel2.setText("REMOVE ");
    btndel2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btndel2ActionPerformed(evt);
        }
    });
    COURSES.add(btndel2);
    btndel2.setBounds(240, 560, 130, 36);

    btnsave2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    btnsave2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/create.png"))); // NOI18N
    btnsave2.setText("UPDATE");
    btnsave2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnsave2ActionPerformed(evt);
        }
    });
    COURSES.add(btnsave2);
    btnsave2.setBounds(640, 560, 140, 36);

    btnpay.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    btnpay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/Project_res/payment.png"))); // NOI18N
    btnpay.setText("PAYMENTS");
    btnpay.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnpayActionPerformed(evt);
        }
    });
    COURSES.add(btnpay);
    btnpay.setBounds(790, 550, 160, 50);

    feeplan.add(rbtnnormal);
    rbtnnormal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    rbtnnormal.setForeground(new java.awt.Color(0, 0, 0));
    rbtnnormal.setSelected(true);
    rbtnnormal.setText("Full Fee");
    COURSES.add(rbtnnormal);
    rbtnnormal.setBounds(420, 190, 101, 31);

    feeplan.add(rbtnhalf);
    rbtnhalf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    rbtnhalf.setForeground(new java.awt.Color(0, 0, 0));
    rbtnhalf.setText("Half Free");
    COURSES.add(rbtnhalf);
    rbtnhalf.setBounds(530, 190, 115, 31);

    feeplan.add(rbtnfree);
    rbtnfree.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    rbtnfree.setForeground(new java.awt.Color(0, 0, 0));
    rbtnfree.setText("FRee Card");
    rbtnfree.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rbtnfreeActionPerformed(evt);
        }
    });
    COURSES.add(rbtnfree);
    rbtnfree.setBounds(640, 190, 119, 31);

    jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel26.setForeground(new java.awt.Color(0, 0, 51));
    jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel26.setText("Fee Plan :");
    COURSES.add(jLabel26);
    jLabel26.setBounds(320, 190, 81, 30);

    jLabel29.setBackground(new java.awt.Color(0, 102, 102));
    jLabel29.setOpaque(true);
    COURSES.add(jLabel29);
    jLabel29.setBounds(0, 530, 990, 110);

    REGISTRATION.addTab("COURSES", COURSES);

    getContentPane().add(REGISTRATION);
    REGISTRATION.setBounds(0, 90, 980, 750);
    getContentPane().add(jSeparator1);
    jSeparator1.setBounds(0, 130, 990, 10);

    title.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
    title.setForeground(new java.awt.Color(51, 0, 51));
    title.setText("Student Management");
    getContentPane().add(title);
    title.setBounds(520, 30, 439, 80);

    back_up.setBackground(new java.awt.Color(255, 255, 255));
    back_up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myclassasist/calm-35843-36659-hd-wallpapers.jpg"))); // NOI18N
    getContentPane().add(back_up);
    back_up.setBounds(0, 0, 990, 120);

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobileActionPerformed

    private void txthomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthomeActionPerformed

    private void comgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comgenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comgenActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnicActionPerformed

    private void txtsidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsidActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        try{
             databaseCon dbadd = new databaseCon("root","");
             
             
             String s1 =txtsid.getText();
             String s2 =txtname.getText();
             int s3 = Integer.parseInt(txtnic.getText());
             String s4=(String) comgen.getSelectedItem();
             String s5= txtaddress.getText();
             Calendar d1=comdob.getSelectedDate();
             java.sql.Date dob=new java.sql.Date(d1.getInstance().getTimeInMillis());
             int s6 = essentials.getYearIndex()-d1.get(Calendar.YEAR);
             String s7= txtschool.getText();
             int s8 = Integer.parseInt(txtmobile.getText());      
             int s9 = Integer.parseInt(txthome.getText()); 
             String s10= txtmail.getText();
             java.sql.Date reg=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
             String s11= (String)comtype.getSelectedItem();
             
             dbadd.connect();
             
             student std=new student(s1,s2,s3,s4,s5,dob,s7,s8,s9,s10);
             String saveq="INSERT INTO student_info VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
             dbadd.pStatement(saveq);
             
               dbadd.getPs().setString(1,std.getId());
               dbadd.getPs().setString(2,std.getName());
               dbadd.getPs().setInt(3, std.getNic());
               dbadd.getPs().setString(4, std.getgender());
               dbadd.getPs().setString(5,std.getAddress());
               dbadd.getPs().setDate(6, dob);
               dbadd.getPs().setInt(7,s6);
               dbadd.getPs().setString(8, std.getSchool());
               dbadd.getPs().setInt(9, std.getMobileno());
               dbadd.getPs().setInt(10, std.getHomeno());
               dbadd.getPs().setString(11,  std.getEmail());
               dbadd.getPs().setDate(12, reg);
               dbadd.getPs().setString(13, s11);
             
               
               dbadd.getPs().execute();
               
              
   
             dbadd.disconnect();
               txtstid.setText(txtsid.getText()); 

              refresh();
              reset();
               essentials.infomsgbox("Success","Data added Successfully!");
             
         } 
         catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
        txtstid.requestFocus();
 
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
       try{
        databaseCon dbadd = new databaseCon("root","");
        String s1=txtsid.getText();
       
             dbadd.connect();
             
             
             
             String delq=("DELETE FROM student_info WHERE std_id='"+s1+"';");
             dbadd.pStatement(delq);
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
           
             String s1=txtsid.getText();
             String s2 =txtname.getText();
             int s3 = Integer.parseInt(txtnic.getText());
             String s4=(String) comgen.getSelectedItem();
             String s5= txtaddress.getText();
             String s7= txtschool.getText();
             int s8 = Integer.parseInt(txtmobile.getText());      
             int s9 = Integer.parseInt(txthome.getText()); 
             String s10= txtmail.getText();
             String s11=(String) comtype.getSelectedItem();
             
             dbup.connect();
             
             String upq=("UPDATE student_info SET  std_name=?, std_nic=?,std_gender=?,std_address=?,std_school=?,std_mobileno=?,std_homeno=?,std_email=?,stype=? WHERE std_id='"+s1+"' ;");
             dbup.pStatement(upq);
             
             
             dbup.getPs().setString(1,s2);
               dbup.getPs().setInt(2, s3);
               dbup.getPs().setString(3, s4);
               dbup.getPs().setString(4, s5);
               dbup.getPs().setString(5, s7);
               dbup.getPs().setInt(6, s8);
               dbup.getPs().setInt(7, s9);
               dbup.getPs().setString(8,  s10);
               dbup.getPs().setString(9,s11);
               dbup.getPs().executeUpdate();
               
               
   
             dbup.disconnect();
            txtstid.setText(txtsid.getText()); 

            refresh();
            reset();
         
            essentials.infomsgbox("Success","Data Updated Successfully!");
         } 
         catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
          txtstid.requestFocus();
    }//GEN-LAST:event_btnupActionPerformed

    private void btnrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefActionPerformed
            refresh();
            reset();
           
    }//GEN-LAST:event_btnrefActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
            reset();
            
    }//GEN-LAST:event_btnclearActionPerformed

    private void tbstdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbstdMouseClicked
     int row=tbstd.getSelectedRow();
            String rc=(tbstd.getModel()).getValueAt(row,0).toString();
            if(!"".equals(rc)){
        try{
       
           databaseCon db2 = new databaseCon("root","");
        
             db2.connect();
             
            
                
           
            String selque="SELECT * FROM student_info WHERE std_id='"+rc+"';";
            
            ResultSet rs = db2.getStatement().executeQuery(selque);
            
            
            while(rs.next())
            {
                txtsid.setText(rs.getString(1));
                txtname.setText(rs.getString(2));
                txtnic.setText(rs.getString(3));
                comgen.setSelectedItem(rs.getString(4));
                txtaddress.setText(rs.getString(5));
                comdob.setCurrent(essentials.getCal());
                txtschool.setText(rs.getString(8));
                txtmobile.setText(rs.getString(9));
                txthome.setText(rs.getString(10));
                txtmail.setText(rs.getString(11));               
                comtype.setSelectedItem(rs.getString(13));
            
              
            }  
            
            comdob.setEnabled(false);
            txtsid.setEditable(false);
            btndel.setEnabled(true);
            btnup.setEnabled(true);
             

             db2.disconnect();
             
      }
      catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
      }       
  }    
    
    }//GEN-LAST:event_tbstdMouseClicked

    private void txtmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailActionPerformed

    private void txtstidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstidActionPerformed

    private void txtcidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcidActionPerformed

    private void txtschoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtschoolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtschoolActionPerformed

    private void comtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comtypeActionPerformed

    private void btnpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayActionPerformed

        String status ="pay";
        String sid=txtstid.getText();
        String fee=lbllecfee.getText();
        String CID=txtcid.getText();
          reset2();
        payment p1=new payment(status,sid,fee,CID);
        p1.setVisible(true);
             
    }//GEN-LAST:event_btnpayActionPerformed

    private void txtstidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstidKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            refresh2();
            String s1=txtstid.getText();
            
            try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            
            ResultSet rs = db1.getStatement().executeQuery("SELECT std_name,stD_nic,std_mobileno,std_homeno,std_email FROM student_info WHERE "
                    + "std_id='"+s1+"';");
           
            while(rs.next())
            {
                lblname.setText(rs.getString(1));
                lblnic.setText(rs.getString(2));
                lblmobileno.setText(rs.getString(3));
                lblhomeno.setText(rs.getString(4));
                lblemail.setText(rs.getString(5));
            } 
            
            txtcid.requestFocus();
            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
        }
    }//GEN-LAST:event_txtstidKeyPressed

    private void txtcidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcidKeyPressed
          if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
           
            String s1=txtcid.getText();
            
            try{
            databaseCon db1=new databaseCon("root","");
            db1.connect();
            
            ResultSet rs = db1.getStatement().executeQuery("SELECT c_title,c_lecfee,lec_id,c_day,"
                    + "c_fee,c_duration FROM course_info WHERE "
                    + "c_id='"+s1+"';");
           
            while(rs.next())
            {
                lblcourse.setText(rs.getString(1));
                lbllecfee.setText(rs.getString(2));
                lbllec.setText(rs.getString(3));
                lbldays.setText(rs.getString(4));
                lblfee.setText(rs.getString(5));
                lblduration.setText(rs.getString(6));
            } 
            
            rbtnnormal.isSelected();
            db1.disconnect();
        }
        catch(Exception e){
            essentials.infomsgbox("Error",e.toString());
        }
        }
    }//GEN-LAST:event_txtcidKeyPressed

    private void btnreset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset2ActionPerformed
       reset2();
       txtstid.setEnabled(true);
    }//GEN-LAST:event_btnreset2ActionPerformed

    private void btnsave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave2ActionPerformed
        try{
             databaseCon dbadd = new databaseCon("root","");
             
             String s1 =txtstid.getText(),s3="";
          
             String s4=txtcid.getText();
  
            java.sql.Date reg=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            if(rbtnnormal.isSelected()==true)
            { s3 = "Full";
            btnpay.setEnabled(true);}
            else if(rbtnhalf.isSelected()==true)
            { s3 = "Half";
                 btnpay.setEnabled(true);
            }
            else if(rbtnfree.isSelected()==true)
            { s3 = "Free";
              btnpay.setEnabled(false);
            }
             
             dbadd.connect();
             
             String saveq="INSERT INTO std_course VALUES(?,?,?,?);";
             dbadd.pStatement(saveq);
             
               dbadd.getPs().setString(1,s4);
               dbadd.getPs().setString(2,s1);
               dbadd.getPs().setDate(3,reg);
               dbadd.getPs().setString(4,s3);
               
               dbadd.getPs().execute();
                
                String saveq2="INSERT INTO std_attendnce VALUES(?,?,?,?,?);";
             dbadd.pStatement(saveq2);
             
               dbadd.getPs().setString(1,s1);
               dbadd.getPs().setString(2,s4);
               dbadd.getPs().setInt(3, 0);
               dbadd.getPs().setInt(4, Integer.parseInt(lblduration.getText()));
               dbadd.getPs().setString(5,"Not Paid");
               
               dbadd.getPs().execute();
            
             dbadd.disconnect();
             
             
           
               essentials.infomsgbox("Success","Data added Successfully!");
             
         } 
         catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
           refresh2();
              
    }//GEN-LAST:event_btnsave2ActionPerformed

    private void rbtnfreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnfreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnfreeActionPerformed

    private void btndel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndel2ActionPerformed
       try{
        databaseCon dbadd = new databaseCon("root","");
        String s1=txtstid.getText();
        String s2 =txtcid.getText();
             dbadd.connect();
           
             String delq=("DELETE FROM std_course WHERE std_id='"+s1+"' AND c_id='"+s2+"';");
             dbadd.pStatement(delq);
             dbadd.getPs().executeUpdate();
             
              dbadd.disconnect();
              
             
              refresh2();
              reset2();
              essentials.infomsgbox("Success","Data deleted Successfully!");
      }
      
      catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
 
    }//GEN-LAST:event_btndel2ActionPerformed

    private void btnup2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnup2ActionPerformed
        try{
             databaseCon dbadd = new databaseCon("root","");
             
             String s1 =txtstid.getText();
             String s2 =txtcid.getText(),s3="";
            
            if(rbtnnormal.isSelected()==true)
            { s3 = "Full";
            btnpay.setEnabled(true);}
            else if(rbtnhalf.isSelected()==true)
            { s3 = "Half";
            btnpay.setEnabled(true);}
            else if(rbtnfree.isSelected()==true)
            { s3 = "Free";
              btnpay.setEnabled(false);
            }
             
             dbadd.connect();
             
             String saveq=("UPDATE std_course SET fee_plan=? WHERE std_id='"+s1+"' AND c_id='"+s2+"';");
             dbadd.pStatement(saveq);
       
               dbadd.getPs().setString(1,s3);
                
               dbadd.getPs().execute();
            
             dbadd.disconnect();
        
              refresh2();
              reset2();
               essentials.infomsgbox("Success","Data updated Successfully!");
             
         } 
         catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
        }
    }//GEN-LAST:event_btnup2ActionPerformed

    private void tbstdcourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbstdcourseMouseClicked
          int row=tbstdcourse.getSelectedRow();
            String rc=(tbstdcourse.getModel()).getValueAt(row,0).toString();
             String rc2=(tbstdcourse.getModel()).getValueAt(row,1).toString();
            if(!"".equals(rc)){
        try{
       
           databaseCon db2 = new databaseCon("root","");
        
             db2.connect();
        
            String selque="SELECT std_id,c_id,fee_plan FROM std_course WHERE std_id='"+rc+"' AND c_id = '" +rc2+"';";
            
            ResultSet rs = db2.getStatement().executeQuery(selque);
         
            while(rs.next())
            {
                txtstid.setText(rs.getString(1));
                txtcid.setText(rs.getString(2));
                String s3=rs.getString(3);
                 if("Full".equals(s3))
                 {
                     rbtnnormal.isSelected();
                     btnpay.setEnabled(true);
                 }  
                 if("Half".equals(s3))
                 {
                     rbtnhalf.isSelected();
                     btnpay.setEnabled(true);
                 }  
                 if("Free".equals(s3))
                 {
                     rbtnfree.isSelected();
                     btnpay.setEnabled(false);
                 }  
             
            
            }  
 
            txtstid.setEditable(false);
            txtcid.setEditable(false);
            btndel.setEnabled(true);
            btnup.setEnabled(true);
             

             db2.disconnect();
             
      }
      catch(Exception e){
              essentials.infomsgbox("Error",e.toString());
      }       
            }
    }//GEN-LAST:event_tbstdcourseMouseClicked

    private void txtstidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtstidFocusGained
           

    }//GEN-LAST:event_txtstidFocusGained

    private void txtsidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsidKeyPressed
     
    }//GEN-LAST:event_txtsidKeyPressed

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
            java.util.logging.Logger.getLogger(student_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student_reg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel COURSES;
    private javax.swing.JTabbedPane REGISTRATION;
    private javax.swing.JLabel back_up;
    private javax.swing.JButton btnclear;
    private javax.swing.ButtonGroup btndb;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btndel2;
    private javax.swing.JButton btnpay;
    private javax.swing.JButton btnref;
    private javax.swing.JButton btnreset2;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsave2;
    private javax.swing.JButton btnup;
    private javax.swing.JButton btnup2;
    private datechooser.beans.DateChooserCombo comdob;
    private javax.swing.JComboBox comgen;
    private javax.swing.JComboBox comtype;
    private javax.swing.JPanel details_panel;
    private javax.swing.ButtonGroup feeplan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblcourse;
    private javax.swing.JLabel lbldays;
    private javax.swing.JLabel lblduration;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfee;
    private javax.swing.JLabel lblhomeno;
    private javax.swing.JLabel lbllec;
    private javax.swing.JLabel lbllecfee;
    private javax.swing.JLabel lblmobileno;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblnic;
    private javax.swing.JRadioButton rbtnfree;
    private javax.swing.JRadioButton rbtnhalf;
    private javax.swing.JRadioButton rbtnnormal;
    private javax.swing.JScrollPane scrolladdress;
    private javax.swing.JTable tbcourse;
    private javax.swing.JTable tbstd;
    private javax.swing.JTable tbstdcourse;
    private javax.swing.JLabel title;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtcid;
    private javax.swing.JTextField txthome;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnic;
    private javax.swing.JTextField txtschool;
    private javax.swing.JTextField txtsid;
    private javax.swing.JTextField txtstid;
    // End of variables declaration//GEN-END:variables
}
