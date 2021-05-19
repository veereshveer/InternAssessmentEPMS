package office.management.OfficeManagement.DAO.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "employee_login")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Login_Id")
    private Integer loginId;

    @Column(name = "Emp_Id")
    private  Integer empId;

    @Column(name = "Username")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "Last_Login_Time")
    private String lastLonginTime;

    @OneToOne
    @JoinColumn(name = "emp_Emp_Id",referencedColumnName = "Emp_Id")
    private Employee employeeID;

    public EmployeeLogin() {
    }

    public EmployeeLogin(Integer loginId, Integer empId, String userName, String password, String lastLonginTime, Employee employeeID) {
        this.loginId = loginId;
        this.empId = empId;
        this.userName = userName;
        this.password = password;
        this.lastLonginTime = lastLonginTime;
        this.employeeID = employeeID;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLonginTime() {
        return lastLonginTime;
    }

    public void setLastLonginTime(String lastLonginTime) {
        this.lastLonginTime = lastLonginTime;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "EmployeeLogin{" +
                "loginId=" + loginId +
                ", empId='" + empId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastLonginTime='" + lastLonginTime + '\'' +
                ", employeeID=" + employeeID +
                '}';
    }
}

