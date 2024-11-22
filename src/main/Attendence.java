
package main;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import login.Login;
import model.EmployeeAttendance;

public class Attendence extends javax.swing.JFrame {

   
    public Attendence() {
        initComponents();
        this.setLocationRelativeTo(null);
        DisableForm();
        
        jTable_attendence.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Lấy chỉ số của hàng được chọn
            int selectedRow = jTable_attendence.getSelectedRow();
            if (selectedRow != -1) {
                // Lấy thông tin từ hàng được chọn
                String employeeID = (String) jTable_attendence.getValueAt(selectedRow, 0); // ID
                String department = (String) jTable_attendence.getValueAt(selectedRow, 1); // Phòng ban
                String nameOfEmployee = (String) jTable_attendence.getValueAt(selectedRow, 2); // Tên nhân viên
                String dateOfBirth = (String) jTable_attendence.getValueAt(selectedRow, 3); // Ngày sinh
                String attendanceDate = (String) jTable_attendence.getValueAt(selectedRow, 4); // Ngày chấm công

                // Hiển thị thông tin vào các ô text
                txt_id.setText(employeeID);
                txt_name.setText(nameOfEmployee);
                txt_birth.setText(dateOfBirth);
                txt_date.setText(attendanceDate);

                // Tìm kiếm và lấy thông tin nhân viên từ cơ sở dữ liệu
                Connection conn = null;
                ResultSet rs = null;

                try {
                    // Kiểm tra kết nối cơ sở dữ liệu
                    conn = connect.ConnectToSQL.getConnection();
                    if (conn == null) {
                        throw new SQLException("Không thể kết nối tới cơ sở dữ liệu.");
                    }

                    // Truy vấn thông tin nhân viên
                    String sql = """
                                    SELECT ae.Employee_ID, ae.Name_Of_Employee, ae.Employee_Department, ae.Date_Of_Birth, a.Attendence_Date
                                    FROM Add_Employee ae
                                    JOIN Attendence a ON ae.Employee_ID = a.Employee_ID
                                    WHERE ae.Employee_ID = ?;
                                """;

                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, employeeID);
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        // Lấy thông tin từ kết quả truy vấn
                        String employeeDept = rs.getString("Employee_Department");
                        String employeeName = rs.getString("Name_Of_Employee");
                        String employeeDOB = rs.getString("Date_Of_Birth");
                        String attendanceDateFromDB = rs.getString("Attendence_Date");

                        // Hiển thị thông tin lên giao diện
                        txt_name.setText(employeeName != null ? employeeName : "");
                        txt_id.setText(employeeID != null ? employeeID : "");
                        txt_birth.setText(employeeDOB != null ? employeeDOB : "");

                        // Xử lý combo box phòng ban
                        if (employeeDept != null) {
                            boolean found = false;
                            for (int i = 0; i < cb_department.getItemCount(); i++) {
                                if (cb_department.getItemAt(i).toString().equals(employeeDept)) {
                                    cb_department.setSelectedItem(employeeDept);
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                cb_department.addItem(employeeDept);
                                cb_department.setSelectedItem(employeeDept);
                            }
                        }

                        // Hiển thị thông tin chấm công
                        txt_attendence.setLineWrap(true);
                        txt_attendence.setWrapStyleWord(true);
                        txt_attendence.setText("-----------------------------------------------------\n" +
                                               "         THÔNG TIN CHẤM CÔNG          \n" +
                                               "-----------------------------------------------------\n" +
                                               "  Tên nhân viên    : " + employeeName + "\n" +
                                               "  Mã nhân viên     : " + employeeID + "\n" +
                                               "  Ngày sinh        : " + employeeDOB + "\n" +
                                               "  Phòng ban        : " + employeeDept + "\n" +
                                               "  Ngày công        : " + (attendanceDateFromDB != null ? attendanceDateFromDB : "Không có dữ liệu") + "\n" +
                                               "-----------------------------------------------------");
                        txt_attendence.setCaretPosition(0);

                        // Khóa các trường không cần chỉnh sửa
                        txt_id.setEnabled(false);  // Không cho chỉnh sửa mã nhân viên
                        cb_department.setEnabled(false);  // Không cho chỉnh sửa phòng ban
                        txt_name.setEnabled(false);  // Không cho chỉnh sửa tên nhân viên
                        txt_birth.setEnabled(false);  // Không cho chỉnh sửa ngày sinh
                    } 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu: " + ex.getMessage(), "Lỗi cơ sở dữ liệu", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // Đảm bảo đóng tài nguyên
                    try {
                        if (rs != null) rs.close();
                        if (conn != null) conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
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
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cb_department = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_birth = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_date = new javax.swing.JTextField();
        btn_attendence = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_attendence = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_attendence = new javax.swing.JTextArea();
        btn_view = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 110));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendar.png"))); // NOI18N
        jLabel1.setText("Attendance");

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-out.png"))); // NOI18N
        jButton1.setText("Log out");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 560, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 110);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("2022 All Right Reserved");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(833, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 550, 1000, 60);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Employee ID");

