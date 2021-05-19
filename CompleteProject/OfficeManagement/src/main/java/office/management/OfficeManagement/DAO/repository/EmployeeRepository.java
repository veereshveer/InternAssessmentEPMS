package office.management.OfficeManagement.DAO.repository;

import office.management.OfficeManagement.DAO.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    Employee findByEmpId(Integer id);

    void deleteByEmpId(Integer id);

    List<Employee> findAll();

}
