
package main;

import connect.ConnectToSQL;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login.Login;
import model.EmployeeSalary;



public class Salary extends javax.swing.JFrame {

    
    public Salary() {
        initComponents();
        this.setLocationRelativeTo(null);
        clearForm();
        jTable_salary.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Lấy chỉ số của hàng được chọn
            int selectedRow = jTable_salary.getSelectedRow();
            if (selectedRow != -1) {
                txt_id.setEnabled(false);
                jcb_department.setEnabled(false);
                txt_name.setEnabled(false);
                txt_birth.setEnabled(false);
                txt_basicSalary.setEnabled(false);
                txt_salary.setText("");
            }
        }
    });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_payday = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_basicSalary = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_bonus = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_coefficientsSalary = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_salary = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_calcualate = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_view = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcb_department = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_birth = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_salary = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Salary Slip");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 110));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salary.png"))); // NOI18N
        jLabel1.setText("Salary");

        btn_logout.setBackground(new java.awt.Color(255, 102, 0));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-out.png"))); // NOI18N
        btn_logout.setText("Log out");
        btn_logout.setBorder(null);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 679, Short.MAX_VALUE)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 80);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("2022 All Right Reserved");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 854, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 560, 1000, 40);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setText("ID:");

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel7.setText("Pay day:");

        txt_payday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_paydayActionPerformed(evt);
            }
        });

        jLabel8.setText("Basic salary:");

        txt_basicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_basicSalaryActionPerformed(evt);
            }
        });

        jLabel9.setText("Bonus:");

        txt_bonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bonusActionPerformed(evt);
            }
        });

        jLabel10.setText("Coefficients salary:");

        jLabel11.setText("Salary:");

        txt_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salaryActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(51, 51, 51));
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_remove.setBackground(new java.awt.Color(51, 51, 51));
        btn_remove.setForeground(new java.awt.Color(255, 255, 255));
        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(51, 51, 51));
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_calcualate.setBackground(new java.awt.Color(51, 51, 51));
        btn_calcualate.setForeground(new java.awt.Color(255, 255, 255));
        btn_calcualate.setText("Calculate");
        btn_calcualate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcualateActionPerformed(evt);
            }
        });

        btn_back.setBackground(new java.awt.Color(51, 51, 51));
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_view.setBackground(new java.awt.Color(51, 51, 51));
        btn_view.setForeground(new java.awt.Color(255, 255, 255));
        btn_view.setText("View");
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });

        jLabel4.setText("Name:");

        jLabel5.setText("Department:");

        jcb_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giám đốc", "Trưởng phòng", "Quản lý", "Nhân viên", "Bảo vệ", "Thực tập sinh", "Kế toán", "Thư ký" }));

        jLabel6.setText("Birth:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_payday)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_id)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_name, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_birth, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_basicSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(jcb_department, 0, 198, Short.MAX_VALUE)
                            .addComponent(txt_bonus)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_salary)
                            .addComponent(txt_coefficientsSalary))))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(btn_view, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(btn_calcualate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search)
                            .addComponent(btn_clear)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txt_basicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_bonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_coefficientsSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_birth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_payday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_view, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_calcualate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 80, 1000, 250);

        jTable_salary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jTable_salary.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Apartment", "Birth ", "Pay day", "Basic Salary", "Bonus", "Coefficients salary", "Salary"
            }
        ));
        jTable_salary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_salaryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_salary);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 330, 1000, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        login.Login loginFrm = new Login();
        this.dispose();
        loginFrm.setLocationRelativeTo(null);
        loginFrm.setVisible(true);
        
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_paydayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_paydayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_paydayActionPerformed

    private void txt_basicSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_basicSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_basicSalaryActionPerformed

    private void txt_bonusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bonusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bonusActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // Kiểm tra xem có hàng nào được chọn trong JTable không
        int selectedRow = jTable_salary.getSelectedRow();
        if (selectedRow == -1) {
            txt_id.setBackground(Color.PINK); // Đặt nền đỏ cho ô ID nếu không có hàng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn vào hàng table bên dưới để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            txt_id.requestFocus();
            return;
        } else {
            txt_id.setBackground(Color.WHITE); // Đặt lại nền trắng cho ô ID nếu có hàng được chọn
        }

        // Lấy Employee_ID từ hàng được chọn trong bảng JTable
        String employeeID = jTable_salary.getValueAt(selectedRow, 0).toString();

        // Xác nhận trước khi xóa
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa thông tin lương của nhân viên với ID: " + employeeID + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Người dùng không đồng ý xóa, thoát ra
        }

        // Tạo đối tượng EmployeeSalary
        EmployeeSalary employeeSalary = new EmployeeSalary();

        try {
            // Gọi phương thức deleteSalary để xóa dữ liệu
            boolean isDeleted = employeeSalary.deleteSalary(employeeID);

            if (isDeleted) {
                // Xóa hàng từ JTable
                DefaultTableModel model = (DefaultTableModel) jTable_salary.getModel();
                model.removeRow(selectedRow);

                // Thông báo đã xóa thành công
                JOptionPane.showMessageDialog(this, "Đã xóa thông tin lương của nhân viên với ID: " + employeeID, "Thành công", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với ID: " + employeeID + " trong cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        clearForm();
    }//GEN-LAST:event_btn_removeActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // Lấy thông tin từ các ô text và combo box
       String employeeID = txt_id.getText().trim();
       String payDayInput = txt_payday.getText().trim();
       String basicSalaryStr = txt_basicSalary.getText().trim();
       String bonusStr = txt_bonus.getText().trim();
       String coefficientsSalaryStr = txt_coefficientsSalary.getText().trim();

       boolean isValid = true; // Biến để kiểm tra tất cả các trường đều hợp lệ
       StringBuilder errorMessages = new StringBuilder(); // Dùng để lưu tất cả thông báo lỗi

        // Kiểm tra từng trường và thêm thông báo lỗi vào errorMessages nếu có
        if (employeeID.isEmpty()) {
            txt_id.setBackground(Color.PINK); // Đặt nền đỏ cho ô nhập mã nhân viên
            errorMessages.append("Vui lòng nhập mã nhân viên!\n");
            isValid = false;
        } else {
            txt_id.setBackground(Color.WHITE); // Đặt lại nền trắng nếu hợp lệ
        }

        if (payDayInput.isEmpty()) {
            txt_payday.setBackground(Color.PINK); // Đặt nền đỏ cho ô nhập ngày thanh toán
            errorMessages.append("Vui lòng nhập ngày thanh toán!\n");
            isValid = false;
        } else {
            txt_payday.setBackground(Color.WHITE); // Đặt lại nền trắng nếu hợp lệ
        }

        if (bonusStr.isEmpty()) {
            txt_bonus.setBackground(Color.PINK); // Đặt nền đỏ cho ô nhập tiền thưởng
            errorMessages.append("Vui lòng nhập tiền thưởng!\n");
            isValid = false;
        } else {
            txt_bonus.setBackground(Color.WHITE); // Đặt lại nền trắng nếu hợp lệ
        }

        if (coefficientsSalaryStr.isEmpty()) {
            txt_coefficientsSalary.setBackground(Color.PINK); // Đặt nền đỏ cho ô nhập hệ số lương
            errorMessages.append("Vui lòng nhập hệ số lương!\n");
            isValid = false;
        } else {
            txt_coefficientsSalary.setBackground(Color.WHITE); // Đặt lại nền trắng nếu hợp lệ
        }

        // Nếu có lỗi, dừng quá trình và hiển thị tất cả các lỗi
        if (!isValid) {
            JOptionPane.showMessageDialog(this, errorMessages.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chuyển đổi định dạng ngày
        SimpleDateFormat[] dateFormats = {
            new SimpleDateFormat("dd/MM/yyyy"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("dd-MM-yyyy")
        };

        Date payDay = null;
        for (SimpleDateFormat format : dateFormats) {
            try {
                format.setLenient(false);
                payDay = format.parse(payDayInput);
                break;
            } catch (ParseException e) {
                // Thử định dạng khác nếu lỗi
            }
        }

        if (payDay == null) {
            txt_payday.setBackground(Color.PINK);
            errorMessages.append("Định dạng ngày tháng không hợp lệ. Vui lòng nhập theo định dạng: dd/MM/yyyy, yyyy-MM-dd, hoặc dd-MM-yyyy\n");
            isValid = false;
        } else {
            txt_payday.setBackground(Color.WHITE);
        }

        if (!isValid) {
            JOptionPane.showMessageDialog(this, errorMessages.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedPayDay = dbDateFormat.format(payDay);

        double basicSalary, bonus, coefficientsSalary, totalSalary;
        try {
            basicSalary = Double.parseDouble(basicSalaryStr);
            bonus = Double.parseDouble(bonusStr);
            coefficientsSalary = Double.parseDouble(coefficientsSalaryStr);
            totalSalary = (basicSalary * coefficientsSalary) + bonus;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho lương cơ bản, tiền thưởng và hệ số lương", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EmployeeSalary employeeSalary = new EmployeeSalary();

        try {
            if (employeeSalary.isSalaryExist(employeeID)) {
                boolean isUpdated = employeeSalary.updateSalary(employeeID, formattedPayDay, basicSalary, bonus, coefficientsSalary, totalSalary);

                if (isUpdated) {
                    // Cập nhật thông tin trong JTable
                    DefaultTableModel model = (DefaultTableModel) jTable_salary.getModel();
                    int selectedRow = jTable_salary.getSelectedRow();
                    if (selectedRow != -1) {
                        model.setValueAt(formattedPayDay, selectedRow, 4);
                        model.setValueAt(basicSalaryStr, selectedRow, 5);
                        model.setValueAt(bonusStr, selectedRow, 6);
                        model.setValueAt(coefficientsSalaryStr, selectedRow, 7);
                        model.setValueAt(totalSalary, selectedRow, 8);
                    }

                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin lương thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    // Reset các ô nhập liệu sau khi cập nhật thành công
                    txt_id.setEnabled(true);
                    txt_name.setEnabled(true);
                    txt_birth.setEnabled(true);
                    jcb_department.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể cập nhật thông tin lương.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin lương của nhân viên này", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối đến cơ sở dữ liệu hoặc cập nhật dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        clearForm();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearForm();
        txt_id.setBackground(Color.WHITE);
        txt_bonus.setBackground(Color.WHITE);
        txt_payday.setBackground(Color.WHITE);
        txt_coefficientsSalary.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String employeeID = txt_id.getText().trim();

        // Kiểm tra xem đã nhập Employee ID chưa
        if (employeeID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Employee ID", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt_id.setBackground(Color.PINK);  // Đổi màu ô nhập ID sang đỏ nếu trống
            return;
        } else {
            txt_id.setBackground(Color.WHITE); // Đặt lại màu ô nhập ID nếu đã có
        }

        // Tạo đối tượng EmployeeSalary để sử dụng các phương thức đã định nghĩa
        EmployeeSalary employeeSalary = new EmployeeSalary();

        try {
            // Kiểm tra nếu bảng Salary có thông tin lương
            if (employeeSalary.isSalaryExist(employeeID)) {
                // Lấy thông tin nhân viên và lương từ bảng Add_Employee và Salary
                ResultSet rsEmployee = employeeSalary.getEmployeeDetails(employeeID);
                ResultSet rsSalary = employeeSalary.getSalaryDetailsByEmployeeID(employeeID);

                if (rsEmployee.next() && rsSalary.next()) {
                    // Hiển thị thông tin nhân viên vào các ô text
                    txt_name.setText(rsEmployee.getString("Name_Of_Employee"));
                    txt_birth.setText(rsEmployee.getString("Date_Of_Birth"));
                    txt_basicSalary.setText(rsEmployee.getString("Basic_salary"));
                    String department = rsEmployee.getString("Employee_Department");

                    // Đảm bảo phòng ban được chọn đúng trong combo box
                    if (department != null) {
                        boolean found = false;
                        for (int i = 0; i < jcb_department.getItemCount(); i++) {
                            if (jcb_department.getItemAt(i).toString().equals(department)) {
                                jcb_department.setSelectedItem(department);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            jcb_department.addItem(department);
                            jcb_department.setSelectedItem(department);
                        }
                    }

                    // Hiển thị thông tin lương vào các ô text
                    txt_payday.setText(rsSalary.getString("Pay_day"));
                    txt_bonus.setText(rsSalary.getString("Bonus"));
                    txt_coefficientsSalary.setText(rsSalary.getString("Coefficients_salary"));
                    txt_salary.setText(rsSalary.getString("Salary"));

                    // Cập nhật JTable với thông tin từ cả Add_Employee và Salary
                    DefaultTableModel model = (DefaultTableModel) jTable_salary.getModel();
                    model.setRowCount(0); // Xóa dữ liệu cũ
                    model.addRow(new Object[]{
                        employeeID,
                        rsEmployee.getString("Name_Of_Employee"),
                        department,
                        rsEmployee.getString("Date_Of_Birth"),
                        rsSalary.getString("Pay_day"),
                        rsEmployee.getString("Basic_salary"),  
                        rsSalary.getString("Bonus"),
                        rsSalary.getString("Coefficients_salary"),
                        rsSalary.getString("Salary")
                    });
                }
            } else {
                // Nếu không có thông tin lương, chỉ lấy thông tin từ bảng Add_Employee và hiển thị lên textField
                ResultSet rsEmployee = employeeSalary.getEmployeeDetails(employeeID);

                if (rsEmployee.next()) {
                    // Hiển thị thông tin nhân viên vào các ô text
                    txt_name.setText(rsEmployee.getString("Name_Of_Employee"));
                    txt_birth.setText(rsEmployee.getString("Date_Of_Birth"));
                    txt_basicSalary.setText(rsEmployee.getString("Basic_salary"));
                    String department = rsEmployee.getString("Employee_Department");

                    // Đảm bảo phòng ban được chọn đúng trong combo box
                    if (department != null) {
                        boolean found = false;
                        for (int i = 0; i < jcb_department.getItemCount(); i++) {
                            if (jcb_department.getItemAt(i).toString().equals(department)) {
                                jcb_department.setSelectedItem(department);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            jcb_department.addItem(department);
                            jcb_department.setSelectedItem(department);
                        }
                    }

                    // Chỉ hiển thị thông tin nhân viên lên textField, không cần cập nhật JTable
                    txt_payday.setText("");
                    txt_bonus.setText("");
                    txt_coefficientsSalary.setText("");
                    txt_salary.setText("");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn cơ sở dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // Reset backgrounds to white before validation
        txt_id.setBackground(Color.WHITE);
        txt_payday.setBackground(Color.WHITE);
        txt_bonus.setBackground(Color.WHITE);
        txt_coefficientsSalary.setBackground(Color.WHITE);

        // Lấy thông tin từ các ô text và combo box
        String employeeID = txt_id.getText().trim();
        String payDayInput = txt_payday.getText().trim();
        String bonusStr = txt_bonus.getText().trim();
        String coefficientsSalaryStr = txt_coefficientsSalary.getText().trim();

        boolean valid = true; // Flag to track overall validity of inputs
        StringBuilder errorMessages = new StringBuilder(); // Collect error messages

        // Kiểm tra xem các trường có bị trống không
        if (employeeID.isEmpty()) {
            txt_id.setBackground(Color.PINK);
            errorMessages.append("- Mã nhân viên\n");
            valid = false;
        }
        if (payDayInput.isEmpty()) {
            txt_payday.setBackground(Color.PINK);
            errorMessages.append("- Ngày trả lương\n");
            valid = false;
        }
        if (bonusStr.isEmpty()) {
            txt_bonus.setBackground(Color.PINK);
            errorMessages.append("- Tiền thưởng\n");
            valid = false;
        }
        if (coefficientsSalaryStr.isEmpty()) {
            txt_coefficientsSalary.setBackground(Color.PINK);
            errorMessages.append("- Hệ số lương\n");
            valid = false;
        }

        if (!valid) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập các trường sau:\n" + errorMessages.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra và chuẩn hóa định dạng ngày tháng
        SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date payDay = null;
        try {
            payDay = new SimpleDateFormat("dd/MM/yyyy").parse(payDayInput); 
        } catch (ParseException e) {
            txt_payday.setBackground(Color.PINK);
            JOptionPane.showMessageDialog(this, "Định dạng ngày tháng không hợp lệ. Vui lòng nhập theo định dạng: dd/MM/yyyy", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String formattedPayDay = dbDateFormat.format(payDay);

        double bonus, coefficientsSalary;
        try {
            bonus = Double.parseDouble(bonusStr);
            coefficientsSalary = Double.parseDouble(coefficientsSalaryStr);
        } catch (NumberFormatException e) {
            txt_bonus.setBackground(Color.PINK);
            txt_coefficientsSalary.setBackground(Color.PINK);
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho tiền thưởng và hệ số lương", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EmployeeSalary employeeSalary = new EmployeeSalary();

        try {
            // Kiểm tra nhân viên đã có lương chưa
            if (employeeSalary.isSalaryExist(employeeID)) {
                JOptionPane.showMessageDialog(this, "Nhân viên này đã có thông tin lương. Vui lòng chọn cập nhật (Update).", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Lấy thông tin nhân viên từ bảng Add_Employee
            ResultSet rs = employeeSalary.getEmployeeDetails(employeeID);
            if (rs.next()) {
                String nameOfEmployee = rs.getString("Name_Of_Employee");
                String department = rs.getString("Employee_Department");
                String dateOfBirth = rs.getString("Date_Of_Birth");
                double basicSalary = rs.getDouble("Basic_salary");

                // Tính toán tổng lương
                double totalSalary = employeeSalary.calculateTotalSalary(basicSalary, coefficientsSalary, bonus);

                // Thêm lương vào bảng Salary
                employeeSalary.upsertSalary(employeeID, formattedPayDay, basicSalary, bonus, coefficientsSalary, totalSalary);

                // Cập nhật JTable
                DefaultTableModel model = (DefaultTableModel) jTable_salary.getModel();
                model.insertRow(0, new Object[]{
                    employeeID, nameOfEmployee, department, dateOfBirth, formattedPayDay, 
                    basicSalary, bonus, coefficientsSalary, totalSalary
                });

                JOptionPane.showMessageDialog(this, "Thêm thông tin lương thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với ID này trong bảng Add_Employee", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xử lý dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        clearForm();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
        EmployeeSalary employeeSalary = new EmployeeSalary();

        try (ResultSet rs = employeeSalary.getAllSalaries()) {
            // Xóa toàn bộ dữ liệu cũ trong bảng trước khi hiển thị dữ liệu mới
            DefaultTableModel model = (DefaultTableModel) jTable_salary.getModel();
            model.setRowCount(0); // Xóa các hàng cũ trong JTable

            // Duyệt qua ResultSet để lấy dữ liệu và hiển thị trên JTable
            while (rs.next()) {
                String employeeID = rs.getString("Employee_ID");
                String nameOfEmployee = rs.getString("Name_Of_Employee");
                String department = rs.getString("Employee_Department");
                String dateOfBirth = rs.getString("Date_Of_Birth");
                String payDay = rs.getString("Pay_day");
                String basicSalary = rs.getString("Basic_salary");
                String bonus = rs.getString("Bonus");
                String coefficientsSalary = rs.getString("Coefficients_salary");
                String totalSalary = rs.getString("Salary");

                // Thêm một hàng mới vào bảng JTable
                model.addRow(new Object[] {
                    employeeID, nameOfEmployee, department, dateOfBirth, payDay, basicSalary, bonus, coefficientsSalary, totalSalary
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu từ cơ sở dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_viewActionPerformed


    private void txt_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salaryActionPerformed
        // Kiểm tra xem các ô nhập liệu có trống hay không
        String employeeID = txt_id.getText().trim();
        String basicSalaryStr = txt_basicSalary.getText().trim();
        String bonusStr = txt_bonus.getText().trim();
        String coefficientsSalaryStr = txt_coefficientsSalary.getText().trim();
        String payDay = txt_payday.getText().trim();

        if (employeeID.isEmpty() || basicSalaryStr.isEmpty() || bonusStr.isEmpty() || coefficientsSalaryStr.isEmpty() || payDay.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Chuyển đổi dữ liệu từ String sang các kiểu số để tính toán
            double basicSalary = Double.parseDouble(basicSalaryStr);
            double bonus = Double.parseDouble(bonusStr);
            double coefficientsSalary = Double.parseDouble(coefficientsSalaryStr);

            // Tính toán tổng lương
            double totalSalary = (basicSalary * coefficientsSalary) + bonus;

            // Hiển thị tổng lương lên text field
            txt_salary.setText(String.valueOf(totalSalary));

            // Kết nối đến cơ sở dữ liệu SQL Server thông qua ConnectToSQL
            Connection conn = ConnectToSQL.getConnection(); // Sử dụng kết nối đã được tạo từ ConnectToSQL

            if (conn != null) {
                // Câu truy vấn để chèn hoặc cập nhật lương vào bảng SALARY
                String sql = "IF EXISTS (SELECT * FROM SALARY WHERE Employee_ID = ?) " +
                             "UPDATE SALARY SET Pay_day = ?, Basic_salary = ?, Bonus = ?, Coefficients_salary = ?, Salary = ? WHERE Employee_ID = ? " +
                             "ELSE " +
                             "INSERT INTO SALARY (Employee_ID, Pay_day, Basic_salary, Bonus, Coefficients_salary, Salary) VALUES (?, ?, ?, ?, ?, ?)";

                // Sử dụng PreparedStatement để thực thi câu truy vấn
                try (PreparedStatement pst = conn.prepareStatement(sql)) {
                    // Thiết lập các tham số cho câu truy vấn
                    pst.setString(1, employeeID);  // Kiểm tra Employee_ID tồn tại trong bảng lương hay không
                    pst.setString(2, payDay);      // Ngày trả lương
                    pst.setDouble(3, basicSalary); // Lương cơ bản
                    pst.setDouble(4, bonus);       // Thưởng
                    pst.setDouble(5, coefficientsSalary); // Hệ số lương
                    pst.setDouble(6, totalSalary); // Tổng lương
                    pst.setString(7, employeeID);  // Employee_ID cho điều kiện WHERE

                    // Thêm dữ liệu mới nếu không tồn tại Employee_ID trong bảng lương
                    pst.setString(8, employeeID);
                    pst.setString(9, payDay);
                    pst.setDouble(10, basicSalary);
                    pst.setDouble(11, bonus);
                    pst.setDouble(12, coefficientsSalary);
                    pst.setDouble(13, totalSalary);

                    // Thực thi truy vấn
                    int rowsAffected = pst.executeUpdate();

                    // Kiểm tra xem có cập nhật thành công không
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Tính toán và chèn lương thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với ID này", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi xử lý cơ sở dữ liệu", "Lỗi cơ sở dữ liệu", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Kết nối cơ sở dữ liệu thất bại", "Lỗi kết nối", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu người dùng nhập sai định dạng số
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txt_salaryActionPerformed

    private void btn_calcualateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcualateActionPerformed
        // Lấy thông tin từ các ô nhập liệu
        String basicSalaryStr = txt_basicSalary.getText().trim();
        String bonusStr = txt_bonus.getText().trim();
        String coefficientsSalaryStr = txt_coefficientsSalary.getText().trim();

        boolean isValid = true; // Biến kiểm tra tất cả các trường hợp hợp lệ
        StringBuilder errorMessages = new StringBuilder(); // Lưu thông báo lỗi

        // Kiểm tra các trường nhập liệu
        if (basicSalaryStr.isEmpty()) {
            txt_basicSalary.setBackground(Color.PINK);
            errorMessages.append("Vui lòng nhập lương cơ bản!\n");
            isValid = false;
        } else {
            txt_basicSalary.setBackground(Color.WHITE);
        }

        if (bonusStr.isEmpty()) {
            txt_bonus.setBackground(Color.PINK);
            errorMessages.append("Vui lòng nhập tiền thưởng!\n");
            isValid = false;
        } else {
            txt_bonus.setBackground(Color.WHITE);
        }

        if (coefficientsSalaryStr.isEmpty()) {
            txt_coefficientsSalary.setBackground(Color.PINK);
            errorMessages.append("Vui lòng nhập hệ số lương!\n");
            isValid = false;
        } else {
            txt_coefficientsSalary.setBackground(Color.WHITE);
        }

        // Hiển thị lỗi nếu có
        if (!isValid) {
            JOptionPane.showMessageDialog(this, errorMessages.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Chuyển đổi dữ liệu từ String sang kiểu số
            double basicSalary = Double.parseDouble(basicSalaryStr);
            double bonus = Double.parseDouble(bonusStr);
            double coefficientsSalary = Double.parseDouble(coefficientsSalaryStr);

            // Tính toán tổng lương bằng class EmployeeSalary
            EmployeeSalary employeeSalary = new EmployeeSalary();
            double totalSalary = employeeSalary.calculateTotalSalary(basicSalary, coefficientsSalary, bonus);

            // Hiển thị tổng lương lên text field
            txt_salary.setText(String.valueOf(totalSalary));

            // Thông báo thành công
            JOptionPane.showMessageDialog(this, "Tính toán lương thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu người dùng nhập sai định dạng số
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_calcualateActionPerformed

    private void jTable_salaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_salaryMouseClicked
         int selectedRow = jTable_salary.getSelectedRow();

    // Kiểm tra xem có hàng nào được chọn không
    if (selectedRow >= 0) {
        // Lấy dữ liệu từ các cột trong hàng được chọn
        String employeeID = (String) jTable_salary.getValueAt(selectedRow, 0);
        String nameOfEmployee = (String) jTable_salary.getValueAt(selectedRow, 1);
        String department = (String) jTable_salary.getValueAt(selectedRow, 2);
        String dateOfBirth = (String) jTable_salary.getValueAt(selectedRow, 3);
        String payDay = (String) jTable_salary.getValueAt(selectedRow, 4);
        String basicSalary = (String) jTable_salary.getValueAt(selectedRow, 5);
        String bonus = (String) jTable_salary.getValueAt(selectedRow, 6);
        String coefficientsSalary = (String) jTable_salary.getValueAt(selectedRow, 7);
        String totalSalary = String.valueOf(jTable_salary.getValueAt(selectedRow, 8)); // Lấy giá trị tổng lương

        // Hiển thị dữ liệu lên các ô nhập liệu tương ứng
        txt_id.setText(employeeID);                       // Hiển thị mã nhân viên
        txt_name.setText(nameOfEmployee);                  // Hiển thị tên nhân viên
        txt_birth.setText(dateOfBirth);                    // Hiển thị ngày sinh
        jcb_department.setSelectedItem(department);       // Hiển thị phòng ban trong combo box
        txt_payday.setText(payDay);                       // Hiển thị ngày trả lương
        txt_basicSalary.setText(basicSalary);             // Hiển thị lương cơ bản
        txt_bonus.setText(bonus);                         // Hiển thị tiền thưởng
        txt_coefficientsSalary.setText(coefficientsSalary); // Hiển thị hệ số lương
        txt_salary.setText(totalSalary);                  // Hiển thị tổng lương
    }
    }//GEN-LAST:event_jTable_salaryMouseClicked
    private void clearForm(){
         // Xóa nội dung trong các ô JTextField
        txt_id.setText("");              
        txt_name.setText("");
        txt_birth.setText("");
        txt_payday.setText("");          
        txt_basicSalary.setText("");      
        txt_bonus.setText("");           
        txt_coefficientsSalary.setText(""); 
        txt_salary.setText("");
        txt_id.setEnabled(true);
        txt_name.setEnabled(false);
        txt_birth.setEnabled(false);
        jcb_department.setEnabled(false);
        txt_basicSalary.setEnabled(false);
        txt_salary.setEnabled(false);
    }
    
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.dispose();
        main.Main mainFrm = new Main();
        mainFrm.setLocationRelativeTo(null);
        mainFrm.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_calcualate;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_view;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_salary;
    private javax.swing.JComboBox<String> jcb_department;
    private javax.swing.JTextField txt_basicSalary;
    private javax.swing.JTextField txt_birth;
    private javax.swing.JTextField txt_bonus;
    private javax.swing.JTextField txt_coefficientsSalary;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_payday;
    private javax.swing.JTextField txt_salary;
    // End of variables declaration//GEN-END:variables
}

