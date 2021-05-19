package office.management.OfficeManagement.DAO.report.ReportClass;


public class ProjectCount {

    private Integer proCount;
    private Integer empCount;
    private Integer deptCount;
    public ProjectCount() {
    }

    public ProjectCount(Integer proCount, Integer empCount, Integer deptCount) {
        this.proCount = proCount;
        this.empCount = empCount;
        this.deptCount = deptCount;
    }

    public Integer getProCount() {
        return proCount;
    }

    public void setProCount(Integer proCount) {
        this.proCount = proCount;
    }

    public Integer getEmpCount() {
        return empCount;
    }

    public void setEmpCount(Integer empCount) {
        this.empCount = empCount;
    }

    public Integer getDeptCount() {
        return deptCount;
    }

    public void setDeptCount(Integer deptCount) {
        this.deptCount = deptCount;
    }

    @Override
    public String toString() {
        return "ProjectCount{" +
                "proCount=" + proCount +
                ", empCount=" + empCount +
                ", deptCount=" + deptCount +
                '}';
    }
}
