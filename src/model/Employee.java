
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Employee {
    private String id;
    private String name;
    private String department;
    private String birthDate;  // Lưu ngày dưới dạng String
    private String phone;
    private String email;
    private String salary;
    private String address;
    private String gender;

    public Employee(String id, String department, String name, java.sql.Date birthDate, String phone, String email, String salary, String address, String gender) {
        this.id = id;
        this.department = department;
        this.name = name;
        
        // Chuyển đổi java.sql.Date thành String
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.birthDate = sdf.format(birthDate); // Lưu dưới dạng chuỗi

        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.gender = gender;
    }

    // Các phương thức getter cho tất cả các thuộc tính
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getBirthDate() {
        return birthDate;  // Trả về ngày sinh dưới dạng String
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }
}