        txt_id.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        btn_search.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Employee Department");

        cb_department.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cb_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trưởng phòng", "Quản lý", "Nhân viên", "Giám đốc", "Bảo vệ", "Thực tập sinh", "Kế toán", "Thư ký", " " }));
        cb_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_departmentActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Name Of Employee");

        txt_name.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Date Of Birth");

        txt_birth.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt_birth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_birthActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Date");

        txt_date.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txt_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateActionPerformed(evt);
            }
        });

        btn_attendence.setBackground(new java.awt.Color(0, 0, 0));
        btn_attendence.setForeground(new java.awt.Color(255, 255, 255));
        btn_attendence.setText("Attendance");
        btn_attendence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_attendenceActionPerformed(evt);
            }
        });

        jTable_attendence.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jTable_attendence.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Apartment", "Name", "Birth ", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable_attendence);

        btn_back.setBackground(new java.awt.Color(0, 0, 0));
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Thông tin chấm công");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Bảng chấm công");

        txt_attendence.setColumns(20);
        txt_attendence.setRows(5);
        jScrollPane2.setViewportView(txt_attendence);

        btn_view.setBackground(new java.awt.Color(255, 255, 204));
        btn_view.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_view.setForeground(new java.awt.Color(255, 0, 0));
        btn_view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btn_view.setText("View");
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(255, 255, 204));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 0, 0));
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_remove.setBackground(new java.awt.Color(0, 0, 0));
        btn_remove.setForeground(new java.awt.Color(255, 255, 255));
        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(0, 0, 0));
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_view)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_birth)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_date))
                        .addComponent(cb_department, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btn_attendence, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_attendence, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(cb_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_birth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_view, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 110, 1000, 440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateActionPerformed
    private void DisableForm(){
        txt_birth.setEnabled(false);
        txt_name.setEnabled(false);
        cb_department.setEnabled(false);
    }
    
    private void btn_attendenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_attendenceActionPerformed
        // Lấy thông tin từ các ô nhập liệu
        String employeeID = txt_id.getText().trim();
        String attendanceDate = txt_date.getText().trim(); // Ngày tháng chấm công

        boolean isValid = true; // Biến để kiểm tra tất cả các trường hợp hợp lệ
        StringBuilder errorMessages = new StringBuilder(); // Dùng để lưu tất cả thông báo lỗi

        // Kiểm tra xem các ô nhập liệu có trống hay không
        if (employeeID.isEmpty()) {
            txt_id.setBackground(Color.PINK); // Đổi màu nền của txt_id thành màu đỏ
            errorMessages.append("Vui lòng nhập mã nhân viên!\n");
            isValid = false;
        } else {
            txt_id.setBackground(Color.WHITE); // Đặt lại nền trắng nếu hợp lệ
        }

        if (attendanceDate.isEmpty()) {
            txt_date.setBackground(Color.PINK); // Đổi màu nền của txt_date thành màu đỏ
            errorMessages.append("Vui lòng nhập ngày chấm công!\n");
            isValid = false;
        } else {
            txt_date.setBackground(Color.WHITE); // Đặt lại nền trắng nếu hợp lệ
        }

        // Nếu có lỗi, hiển thị tất cả lỗi và dừng lại
        if (!isValid) {
            JOptionPane.showMessageDialog(this, errorMessages.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Các định dạng ngày cần hỗ trợ
        String[] possibleDateFormats = { "dd/MM/yyyy", "yyyy-MM-dd", "dd-MM-yyyy" };
        java.sql.Date sqlDate = null;

        // Thử từng định dạng ngày
        for (String format : possibleDateFormats) {
            try {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
                LocalDate parsedDate = LocalDate.parse(attendanceDate, dateFormatter);
                sqlDate = java.sql.Date.valueOf(parsedDate); // Chuyển sang java.sql.Date để đưa vào SQL
                break; // Nếu định dạng đúng, thoát khỏi vòng lặp
            } catch (DateTimeParseException e) {
                // Không làm gì, tiếp tục thử định dạng khác
            }
        }

        // Nếu không định dạng nào đúng
        if (sqlDate == null) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng sử dụng dd/MM/yyyy, yyyy-MM-dd, hoặc dd-MM-yyyy", "Lỗi định dạng ngày", JOptionPane.ERROR_MESSAGE);
            txt_date.setBackground(Color.PINK); // Đổi màu nền của txt_date thành màu đỏ
            return;
        } else {
            txt_date.setBackground(Color.WHITE); // Đặt lại nền trắng nếu hợp lệ
        }

        // Kiểm tra xem nhân viên đã chấm công vào ngày này chưa
        try {
            if (EmployeeAttendance.isAttendanceRecorded(employeeID, sqlDate)) {
                JOptionPane.showMessageDialog(this, "Nhân viên đã được chấm công vào ngày này", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return; // Dừng lại nếu đã có bản ghi
            }

            // Tìm kiếm thông tin nhân viên theo Employee ID
            ResultSet rsEmployee = EmployeeAttendance.searchEmployeeFromAddEmployee(employeeID);
            if (rsEmployee.next()) {
                // Lấy thông tin phòng ban, tên nhân viên, ngày sinh
                String department = rsEmployee.getString("Employee_Department");
                String nameOfEmployee = rsEmployee.getString("Name_Of_Employee");
                String dateOfBirth = rsEmployee.getString("Date_Of_Birth");

                // Thêm thông tin chấm công vào bảng Attendance
                boolean success = EmployeeAttendance.addAttendance(Integer.parseInt(employeeID), sqlDate);
                if (success) {
                    // Cập nhật bảng hiển thị
                    DefaultTableModel model = (DefaultTableModel) jTable_attendence.getModel();
                    model.insertRow(0, new Object[] {
                        employeeID,           // ID
                        department,           // Chức vụ (Phòng ban)
                        nameOfEmployee,       // Tên nhân viên
                        dateOfBirth,          // Ngày sinh
                        attendanceDate        // Ngày công
                    });

                    JOptionPane.showMessageDialog(this, "Chấm công thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    // Giữ nguyên thông tin hiện tại
                    String existingText = txt_attendence.getText(); 
                    String successMessage = "\n     -----Hoàn tất chấm công ngày-----\n" + "           ----------" + attendanceDate + "----------";

                    // Cập nhật lại nội dung cho txt_attendence
                    txt_attendence.setText(existingText + successMessage); // Thêm thông báo thành công
                    txt_attendence.setCaretPosition(txt_attendence.getText().length()); // Đảm bảo con trỏ ở cuối văn bản
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể chấm công", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                txt_id.setEnabled(true);
                txt_attendence.setText(""); // Xóa thông tin hiện tại

            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với ID này", "Không tìm thấy", JOptionPane.INFORMATION_MESSAGE);
            }

            rsEmployee.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thao tác với cơ sở dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        clearForm(); 
    }//GEN-LAST:event_btn_attendenceActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
         // Lấy Employee ID từ ô nhập liệu
        String employeeID = txt_id.getText().trim();

        if (employeeID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Employee ID", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt_id.setBackground(Color.PINK);
            return;
        } else {
            txt_id.setBackground(Color.WHITE);
        }

        try {
            // Tìm kiếm thông tin nhân viên từ Add_Employee
            ResultSet rs = EmployeeAttendance.searchEmployeeFromAddEmployee(employeeID);

            if (rs.next()) {
                // Lấy thông tin từ kết quả truy vấn
                String nameOfEmployee = rs.getString("Name_Of_Employee");
                String employeeId = rs.getString("Employee_ID");
                String dateOfBirth = rs.getString("Date_Of_Birth");
                String department = rs.getString("Employee_Department");

                // Hiển thị thông tin lên giao diện
                txt_name.setText(nameOfEmployee != null ? nameOfEmployee : "");
                txt_id.setText(employeeId != null ? employeeId : "");
                txt_birth.setText(dateOfBirth != null ? dateOfBirth : "");

                // Xử lý combo box phòng ban
                if (department != null) {
                    boolean found = false;
                    for (int i = 0; i < cb_department.getItemCount(); i++) {
                        if (cb_department.getItemAt(i).toString().equals(department)) {
                            cb_department.setSelectedItem(department);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        cb_department.addItem(department);
                        cb_department.setSelectedItem(department);
                    }
                }

                // Khóa các trường không cần chỉnh sửa
                txt_id.setEnabled(true);
                txt_name.setEnabled(false);
                txt_birth.setEnabled(false);
                cb_department.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với ID này", "Không tìm thấy", JOptionPane.INFORMATION_MESSAGE);
            }

            // Đóng tài nguyên
            EmployeeAttendance.closeResources(null, null, rs);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối đến cơ sở dữ liệu", "Lỗi cơ sở dữ liệu", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void cb_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_departmentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        login.Login loginFrm = new Login();
        loginFrm.setLocationRelativeTo(null);
        loginFrm.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.dispose();
        main.Main mainFrm= new Main();
        mainFrm.setLocationRelativeTo(null);
        mainFrm.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
         // Sử dụng phương thức getConnection để lấy kết nối
    Connection conn = connect.ConnectToSQL.getConnection();

    if (conn == null) {
        JOptionPane.showMessageDialog(this, "Không thể kết nối tới cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Truy vấn SQL để lấy thông tin nhân viên đã có chấm công, sử dụng INNER JOIN để loại bỏ nhân viên chưa chấm công
        String sql = """
            SELECT ae.Employee_ID, 
                   ae.Name_Of_Employee, 
                   ae.Employee_Department, 
                   ae.Date_Of_Birth, 
                   at.Attendence_Date
            FROM Add_Employee ae
            INNER JOIN Attendence at ON ae.Employee_ID = at.Employee_ID
        """;

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        // Lấy mô hình của JTable
        DefaultTableModel model = (DefaultTableModel) jTable_attendence.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng cũ trong bảng

        // Thêm các hàng mới vào bảng từ kết quả truy vấn
        while (rs.next()) {
            String employeeID = rs.getString("Employee_ID");
            String nameOfEmployee = rs.getString("Name_Of_Employee");
            String department = rs.getString("Employee_Department");
            String dateOfBirth = rs.getString("Date_Of_Birth");
            String attendanceDate = rs.getString("Attendence_Date");

            // Thêm dữ liệu vào bảng
            model.addRow(new Object[]{
                employeeID,           // ID nhân viên
                department,           // Phòng ban
                nameOfEmployee,       // Tên nhân viên
                dateOfBirth,          // Ngày sinh
                attendanceDate        // Ngày chấm công
            });
        }

        // Đóng kết quả và PreparedStatement
        rs.close();
        pst.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi thao tác với cơ sở dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_viewActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // Xóa nội dung trong các ô nhập liệu
        clearForm();
        txt_id.setEnabled(true);
        DisableForm();
        txt_id.setBackground(Color.WHITE);
        txt_date.setBackground(Color.WHITE);
        txt_attendence.setText("");
        // Nếu có thể reset lại lựa chọn trong combo box
        cb_department.setSelectedIndex(-1); // Đặt lựa chọn về mặc định nếu cần
    }//GEN-LAST:event_btn_clearActionPerformed
    
   
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       // Lấy chỉ số của hàng được chọn
        int selectedRow = jTable_attendence.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên để cập nhật", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy Employee ID từ dòng được chọn
        String employeeID = (String) jTable_attendence.getValueAt(selectedRow, 0); // ID
        String attendanceDate = txt_date.getText().trim(); // Ngày chấm công

        // Kiểm tra thông tin
        if (attendanceDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày chấm công để cập nhật", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt_date.setBackground(Color.PINK); // Đổi màu nền ô nhập liệu thành đỏ
            return;
        } else {
            txt_date.setBackground(Color.WHITE); // Đặt lại màu nền
        }

        // Thử các định dạng ngày
        String[] possibleDateFormats = { "dd/MM/yyyy", "yyyy-MM-dd", "dd-MM-yyyy" };
        java.sql.Date sqlDate = null;

        for (String format : possibleDateFormats) {
            try {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
                LocalDate parsedDate = LocalDate.parse(attendanceDate, dateFormatter);
                sqlDate = java.sql.Date.valueOf(parsedDate);
                break;
            } catch (DateTimeParseException e) {
                // Không làm gì, thử định dạng khác
            }
        }

        if (sqlDate == null) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra xem nhân viên đã chấm công vào ngày này chưa
        try {
            if (EmployeeAttendance.isAttendanceRecorded(employeeID, sqlDate)) {
                JOptionPane.showMessageDialog(this, "Nhân viên đã được chấm công vào ngày này", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return; // Dừng lại nếu đã có bản ghi
            }

            // Cập nhật thông tin ngày chấm công trong cơ sở dữ liệu
            if (EmployeeAttendance.updateAttendance(employeeID, sqlDate)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                // Cập nhật lại thông tin trên bảng
                jTable_attendence.setValueAt(attendanceDate, selectedRow, 4); // Cập nhật ngày chấm công trong bảng

                // Dọn dẹp các ô nhập liệu và thiết lập lại trạng thái nhập liệu
                txt_id.setText("");
                txt_name.setText("");
                txt_birth.setText("");
                txt_date.setText("");

                // Đặt lại trạng thái các trường nhập liệu
                txt_id.setEnabled(true);
                cb_department.setEnabled(false);
                txt_name.setEnabled(false);
                txt_birth.setEnabled(false);
                txt_date.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin chấm công để cập nhật", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối đến cơ sở dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        clearForm();
    }//GEN-LAST:event_btn_updateActionPerformed
    
    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // Lấy Employee ID và Attendance Date từ các ô nhập
        String employeeID = txt_id.getText().trim();
        String attendenceDateInput = txt_date.getText().trim();

        if (employeeID.isEmpty() || attendenceDateInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hiển thị hộp thoại xác nhận xóa
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc muốn xóa thông tin chấm công của nhân viên này không?", 
            "Xác nhận xóa", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE);

        if (confirm != JOptionPane.YES_OPTION) {
            // Nếu người dùng không chọn "Yes", thoát khỏi phương thức
            return;
        }

        // Xử lý các định dạng ngày
        SimpleDateFormat[] dateFormats = {
            new SimpleDateFormat("dd/MM/yyyy"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("dd-MM-yyyy")
        };

        java.util.Date attendenceDate = null;
        for (SimpleDateFormat format : dateFormats) {
            try {
                format.setLenient(false);
                attendenceDate = format.parse(attendenceDateInput);
                break;
            } catch (ParseException e) {
                // Không làm gì, thử định dạng khác
            }
        }

        if (attendenceDate == null) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày tháng không hợp lệ", "Lỗi định dạng ngày", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Định dạng lại ngày thành chuẩn 'yyyy-MM-dd'
        java.sql.Date sqlAttendenceDate = new java.sql.Date(attendenceDate.getTime());

        try {
            // Gọi phương thức removeAttendance từ EmployeeAttendance để xóa thông tin chấm công
            boolean success = EmployeeAttendance.removeAttendance(employeeID, sqlAttendenceDate);

            if (success) {
                JOptionPane.showMessageDialog(this, "Xóa thông tin chấm công thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                txt_id.setText("");
                txt_date.setText("");

                txt_id.setEnabled(true);
                cb_department.setEnabled(true);
                txt_name.setEnabled(true);
                txt_birth.setEnabled(true);

                // Làm mới bảng sau khi xóa
                btn_viewActionPerformed(evt); // Gọi lại hàm để làm mới bảng

            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin chấm công với Employee ID và ngày này", "Không tìm thấy", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối đến cơ sở dữ liệu", "Lỗi cơ sở dữ liệu", JOptionPane.ERROR_MESSAGE);
        }
        // Dọn dẹp và disable các trường nhập liệu sau khi xóa
        DisableForm();
        clearForm();
    }//GEN-LAST:event_btn_removeActionPerformed
    private void clearForm() {
        txt_id.setText("");
        txt_name.setText("");
        txt_birth.setText("");
        txt_date.setText("");
        
    }
    private void txt_birthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_birthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_birthActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Lấy ngày chấm công từ TextField (hoặc JDateChooser)
        String attendanceDate = txt_date.getText().trim();

        if (attendanceDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày chấm công", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        java.sql.Date sqlDate = null;
        String[] possibleDateFormats = { "dd/MM/yyyy", "yyyy-MM-dd", "dd-MM-yyyy" };

        // Thử từng định dạng ngày
        for (String format : possibleDateFormats) {
            try {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
                LocalDate parsedDate = LocalDate.parse(attendanceDate, dateFormatter); // Chuyển chuỗi thành LocalDate
                sqlDate = java.sql.Date.valueOf(parsedDate); // Chuyển LocalDate sang java.sql.Date
                break; // Nếu định dạng đúng, thoát khỏi vòng lặp
            } catch (DateTimeParseException e) {
                // Không làm gì, tiếp tục thử định dạng khác
            }
        }

        // Nếu không định dạng nào đúng
        if (sqlDate == null) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng sử dụng dd/MM/yyyy, yyyy-MM-dd, hoặc dd-MM-yyyy", "Lỗi định dạng ngày", JOptionPane.ERROR_MESSAGE);
            txt_date.setBackground(Color.PINK); // Đổi màu nền của txt_date thành màu đỏ
            return;
        } else {
            txt_date.setBackground(Color.WHITE); // Đặt lại nền trắng nếu hợp lệ
        }

        // Tìm kiếm thông tin nhân viên đã được chấm công vào ngày đó
        ResultSet rs = null;
        DefaultTableModel model = (DefaultTableModel) jTable_attendence.getModel();
        model.setRowCount(0);  // Xóa các dòng cũ trong bảng

        try {
            // Tìm kiếm thông tin từ cơ sở dữ liệu
            rs = EmployeeAttendance.searchEmployeeAttendanceByDate(sqlDate.toString()); // Giả sử phương thức này nhận chuỗi ngày trong định dạng yyyy-MM-dd

            // Kiểm tra kết quả truy vấn
            while (rs.next()) {
                // Lấy thông tin từ kết quả truy vấn
                String employeeID = rs.getString("Employee_ID");
                String nameOfEmployee = rs.getString("Name_Of_Employee");
                String department = rs.getString("Employee_Department");
                String dateOfBirth = rs.getString("Date_Of_Birth");
                String attendenceDateFromDB = rs.getString("Attendence_Date");

                // Hiển thị thông tin vào các TextField
                txt_id.setText(employeeID != null ? employeeID : "");
                txt_name.setText(nameOfEmployee != null ? nameOfEmployee : "");
                txt_birth.setText(dateOfBirth != null ? dateOfBirth : "");
                txt_date.setText(attendenceDateFromDB != null ? attendenceDateFromDB : "");

                // Hiển thị thông tin vào jTable
                model.addRow(new Object[]{employeeID, nameOfEmployee, department, dateOfBirth, attendenceDateFromDB});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi kết nối đến cơ sở dữ liệu", "Lỗi cơ sở dữ liệu", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đảm bảo đóng tài nguyên
            EmployeeAttendance.closeResources(null, null, rs);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Attendence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendence().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_attendence;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_view;
    private javax.swing.JComboBox<String> cb_department;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_attendence;
    private javax.swing.JTextArea txt_attendence;
    private javax.swing.JTextField txt_birth;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables

    
}

