package office.management.OfficeManagement.DAO.repository;
import office.management.OfficeManagement.DAO.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByDeptId(Integer id);

    void deleteByDeptId(Integer id);

    List<Department> findAll();

}
