package office.management.OfficeManagement.DAO.report.ReportClass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectSummary {
    private Integer countEmpPro;
    private String proName;

    public Integer getCountEmpPro() {
        return countEmpPro;
    }

    public void setCountEmpPro(Integer countEmpPro) {
        this.countEmpPro = countEmpPro;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
