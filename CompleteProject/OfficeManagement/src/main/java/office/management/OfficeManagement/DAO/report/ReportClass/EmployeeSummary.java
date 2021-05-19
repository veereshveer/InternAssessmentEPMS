package office.management.OfficeManagement.DAO.report.ReportClass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeSummary {
    private String deptName;
    private Integer countEmpDept;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getCountEmpDept() {
        return countEmpDept;
    }

    public void setCountEmpDept(Integer countEmpDept) {
        this.countEmpDept = countEmpDept;
    }
}
