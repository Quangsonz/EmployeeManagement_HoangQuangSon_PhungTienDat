package model;

import connect.ConnectToSQL;
import java.sql.*;

public class EmployeeSalary {

    // Kết nối cơ sở dữ liệu
    public static Connection getConnection() {
        return ConnectToSQL.getConnection();
    }

    // Kiểm tra xem thông tin lương có tồn tại hay không
    public boolean isSalaryExist(String employeeID) throws SQLException {
        String sql = "SELECT Employee_ID FROM Salary WHERE Employee_ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, employeeID);
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next(); // Trả về true nếu có kết quả
            }
        }
    }
    

    // Lấy thông tin nhân viên từ bảng Add_Employee
    public ResultSet getEmployeeDetails(String employeeID) throws SQLException {
        String sql = "SELECT Name_Of_Employee, Employee_Department, Date_Of_Birth, Basic_salary FROM Add_Employee WHERE Employee_ID = ?";
        Connection conn = getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, employeeID);
        return pst.executeQuery();
    }
    public ResultSet getSalaryDetailsByEmployeeID(String employeeID) throws SQLException {
        String sql = """
                     SELECT s.Pay_day, s.Basic_salary, s.Bonus, s.Coefficients_salary, 
                            (s.Basic_salary * s.Coefficients_salary + s.Bonus) AS Salary
                     FROM Salary s
                     WHERE s.Employee_ID = ?;
                     """;
        Connection conn = getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, employeeID);
        return pst.executeQuery();
    }


    // Tính tổng lương
    public double calculateTotalSalary(double basicSalary, double coefficientsSalary, double bonus) {
        return (basicSalary * coefficientsSalary) + bonus;
    }

    // Thêm hoặc cập nhật lương vào bảng Salary
    public void upsertSalary(String employeeID, String payDay, double basicSalary, double bonus, double coefficientsSalary, double totalSalary) throws SQLException {
        String sql = """
                     MERGE INTO Salary AS target
                     USING (SELECT ? AS Employee_ID) AS source
                     ON target.Employee_ID = source.Employee_ID
                     WHEN MATCHED THEN
                         UPDATE SET Pay_day = ?, Basic_salary = ?, Bonus = ?, Coefficients_salary = ?, Salary = ?
                     WHEN NOT MATCHED THEN
                         INSERT (Employee_ID, Pay_day, Basic_salary, Bonus, Coefficients_salary, Salary)
                         VALUES (?, ?, ?, ?, ?, ?);
                     """;
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, employeeID);
            pst.setString(2, payDay);
            pst.setDouble(3, basicSalary);
            pst.setDouble(4, bonus);
            pst.setDouble(5, coefficientsSalary);
            pst.setDouble(6, totalSalary);
            pst.setString(7, employeeID);
            pst.setString(8, payDay);
            pst.setDouble(9, basicSalary);
            pst.setDouble(10, bonus);
            pst.setDouble(11, coefficientsSalary);
            pst.setDouble(12, totalSalary);
            pst.executeUpdate();
        }
    }
    // Xóa thông tin lương từ bảng Salary
    public boolean deleteSalary(String employeeID) throws SQLException {
        String sql = "DELETE FROM Salary WHERE Employee_ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, employeeID);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu xóa thành công
        }
    }
    // Cập nhật thông tin lương nhân viên
    public boolean updateSalary(String employeeID, String payDay, double basicSalary, double bonus, double coefficientsSalary, double totalSalary) throws SQLException {
        String sql = "UPDATE Salary SET Pay_day = ?, Basic_salary = ?, Bonus = ?, Coefficients_salary = ?, Salary = ? WHERE Employee_ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, payDay);
            pst.setDouble(2, basicSalary);
            pst.setDouble(3, bonus);
            pst.setDouble(4, coefficientsSalary);
            pst.setDouble(5, totalSalary);
            pst.setString(6, employeeID);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        }
    }

    // Lấy toàn bộ thông tin lương của nhân viên để hiển thị lên JTable
    public ResultSet getAllSalaries() throws SQLException {
        String sql = """
                     SELECT e.Employee_ID, e.Name_Of_Employee, e.Employee_Department, e.Date_Of_Birth, 
                            s.Pay_day, e.Basic_salary, s.Bonus, s.Coefficients_salary, 
                            (e.Basic_salary * s.Coefficients_salary + s.Bonus) AS Salary
                     FROM Add_Employee e
                     INNER JOIN Salary s ON e.Employee_ID = s.Employee_ID;
                     """;
        Connection conn = getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        return pst.executeQuery();
    }
}
