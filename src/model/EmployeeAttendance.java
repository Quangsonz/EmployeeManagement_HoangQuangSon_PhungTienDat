package model;

import connect.ConnectToSQL;
import java.sql.*;

public class EmployeeAttendance {

    // Kết nối đến cơ sở dữ liệu
    public static Connection getConnection() {
        return ConnectToSQL.getConnection();  // Gọi phương thức getConnection từ ConnectToSQL
    }
    
    public static ResultSet searchEmployeeFromAddEmployee(String employeeID) throws SQLException {
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("Không thể kết nối tới cơ sở dữ liệu.");
        }

        // Truy vấn lấy thông tin chỉ từ bảng Add_Employee
        String sql = """
            SELECT ae.Employee_ID, ae.Name_Of_Employee, ae.Employee_Department, ae.Date_Of_Birth
            FROM Add_Employee ae
            WHERE ae.Employee_ID = ?;
        """;

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, employeeID);
        return pst.executeQuery();
    }
    public static ResultSet searchEmployeeAttendanceByDate(String attendanceDate) throws SQLException {
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("Không thể kết nối tới cơ sở dữ liệu.");
        }

        // Truy vấn lấy thông tin từ Add_Employee và Attendence theo ngày chấm công
        String sql = """
            SELECT ae.Employee_ID, ae.Name_Of_Employee, ae.Employee_Department, ae.Date_Of_Birth, a.Attendence_Date
            FROM Add_Employee ae
            JOIN Attendence a ON ae.Employee_ID = a.Employee_ID
            WHERE a.Attendence_Date = ?;
        """;

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, attendanceDate);  // Set ngày chấm công
        return pst.executeQuery();
    }



    // Kiểm tra nhân viên đã chấm công chưa
    public static boolean isAttendanceRecorded(String employeeID, java.sql.Date attendanceDate) throws SQLException {
        String sqlCheck = "SELECT COUNT(*) FROM Attendence WHERE Employee_ID = ? AND Attendence_Date = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement pstCheck = conn.prepareStatement(sqlCheck)) {
            pstCheck.setString(1, employeeID);  // Thiết lập Employee ID
            pstCheck.setDate(2, attendanceDate); // Thiết lập Attendance Date
            ResultSet rsCheck = pstCheck.executeQuery();
            rsCheck.next();  // Di chuyển con trỏ đến dòng kết quả đầu tiên
            return rsCheck.getInt(1) > 0;  // Trả về true nếu có dữ liệu
        }
    }

    // Thêm thông tin chấm công vào bảng Attendence
    public static boolean addAttendance(int employeeID, java.sql.Date attendanceDate) throws SQLException {
        String sqlInsert = "INSERT INTO Attendence (Employee_ID, Attendence_Date) VALUES (?, ?)";
        try (Connection conn = getConnection(); 
             PreparedStatement pstInsert = conn.prepareStatement(sqlInsert)) {
            pstInsert.setInt(1, employeeID);       // Thiết lập Employee ID
            pstInsert.setDate(2, attendanceDate);   // Thiết lập Attendance Date
            int rowsAffected = pstInsert.executeUpdate(); // Thực thi câu lệnh và kiểm tra số dòng bị ảnh hưởng
            return rowsAffected > 0;  // Trả về true nếu đã thêm thành công
        }
    }

     // Cập nhật ngày chấm công
    public static boolean updateAttendance(String employeeID, java.sql.Date attendanceDate) throws SQLException {
        String sqlUpdate = "UPDATE Attendence SET Attendence_Date = ? WHERE Employee_ID = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdate)) {
            pstUpdate.setDate(1, attendanceDate);   // Đặt Attendance Date mới
            pstUpdate.setString(2, employeeID);     // Đặt Employee ID
            int rowsAffected = pstUpdate.executeUpdate(); // Thực thi câu lệnh và kiểm tra số dòng bị ảnh hưởng
            return rowsAffected > 0;  // Trả về true nếu cập nhật thành công
        }
    }

    // Xóa thông tin chấm công
    public static boolean removeAttendance(String employeeID, java.sql.Date attendenceDate) throws SQLException {
        String sqlDelete = "DELETE FROM Attendence WHERE Employee_ID = ? AND Attendence_Date = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement pstDelete = conn.prepareStatement(sqlDelete)) {
            pstDelete.setString(1, employeeID);    // Thiết lập Employee ID
            pstDelete.setDate(2, attendenceDate);   // Thiết lập Attendance Date
            int rowsAffected = pstDelete.executeUpdate();  // Thực thi câu lệnh xóa
            return rowsAffected > 0;  // Trả về true nếu xóa thành công
        }
    }

    // Đóng kết nối và tài nguyên
    public static void closeResources(Connection conn, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
