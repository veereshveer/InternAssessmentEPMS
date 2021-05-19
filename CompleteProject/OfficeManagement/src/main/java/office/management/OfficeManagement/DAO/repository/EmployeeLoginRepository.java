package office.management.OfficeManagement.DAO.repository;

import office.management.OfficeManagement.DAO.model.EmployeeLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLoginRepository  extends JpaRepository<EmployeeLogin, Integer> {

     EmployeeLogin findByEmpId(Integer id);


}
