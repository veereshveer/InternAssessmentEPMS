package office.management.OfficeManagement.DAO.repository;

import office.management.OfficeManagement.DAO.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

    void deleteByProjectId(Integer id);

    Project findByProjectId(Integer id);

    List<Project> findAll();
}
