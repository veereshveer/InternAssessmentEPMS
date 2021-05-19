package office.management.OfficeManagement.DAO.report.ReportClass;

public class EmpJoinSummary {
    Integer empCount;
    String joinDate;

    public EmpJoinSummary() {
    }

    public EmpJoinSummary(Integer empCount, String joinDate) {
        this.empCount = empCount;
        this.joinDate = joinDate;
    }

    public Integer getEmpCount() {
        return empCount;
    }

    public void setEmpCount(Integer empCount) {
        this.empCount = empCount;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "EmpJoinSummary{" +
                "empCount=" + empCount +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }
}
