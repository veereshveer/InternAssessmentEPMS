package office.management.OfficeManagement.DAO.dto;

public class EmployeeLoginDto {
    private Integer loginId;
    private Integer empId;
    private String userName;
    private String password;
    private String lastLonginTime;

    public EmployeeLoginDto() {
    }

    public EmployeeLoginDto(Integer loginId, Integer empId, String userName, String password, String lastLonginTime) {
        this.loginId = loginId;
        this.empId = empId;
        this.userName = userName;
        this.password = password;
        this.lastLonginTime = lastLonginTime;
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

    @Override
    public String toString() {
        return "EmployeeLoginDto{" +
                "loginId=" + loginId +
                ", empId=" + empId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastLonginTime='" + lastLonginTime + '\'' +
                '}';
    }
}
