package model;

import connect.ConnectToSQL;
import java.sql.*;

public class EmployeeService {

    // Phương thức kiểm tra xem nhân viên đã tồn tại trong cơ sở dữ liệu chưa
    public static boolean employeeExists(String employeeID) {
        Connection conn = ConnectToSQL.getConnection();
        if (conn == null) {
            return false; // Nếu không thể kết nối, trả về false
        }
        try {
            String checkEmployeeSQL = "SELECT * FROM Add_Employee WHERE Employee_ID = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkEmployeeSQL);
            checkStmt.setString(1, employeeID);
            ResultSet rs = checkStmt.executeQuery();
            return rs.next(); // Kiểm tra xem có kết quả không
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conn.close(); // Đảm bảo đóng kết nối sau khi sử dụng
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Phương thức thêm nhân viên vào cơ sở dữ liệu
    public static void addEmployee(String employeeID, String position, String employeeName, java.sql.Date birthDate, String phone, String email, String salary, String address, String gender) {
        Connection conn = ConnectToSQL.getConnection();
        if (conn == null) {
            System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
            return;
        }

        try {
            String insertSQL = "INSERT INTO Add_Employee (Employee_ID, Employee_Department, Name_Of_Employee, Date_Of_Birth, Phone_Number, Email, Basic_salary, Address, Gender) "
                               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
            insertStmt.setString(1, employeeID);
            insertStmt.setString(2, position);
            insertStmt.setString(3, employeeName);
            insertStmt.setDate(4, birthDate);
            insertStmt.setString(5, phone);
            insertStmt.setString(6, email);
            insertStmt.setString(7, salary);
            insertStmt.setString(8, address);
            insertStmt.setString(9, gender);
            insertStmt.executeUpdate();
            System.out.println("Thêm nhân viên thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close(); // Đảm bảo đóng kết nối
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // Phương thức tìm kiếm nhân viên theo ID
    public static Employee findEmployee(String employeeID) {
        Connection conn = ConnectToSQL.getConnection();
        if (conn == null) {
            return null; // Nếu không thể kết nối, trả về null
        }

        Employee employee = null;
        try {
            String selectSQL = "SELECT * FROM Add_Employee WHERE Employee_ID = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
            selectStmt.setString(1, employeeID);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                // Lấy dữ liệu từ kết quả truy vấn và tạo đối tượng Employee
                String position = rs.getString("Employee_Department");
                String name = rs.getString("Name_Of_Employee");
                java.sql.Date birthDate = rs.getDate("Date_Of_Birth");
                String phone = rs.getString("Phone_Number");
                String email = rs.getString("Email");
                String salary = rs.getString("Basic_salary");
                String address = rs.getString("Address");
                String gender = rs.getString("Gender");

                employee = new Employee(employeeID, position, name, birthDate, phone, email, salary, address, gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close(); // Đảm bảo đóng kết nối
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    // Phương thức sửa thông tin nhân viên
    public static void updateEmployee(String employeeID, String position, String employeeName, java.sql.Date birthDate, String phone, String email, String salary, String address, String gender) {
        Connection conn = ConnectToSQL.getConnection();
        if (conn == null) {
            System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
            return;
        }

        try {
            String updateSQL = "UPDATE Add_Employee SET Employee_Department = ?, Name_Of_Employee = ?, Date_Of_Birth = ?, Phone_Number = ?, Email = ?, Basic_salary = ?, Address = ?, Gender = ? "
                               + "WHERE Employee_ID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
            updateStmt.setString(1, position);
            updateStmt.setString(2, employeeName);
            updateStmt.setDate(3, birthDate);
            updateStmt.setString(4, phone);
            updateStmt.setString(5, email);
            updateStmt.setString(6, salary);
            updateStmt.setString(7, address);
            updateStmt.setString(8, gender);
            updateStmt.setString(9, employeeID);
            updateStmt.executeUpdate();
            System.out.println("Cập nhật thông tin nhân viên thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close(); // Đảm bảo đóng kết nối
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Phương thức xóa nhân viên khỏi cơ sở dữ liệu
    public static void deleteEmployee(String employeeID) {
        Connection conn = ConnectToSQL.getConnection();
        if (conn == null) {
            System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
            return;
        }

        try {
            String deleteSQL = "DELETE FROM Add_Employee WHERE Employee_ID = ?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL);
            deleteStmt.setString(1, employeeID);
            int rowsAffected = deleteStmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Xóa nhân viên thành công.");
            } else {
                System.out.println("Không tìm thấy nhân viên với ID: " + employeeID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close(); // Đảm bảo đóng kết nối
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
