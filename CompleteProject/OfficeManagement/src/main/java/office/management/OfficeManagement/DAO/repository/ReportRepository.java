package office.management.OfficeManagement.DAO.repository;

import office.management.OfficeManagement.DAO.model.Employee;
import office.management.OfficeManagement.DAO.report.ReportInterface.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReportRepository extends JpaRepository <Employee, Integer>{

    @Query(value = "SELECT COUNT(DISTINCT e.Emp_Id) AS empCount, "
            +" COUNT(DISTINCT p.Project_Id) AS proCount, "
            +" COUNT(DISTINCT d.Dept_Id) AS deptCount "
            +" FROM employee e, project p, department d", nativeQuery = true)
    ProjectCountInterface getProjectCount();

    @Query(value = "SELECT name AS deptName , count(*) AS countEmpDept  FROM department  JOIN employee on employee.Dept_Id = department.Dept_Id  group by name;", nativeQuery = true )
    List<EmployeeSummaryInterface> groupOfEmpPro();

    @Query(value = " SELECT employee.Full_Name AS name, employee.Emp_Code AS empCode,employee.Email AS email, department.Name AS deptName, project.name AS proName FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee ON employee.Emp_id=employee_relation.emp_id JOIN department ON department.Dept_Id= employee.dept_id ", nativeQuery = true)
    List<EmpAllDetailsInterface> EmpAllDetail();

    @Query(value = "SELECT project.Name AS proName, COUNT(employee.Emp_Id) AS countEmpPro FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee employee ON employee.Emp_id=employee_relation.emp_id group by project.Name", nativeQuery = true )
    List<ProjectSummaryInterface> proSummary();

    @Query(value = " SELECT count(Emp_Id) AS empCount, Emp_join_date AS joinDate FROM employee group by Emp_join_date ", nativeQuery = true )
    List<EmpJoinSummaryInterface> empJoinSummary();

    @Query(value = " SELECT employee.Full_Name AS name, employee.Emp_Code AS empCode,employee.Email AS email, department.Name AS deptName, project.name AS proName FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee ON employee.Emp_id=employee_relation.emp_id JOIN department ON department.Dept_Id= employee.dept_id WHERE employee.Full_Name =:empName ", nativeQuery = true)
    List<EmpAllDetailsInterface>  AdvanceSearchEmpName(@Param("empName") String employeeName);

    @Query(value = " SELECT employee.Full_Name AS name, employee.Emp_Code AS empCode,employee.Email AS email, department.Name AS deptName, project.name AS proName FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee ON employee.Emp_id=employee_relation.emp_id JOIN department ON department.Dept_Id= employee.dept_id WHERE employee.Emp_Code = :empCode ", nativeQuery = true)
    List<EmpAllDetailsInterface>  AdvanceSearchEmpCode(@Param("empCode") String employeeCode);

    @Query(value = " SELECT employee.Full_Name AS name, employee.Emp_Code AS empCode,employee.Email AS email, department.Name AS deptName, project.name AS proName FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee ON employee.Emp_id=employee_relation.emp_id JOIN department ON department.Dept_Id= employee.dept_id WHERE project.Name=:proName ", nativeQuery = true)
    List<EmpAllDetailsInterface>  AdvanceSearchProName(@Param("proName") String projectName);

    @Query(value = "SELECT employee.Full_Name AS name, employee.Emp_Code AS empCode,employee.Email AS email, department.Name AS deptName, project.name AS proName FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee ON employee.Emp_id=employee_relation.emp_id JOIN department ON department.Dept_Id= employee.dept_id WHERE project.Project_Code=:proCode ", nativeQuery = true)
    List<EmpAllDetailsInterface>  AdvanceSearchProCode( @Param("proCode") String projectCode);

    @Query(value = " SELECT employee.Full_Name AS name, employee.Emp_Code AS empCode,employee.Email AS email, department.Name AS deptName, project.name AS proName FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee ON employee.Emp_id=employee_relation.emp_id JOIN department ON department.Dept_Id= employee.dept_id WHERE department.Name=:deptName ", nativeQuery = true)
    List<EmpAllDetailsInterface>  AdvanceSearchDeptName(@Param("deptName") String departmentName);

    @Query(value = " SELECT employee.Full_Name AS name, employee.Emp_Code AS empCode,employee.Email AS email, department.Name AS deptName, project.name AS proName FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee ON employee.Emp_id=employee_relation.emp_id JOIN department ON department.Dept_Id= employee.dept_id WHERE employee.Full_Name =:empName AND project.Name=:proName", nativeQuery = true)
    List<EmpAllDetailsInterface>  AdvanceSearchEmpProName(@Param("empName") String employeeName , @Param("proName") String projectName);

    @Query(value = " SELECT employee.Full_Name AS name, employee.Emp_Code AS empCode,employee.Email AS email, department.Name AS deptName, project.name AS proName FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee ON employee.Emp_id=employee_relation.emp_id JOIN department ON department.Dept_Id= employee.dept_id WHERE employee.Full_Name =:empName AND department.Name=:deptName ", nativeQuery = true)
    List<EmpAllDetailsInterface>  AdvanceSearchEmpDeptName(@Param("empName") String employeeName , @Param("deptName") String departmentName);

    @Query(value = " SELECT employee.Full_Name AS name, employee.Emp_Code AS empCode,employee.Email AS email, department.Name AS deptName, project.name AS proName FROM project JOIN employee_relation  ON project.Project_Id = employee_relation.project_id JOIN employee ON employee.Emp_id=employee_relation.emp_id JOIN department ON department.Dept_Id= employee.dept_id WHERE employee.Full_Name =:empName  AND project.Name=:proName AND department.Name=:deptName ", nativeQuery = true)
    List<EmpAllDetailsInterface>  AdvanceSearchEmpProDeptName(@Param("empName") String employeeName , @Param("proName") String projectName , @Param("deptName") String departmentName);

}
