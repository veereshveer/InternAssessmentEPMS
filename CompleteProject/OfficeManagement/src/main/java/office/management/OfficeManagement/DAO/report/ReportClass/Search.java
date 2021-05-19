package office.management.OfficeManagement.DAO.report.ReportClass;



public class Search {
     private String employeeName;
     private String employeeCode;
     private String projectName;
     private String projectCode;
     private String departmentName;

    public Search() {
    }

    public Search(String employeeName, String employeeCode, String projectName, String projectCode, String departmentName) {
        this.employeeName = employeeName;
        this.employeeCode = employeeCode;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.departmentName = departmentName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Search{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
