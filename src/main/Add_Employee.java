
package main;

import connect.ConnectToSQL;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.Login;
import model.EmployeeService;
import model.Employee;


public class Add_Employee extends javax.swing.JFrame {

    /**
     * Creates new form Add_employee
     */
    public Add_Employee() {
        initComponents();
        this.setLocationRelativeTo(null);
           
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_birth = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_Salary = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        btn_add = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_view = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_employee = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(996, 615));

        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/employees.png"))); // NOI18N
        jLabel10.setText("Add Employee");

        jButton5.setBackground(new java.awt.Color(255, 102, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-out.png"))); // NOI18N
        jButton5.setText("Log out");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 604, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 990, 50);

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        jLabel1.setText("Employee ID:");

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel2.setText("Employee Department");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giám đốc", "Trưởng phòng", "Quản lý", "Nhân viên", "Bảo vệ", "Thực tập sinh", "Kế toán", "Thư ký", " " }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel3.setText("Name of Employee");

        jLabel4.setText("Date Of Birth");

        jLabel5.setText("Phone Number");

        jLabel6.setText("Email");

        jLabel7.setText("Employee Salary");

        jLabel8.setText("Address");

        jLabel9.setText("Gender");

        jCheckBox1.setText("Male");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Female");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(0, 51, 51));
        btn_add.setForeground(new java.awt.Color(204, 204, 204));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_back.setBackground(new java.awt.Color(0, 51, 51));
        btn_back.setForeground(new java.awt.Color(204, 204, 204));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_remove.setBackground(new java.awt.Color(0, 51, 51));
        btn_remove.setForeground(new java.awt.Color(204, 204, 204));
        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(0, 51, 51));
        btn_update.setForeground(new java.awt.Color(204, 204, 204));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_view.setBackground(new java.awt.Color(0, 51, 51));
        btn_view.setForeground(new java.awt.Color(204, 204, 204));
        btn_view.setText("View");
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_address)
                    .addComponent(txt_Salary)
                    .addComponent(txt_email)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_name)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_birth, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_remove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(btn_clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_birth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_remove)
                    .addComponent(btn_update)
                    .addComponent(btn_view))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_back)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1);
        jPanel1.setBounds(0, 50, 310, 530);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(690, 500));

        jTable_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Apartment", "Name", "Date", "Phone number", "Email", "Basic salary", "Address", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_employeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_employee);
        if (jTable_employee.getColumnModel().getColumnCount() > 0) {
            jTable_employee.getColumnModel().getColumn(0).setResizable(false);
            jTable_employee.getColumnModel().getColumn(1).setResizable(false);
            jTable_employee.getColumnModel().getColumn(2).setResizable(false);
            jTable_employee.getColumnModel().getColumn(3).setResizable(false);
            jTable_employee.getColumnModel().getColumn(4).setResizable(false);
            jTable_employee.getColumnModel().getColumn(5).setResizable(false);
            jTable_employee.getColumnModel().getColumn(6).setResizable(false);
            jTable_employee.getColumnModel().getColumn(7).setResizable(false);
            jTable_employee.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2);
        jPanel2.setBounds(310, 60, 690, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
     
        String employeeName = txt_name.getText();
        String employeeID = txt_id.getText();
        String position = jComboBox1.getSelectedItem().toString();
        String salary = txt_Salary.getText();
        String date_birth = txt_birth.getText();
        String phone = txt_phone.getText();
        String email = txt_email.getText();
        String address = txt_address.getText();

        boolean valid = true;
        StringBuilder errorMessage = new StringBuilder("Vui lòng nhập đầy đủ thông tin:\n");

        // Kiểm tra thông tin hợp lệ (ví dụ: không để trống)
        if (employeeName.isEmpty()) {
            txt_name.setBackground(Color.PINK);
            errorMessage.append("- Tên nhân viên\n");
            valid = false;
        }
        if (employeeID.isEmpty()) {
            txt_id.setBackground(Color.PINK);
            errorMessage.append("- Mã nhân viên\n");
            valid = false;
        }
        if (salary.isEmpty()) {
            txt_Salary.setBackground(Color.PINK);
            errorMessage.append("- Mức lương\n");
            valid = false;
        }
        if (date_birth.isEmpty()) {
            txt_birth.setBackground(Color.PINK);
            errorMessage.append("- Ngày sinh\n");
            valid = false;
        }
        if (phone.isEmpty()) {
            txt_phone.setBackground(Color.PINK);
            errorMessage.append("- Số điện thoại\n");
            valid = false;
        }
        if (email.isEmpty()) {
            txt_email.setBackground(Color.PINK);
            errorMessage.append("- Email\n");
            valid = false;
        }
        if (address.isEmpty()) {
            txt_address.setBackground(Color.PINK);
            valid = false;
            errorMessage.append("- Địa chỉ\n");
        }
        // Kiểm tra giới tính
        String gender = "";
        if (jCheckBox1.isSelected()) {
            gender = "Male";
        } else if (jCheckBox2.isSelected()) {
            gender = "Female";
        } else {
            errorMessage.append("- Giới tính\n");
            valid = false;
        }
        // Nếu thông tin hợp lệ thì thực hiện thêm nhân viên
        if (valid) {
            // Kiểm tra nếu nhân viên đã tồn tại
            if (EmployeeService.employeeExists(employeeID)) {
                JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // Thử chuyển đổi ngày sinh từ String sang java.sql.Date với các định dạng
                    java.sql.Date sqlDate = null;
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");

                    boolean isDateValid = false;

                    // Thử định dạng "dd/MM/yyyy"
                    try {
                        sdf1.setLenient(false); // Đảm bảo kiểm tra tính hợp lệ của ngày
                        java.util.Date date = sdf1.parse(date_birth);
                        sqlDate = new java.sql.Date(date.getTime());
                        isDateValid = true;
                    } catch (Exception ignored) {
                        // Nếu không hợp lệ, thử định dạng khác
                    }

                    // Thử định dạng "dd-MM-yyyy"
                    if (!isDateValid) {
                        try {
                            sdf2.setLenient(false); // Đảm bảo kiểm tra tính hợp lệ của ngày
                            java.util.Date date = sdf2.parse(date_birth);
                            sqlDate = new java.sql.Date(date.getTime());
                            isDateValid = true;
                        } catch (Exception ignored) {
                            // Nếu không hợp lệ, xử lý bên dưới
                        }
                    }

                    // Nếu cả hai định dạng đều không hợp lệ, thông báo lỗi
                    if (!isDateValid) {
                        throw new IllegalArgumentException("Định dạng ngày không hợp lệ. Vui lòng nhập ngày theo định dạng dd/MM/yyyy hoặc dd-MM-yyyy.");
                    }

                    // Nếu hợp lệ, gọi phương thức thêm nhân viên
                    EmployeeService.addEmployee(employeeID, position, employeeName, sqlDate, phone, email, salary, address, "Male");
                    
                     // Thêm dữ liệu mới vào bảng jTable_employee
                    DefaultTableModel model = (DefaultTableModel) jTable_employee.getModel();
                    model.addRow(new Object[]{
                        employeeID,
                        position,
                        employeeName,
                        sqlDate,
                        phone,
                        email,
                        salary,
                        address,
                        "Male"
                    });
                
                    // Thông báo thành công
                    JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

                    // Xóa các trường nhập liệu
                    clearForm();
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi thêm nhân viên: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        txt_name.setBackground(Color.WHITE);
        txt_id.setBackground(Color.WHITE);
        txt_Salary.setBackground(Color.WHITE);
        txt_birth.setBackground(Color.WHITE);
        txt_phone.setBackground(Color.WHITE);
        txt_email.setBackground(Color.WHITE);
        txt_address.setBackground(Color.WHITE);
        clearForm();
}//GEN-LAST:event_btn_addActionPerformed
    
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // Lấy giá trị ID nhân viên từ trường nhập liệu
        String employeeID = txt_id.getText().trim();

        // Kiểm tra nếu ID nhân viên bị trống
        if (employeeID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ID nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt_id.setBackground(Color.PINK); // Đổi màu nền của ô ID thành màu hồng
            return;
        } else {
            txt_id.setBackground(Color.WHITE); // Đặt lại màu nền nếu không trống
        }

        // Tìm nhân viên trong cơ sở dữ liệu
        Employee employee = EmployeeService.findEmployee(employeeID);

        if (employee != null) {
            // Hiển thị thông tin nhân viên trên giao diện
            txt_name.setText(employee.getName());
            jComboBox1.setSelectedItem(employee.getDepartment());
            txt_Salary.setText(employee.getSalary());

            // Hiển thị ngày sinh (đã là String)
            txt_birth.setText(employee.getBirthDate());

            txt_phone.setText(employee.getPhone());
            txt_email.setText(employee.getEmail());
            txt_address.setText(employee.getAddress());

            // Kiểm tra giới tính và chọn checkbox tương ứng
            if ("Male".equals(employee.getGender())) {
                jCheckBox1.setSelected(true);
                jCheckBox2.setSelected(false);
            } else if ("Female".equals(employee.getGender())) {
                jCheckBox1.setSelected(false);
                jCheckBox2.setSelected(true);
            }

            // Hiển thị thông tin vào JTable
            DefaultTableModel model = (DefaultTableModel) jTable_employee.getModel();
            model.setRowCount(0);  // Xóa dữ liệu cũ trên JTable
            model.addRow(new Object[]{
                employee.getId(),
                employee.getDepartment(),
                employee.getName(),
                employee.getBirthDate(),  // Đã là chuỗi
                employee.getPhone(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getAddress(),
                employee.getGender()
            });

        } else {
            // Nếu không tìm thấy nhân viên
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với ID: " + employeeID, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.dispose();
        main.Main mainForm = new Main();
        mainForm.setLocationRelativeTo(null);
        mainForm.setVisible(true);
        
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        String employeeID = txt_id.getText().trim();

       // Kiểm tra nếu ID nhân viên bị trống
       if (employeeID.isEmpty()) {
           JOptionPane.showMessageDialog(this, "Vui lòng nhập ID nhân viên cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
           txt_id.setBackground(Color.PINK); // Đổi màu nền của ô ID thành màu hồng
           return;
       } else {
           txt_id.setBackground(Color.WHITE); // Đặt lại màu nền nếu không trống
       }

       // Hỏi xác nhận từ người dùng trước khi xóa
       int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

       if (confirm == JOptionPane.YES_OPTION) {
           // Kiểm tra xem nhân viên có tồn tại không
           if (EmployeeService.employeeExists(employeeID)) {
               // Gọi phương thức xóa nhân viên
               EmployeeService.deleteEmployee(employeeID);

               // Cập nhật lại bảng dữ liệu
               DefaultTableModel model = (DefaultTableModel) jTable_employee.getModel();
               for (int i = 0; i < model.getRowCount(); i++) {
                   if (model.getValueAt(i, 0).equals(employeeID)) {
                       model.removeRow(i);
                       break;
                   }
               }

               // Xóa các thông tin trên giao diện
               clearForm();
               JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!");
           } else {
               JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với ID: " + employeeID, "Lỗi", JOptionPane.ERROR_MESSAGE);
           }
       }

    }//GEN-LAST:event_btn_removeActionPerformed
    private void clearForm() {
        txt_id.setText("");
        txt_name.setText("");
        jComboBox1.setSelectedIndex(0);
        txt_Salary.setText("");
        txt_birth.setText("");
        txt_phone.setText("");
        txt_email.setText("");
        txt_address.setText("");
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
    }
       
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // Reset lại màu nền về trắng trước khi kiểm tra
        txt_name.setBackground(Color.WHITE);
        txt_id.setBackground(Color.WHITE);
        txt_Salary.setBackground(Color.WHITE);
        txt_birth.setBackground(Color.WHITE);
        txt_phone.setBackground(Color.WHITE);
        txt_email.setBackground(Color.WHITE);
        txt_address.setBackground(Color.WHITE);
        jComboBox1.setBackground(Color.WHITE);
        // Lấy dữ liệu từ các trường
        String employeeID = txt_id.getText().trim();

        // Kiểm tra nếu ô "Mã nhân viên" trống
        if (employeeID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Lấy dữ liệu từ các trường
        String employeeName = txt_name.getText().trim();
        String position = jComboBox1.getSelectedItem() != null ? jComboBox1.getSelectedItem().toString() : "";
        String salary = txt_Salary.getText().trim();
        String date_birth = txt_birth.getText().trim();
        String phone = txt_phone.getText().trim();
        String email = txt_email.getText().trim();
        String address = txt_address.getText().trim();

        boolean valid = true;
        StringBuilder errorMessages = new StringBuilder();

        // Kiểm tra từng trường bắt buộc và highlight màu hồng nếu trống
        if (employeeID.isEmpty()) {
            txt_id.setBackground(Color.PINK);
            errorMessages.append("- Mã nhân viên\n");
            valid = false;
        }
        if (employeeName.isEmpty()) {
            txt_name.setBackground(Color.PINK);
            errorMessages.append("- Tên nhân viên\n");
            valid = false;
        }
        if (phone.isEmpty()) {
            txt_phone.setBackground(Color.PINK);
            errorMessages.append("- Số điện thoại\n");
            valid = false;
        }
        if (email.isEmpty()) {
            txt_email.setBackground(Color.PINK);
            errorMessages.append("- Email\n");
            valid = false;
        }
        if (position.isEmpty()) {
            jComboBox1.setBackground(Color.PINK);
            errorMessages.append("- Chức vụ\n");
            valid = false;
        }
        if (salary.isEmpty()) {
            txt_Salary.setBackground(Color.PINK);
            errorMessages.append("- Lương\n");
            valid = false;
        }
        if (address.isEmpty()) {
            txt_address.setBackground(Color.PINK);
            errorMessages.append("- Địa chỉ\n");
            valid = false;
        }

        // Kiểm tra giới tính
        String gender = "";
        if (jCheckBox1.isSelected()) {
            gender = "Male";
        } else if (jCheckBox2.isSelected()) {
            gender = "Female";
        } else {
            errorMessages.append("- Giới tính\n");
            valid = false;
        }

        // Kiểm tra định dạng ngày sinh
        String[] possibleDateFormats = { "dd/MM/yyyy", "yyyy-MM-dd", "dd-MM-yyyy" };
        java.sql.Date sqlBirthDate = null;
        if (!date_birth.isEmpty()) {
            for (String format : possibleDateFormats) {
                try {
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
                    LocalDate parsedDate = LocalDate.parse(date_birth, dateFormatter);
                    sqlBirthDate = java.sql.Date.valueOf(parsedDate);
                    break;
                } catch (DateTimeParseException e) {
                    // Tiếp tục thử các định dạng khác
                }
            }
            if (sqlBirthDate == null) {
                txt_birth.setBackground(Color.PINK);
                errorMessages.append("- Ngày sinh không hợp lệ\n");
                valid = false;
            }
        } else {
            txt_birth.setBackground(Color.PINK);
            errorMessages.append("- Ngày sinh\n");
            valid = false;
        }

        // Nếu có trường không hợp lệ, hiển thị thông báo lỗi
        if (!valid) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hoặc chọn các trường sau:\n" + errorMessages.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        EmployeeService.updateEmployee(employeeID, position, employeeName, sqlBirthDate, phone, email, salary, address, gender);

        // Cập nhật thông tin trong bảng jTable_employee
        DefaultTableModel model = (DefaultTableModel) jTable_employee.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(employeeID)) {
                model.setValueAt(position, i, 1); // Cập nhật chức vụ
                model.setValueAt(employeeName, i, 2); // Cập nhật tên nhân viên
                model.setValueAt(sqlBirthDate, i, 3); // Cập nhật ngày sinh
                model.setValueAt(phone, i, 4); // Cập nhật số điện thoại
                model.setValueAt(email, i, 5); // Cập nhật email
                model.setValueAt(salary, i, 6); // Cập nhật lương
                model.setValueAt(address, i, 7); // Cập nhật địa chỉ
                model.setValueAt(gender, i, 8); // Cập nhật giới tính
                break;
            }
        }

        // Thông báo thành công
        JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công!");

        // Xóa thông tin trong form sau khi cập nhật
        clearForm();
    }//GEN-LAST:event_btn_updateActionPerformed
    public void checkForm() {
        StringBuffer sb = new StringBuffer();

        // Đảm bảo chỉ một checkbox được chọn
        if (jCheckBox1.isSelected()) {
            // Hủy chọn jCheckBox2 nếu jCheckBox1 được chọn
            jCheckBox2.setSelected(false);
            sb.append("Male checked");
        } else if (jCheckBox2.isSelected()) {
            // Hủy chọn jCheckBox1 nếu jCheckBox2 được chọn
            jCheckBox1.setSelected(false);
            sb.append("Female checked");
        } else {
            sb.append("No gender selected");
        }

        System.out.println(sb.toString());
    }
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jCheckBox2.setSelected(false); // Hủy chọn jCheckBox2
        }
        checkForm();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            jCheckBox1.setSelected(false); // Hủy chọn jCheckBox1
        }
        checkForm();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
         Connection conn = ConnectToSQL.getConnection();

        if (conn != null) {
            try {
                // Câu lệnh SQL để lấy tất cả thông tin nhân viên
                String sql = "SELECT * FROM Add_Employee";

                // Chuẩn bị câu lệnh SQL
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                // Thực thi câu lệnh SQL
                ResultSet resultSet = preparedStatement.executeQuery();

                // Lấy DefaultTableModel từ JTable
                DefaultTableModel model = (DefaultTableModel) jTable_employee.getModel();

                // Xóa tất cả các dòng cũ trước khi thêm dữ liệu mới
                model.setRowCount(0);

                // Lặp qua ResultSet để lấy dữ liệu từng nhân viên
                while (resultSet.next()) {
                    String employeeID = resultSet.getString("Employee_ID");
                    String position = resultSet.getString("Employee_Department");
                    String employeeName = resultSet.getString("Name_Of_Employee");
                    String dateOfBirth = resultSet.getString("Date_Of_Birth");
                    String phone = resultSet.getString("Phone_Number");
                    String email = resultSet.getString("Email");
                    String salary = resultSet.getString("Basic_salary");
                    String address = resultSet.getString("Address");
                    String gender = resultSet.getString("Gender");

                    // Thêm dữ liệu vào JTable
                    model.addRow(new Object[]{employeeID, position, employeeName, dateOfBirth, phone, email, salary, address, gender});
                }

                // Đóng kết nối và giải phóng tài nguyên
                resultSet.close();
                preparedStatement.close();
                conn.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi truy xuất dữ liệu nhân viên: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Kết nối đến cơ sở dữ liệu thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_viewActionPerformed

    private void jTable_employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_employeeMouseClicked
        int selectedRow = jTable_employee.getSelectedRow();

    // Kiểm tra xem bảng có dữ liệu và hàng hợp lệ được chọn không
    if (selectedRow >= 0 && jTable_employee.getRowCount() > 0) {
        // Lấy dữ liệu từ các cột của hàng được chọn, kiểm tra null
        Object employeeIDObj = jTable_employee.getValueAt(selectedRow, 0);
        String employeeID = (employeeIDObj != null) ? employeeIDObj.toString() : "";
        
        Object positionObj = jTable_employee.getValueAt(selectedRow, 1);
        String position = (positionObj != null) ? positionObj.toString() : "";

        Object employeeNameObj = jTable_employee.getValueAt(selectedRow, 2);
        String employeeName = (employeeNameObj != null) ? employeeNameObj.toString() : "";

        Object dateOfBirthObj = jTable_employee.getValueAt(selectedRow, 3);
        String dateOfBirth = (dateOfBirthObj != null) ? dateOfBirthObj.toString() : "";

        Object phoneObj = jTable_employee.getValueAt(selectedRow, 4);
        String phone = (phoneObj != null) ? phoneObj.toString() : "";

        Object emailObj = jTable_employee.getValueAt(selectedRow, 5);
        String email = (emailObj != null) ? emailObj.toString() : "";

        Object salaryObj = jTable_employee.getValueAt(selectedRow, 6);
        String salary = (salaryObj != null) ? salaryObj.toString() : "";

        Object addressObj = jTable_employee.getValueAt(selectedRow, 7);
        String address = (addressObj != null) ? addressObj.toString() : "";

        Object genderObj = jTable_employee.getValueAt(selectedRow, 8);
        String gender = (genderObj != null) ? genderObj.toString() : "";

        // Đặt các giá trị này lên các trường nhập liệu
        txt_id.setText(employeeID);
        jComboBox1.setSelectedItem(position);
        txt_name.setText(employeeName);
        txt_birth.setText(dateOfBirth);
        txt_phone.setText(phone);
        txt_email.setText(email);
        txt_Salary.setText(salary);
        txt_address.setText(address);

        // Kiểm tra giới tính và đặt checkbox
        if ("Male".equalsIgnoreCase(gender)) {
            jCheckBox1.setSelected(true);
            jCheckBox2.setSelected(false);
        } else if ("Female".equalsIgnoreCase(gender)) {
            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(true);
        } else {
            // Nếu giới tính khác (hoặc không xác định), bỏ chọn cả hai checkbox
            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(false);
        }
    } else {
        // Xử lý khi không có dữ liệu hoặc không chọn được hàng hợp lệ
        JOptionPane.showMessageDialog(this, "No data available in the table or invalid selection!", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jTable_employeeMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        login.Login loginForm = new Login();
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_id.setText("");
        txt_Salary.setText("");
        txt_address.setText("");
        txt_birth.setText("");
        txt_email.setText("");
        txt_name.setText("");
        txt_phone.setText("");
        jCheckBox1.setSelected(false); 
        jCheckBox2.setSelected(false);
    }//GEN-LAST:event_btn_clearActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_view;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_employee;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txt_Salary;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_birth;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
