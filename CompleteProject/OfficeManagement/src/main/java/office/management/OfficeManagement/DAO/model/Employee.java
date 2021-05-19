package office.management.OfficeManagement.DAO.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@SQLDelete(sql = "update employee set Active=0")
@Where(clause = "Active=1")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Emp_Id")
    private Integer empId;

    @Column(name = "Emp_Code")
    private String empCode;

    @Column(name = "Full_Name")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Emp_join_date")
    private String empJoinDate;

    @Column(name = "Created_Date")
    private String createdDate;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Updated_Date")
    private String updatedDate;

    @Column(name = "Updated_By")
    private String updatedBy;

    @Column(name = "Dept_Id")
    private int deptId;

    @Column(name = "Active")
    private String active;

    @ManyToOne(cascade={CascadeType.DETACH})
    @JoinColumn(name = "emp_dept_id",referencedColumnName = "Dept_Id")

    private Department department;

    @ManyToMany(cascade={CascadeType.DETACH})
    @JoinTable(
            name = "employee_relation",
            joinColumns = @JoinColumn(name = "Emp_Id"),
            inverseJoinColumns = @JoinColumn(name = "Project_Id")
    )

    private List<Project> projects = new ArrayList<>();


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpJoinDate() {
        return empJoinDate;
    }

    public void setEmpJoinDate(String empJoinDate) {
        this.empJoinDate = empJoinDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getDept_Id() {
        return deptId;
    }

    public void setDept_Id(int dept_Id) {
        this.deptId = dept_Id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
