CREATE DATABASE EmployeeManagement;
GO

-- Sử dụng cơ sở dữ liệu vừa tạo
USE EmployeeManagement;
GO
CREATE TABLE Add_Employee (
    Employee_ID INT PRIMARY KEY,
    Employee_Department NVARCHAR(50),
    Name_Of_Employee NVARCHAR(100),
    Date_Of_Birth DATE,
    Phone_Number NVARCHAR(15),
    Email NVARCHAR(100),
    Basic_salary DECIMAL(10, 2),
    Address NVARCHAR(255),
    Gender NVARCHAR(10)
);

-- Tạo bảng Salary
CREATE TABLE Salary (
    Employee_ID INT PRIMARY KEY,
    Pay_day DATE,
    Basic_salary DECIMAL(10, 2),
    Bonus DECIMAL(10, 2),
    Coefficients_salary DECIMAL(5, 2),
    Salary DECIMAL(15, 2),
    FOREIGN KEY (Employee_ID) REFERENCES Add_Employee(Employee_ID) ON DELETE CASCADE
);

-- Tạo bảng Attendence
CREATE TABLE Attendence (
    Employee_ID INT,
    Attendence_Date DATE,
    FOREIGN KEY (Employee_ID) REFERENCES Add_Employee(Employee_ID) ON DELETE CASCADE
);

-- Tạo bảng Login
CREATE TABLE Login (
    UserName NVARCHAR(50) PRIMARY KEY,
    Password NVARCHAR(255)
);

INSERT INTO Add_Employee (Employee_ID, Employee_Department, Name_Of_Employee, Date_Of_Birth, Phone_Number, Email, Basic_salary, Address, Gender)
VALUES
(1, N'Quản lý', N'Phùng Tiến Đạt', '1990-01-01', '0123456789', 'a@example.com', 10000000, N'Hà Nội', 'Male'),
(2, N'Thực tập sinh', N'Nguyễn Thị Linh', '1985-05-15', '0987654321', 'b@example.com', 8000000, N'Hồ Chí Minh', 'Female'),
(3, N'Thư ký', N'Nguyễn Thị Trang', '1986-03-21', '0978123456', 'c@example.com', 8500000, N'Hà Nội', 'Female'),
(4, N'Giám đốc', N'Nguyễn Văn Tùng', '1987-09-11', '0961234567', 'd@example.com', 15000000, N'Đà Nẵng', 'Male'),
(5, N'Kế toán', N'Nguyễn Hà Anh', '1988-12-25', '0912345678', 'e@example.com', 9000000, N'Hải Phòng', 'Female'),
(6, N'Nhân viên', N'Phạm Văn Hùng', '1991-07-10', '0987543210', 'f@example.com', 12000000, N'Hà Nội', 'Male'),
(7, N'Bảo vệ', N'Lê Minh Tuấn', '1992-04-18', '0934123456', 'g@example.com', 7000000, N'Hà Nội', 'Male'),
(8, N'Thực tập sinh', N'Hoàng Thị Hạnh', '1993-06-14', '0945236789', 'h@example.com', 7500000, N'Bắc Ninh', 'Female'),
(9, N'Nhân viên', N'Trần Văn Long', '1994-10-05', '0923456781', 'i@example.com', 11000000, N'Quảng Ninh', 'Male'),
(10, N'Nhân viên', N'Nguyễn Ngọc Anh', '1995-02-02', '0911223344', 'j@example.com', 9500000, N'Huế', 'Female');


-- Thêm lương
INSERT INTO Salary (Employee_ID, Pay_day, Basic_salary, Bonus, Coefficients_salary, Salary)
VALUES
(1, '2024-01-31', 10000000, 2000000, 1.2, 14400000),
(2, '2024-01-30', 8000000, 1000000, 1.1, 9900000),
(3, '2024-01-29', 8500000, 1500000, 1.15, 11575000),
(4, '2024-01-28', 15000000, 3000000, 1.25, 22500000),
(5, '2024-01-27', 9000000, 1800000, 1.2, 12960000),
(6, '2024-01-26', 12000000, 2400000, 1.3, 18720000),
(7, '2024-01-25', 7000000, 700000, 1.05, 7875000),
(8, '2024-01-24', 7500000, 750000, 1.1, 9075000),
(9, '2024-01-23', 11000000, 2200000, 1.3, 17160000),
(10, '2024-01-22', 9500000, 1900000, 1.25, 14250000);


-- Thêm chấm công
INSERT INTO Attendence (Employee_ID,  Attendence_Date)
VALUES
(1, '2024-11-15'),
(2, '2024-11-15'),
(3, '2024-11-14'),
(4, '2024-11-13'),
(5, '2024-11-12'),
(6, '2024-11-11'),
(7, '2024-11-10'),
(8, '2024-11-09'),
(9, '2024-11-08'),
(10,'2024-11-07');


-- Thêm tài khoản đăng nhập
INSERT INTO Login (UserName, Password)
VALUES
('admin', '12345'),
('admin2', '12345');

CREATE TRIGGER trg_UpdateEmployee
ON Add_Employee
AFTER UPDATE
AS
BEGIN
    UPDATE Salary
    SET Basic_salary = INSERTED.Basic_salary
    FROM Salary
    INNER JOIN INSERTED ON Salary.Employee_ID = INSERTED.Employee_ID;

    UPDATE Attendence
    SET Attendence_Date = GETDATE()
    FROM Attendence
    INNER JOIN INSERTED ON Attendence.Employee_ID = INSERTED.Employee_ID;
END