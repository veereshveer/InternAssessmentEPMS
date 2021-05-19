package office.management.OfficeManagement.services;


import office.management.OfficeManagement.DAO.report.ReportInterface.*;
import office.management.OfficeManagement.DAO.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public ProjectCountInterface countOfProject() {
        return  reportRepository.getProjectCount();
    }

    public List<EmployeeSummaryInterface> groupOfEmpPro() {
        return  reportRepository.groupOfEmpPro();
    }

    public List<EmpAllDetailsInterface> EmpAllDetails() {
        return reportRepository.EmpAllDetail();
    }

    public List<EmpJoinSummaryInterface> empJoinSummary() {
        return  reportRepository.empJoinSummary();
    }

    public List<ProjectSummaryInterface> projectSummary() {
        return  reportRepository.proSummary();
    }

    public List<EmpAllDetailsInterface>  AdvanceSearch(String employeeName, String employeeCode, String projectName, String projectCode, String departmentName) {

        if(!(employeeCode.equals("null"))){
            return reportRepository.AdvanceSearchEmpCode(employeeCode);
        }
        else if ((!(employeeName.equals("null"))) && (!(projectName.equals("null"))) ){
            return reportRepository.AdvanceSearchEmpProName(employeeName,projectName);
        }
        else if ( (!(employeeName.equals("null"))) && (!(departmentName.equals("null")))){
            return reportRepository.AdvanceSearchEmpDeptName(employeeName,departmentName);
        }
        else if ( (!(employeeName.equals("null"))) && (!(departmentName.equals("null"))) && (!(projectName.equals("null"))) ){
            return reportRepository.AdvanceSearchEmpProDeptName(employeeName,projectName,departmentName);
        }
        else if ( (!(employeeName.equals("null"))) ){
            return reportRepository.AdvanceSearchEmpName(employeeName);
        }
        else if ((!(projectName.equals("null")))){
            return reportRepository.AdvanceSearchProName(projectName);
        }
        else if ((!(projectCode.equals("null")))){
            return reportRepository.AdvanceSearchProCode(projectCode);
        }
        else  if ((!(departmentName.equals("null")))){
            return reportRepository.AdvanceSearchDeptName(departmentName);
        }
        else return null;
}
}
