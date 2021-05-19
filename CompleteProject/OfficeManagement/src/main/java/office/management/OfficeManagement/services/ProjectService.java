package office.management.OfficeManagement.services;

import office.management.OfficeManagement.DAO.dto.ProjectDto;
import office.management.OfficeManagement.DAO.mapper.ProjectMapper;
import office.management.OfficeManagement.DAO.model.Project;
import office.management.OfficeManagement.DAO.repository.ProjectRepository;
import office.management.OfficeManagement.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectDto findByProjectId(Integer id) {
        Project project = projectRepository.findByProjectId(id);
        return projectMapper.map(project);
    }

    public List<ProjectDto> findAllByProjectIds() {
        List<Project> project = projectRepository.findAll();
        return projectMapper.map(project);
    }

    public void deleteByProjectId(Integer id){
        projectRepository.deleteByProjectId(id);
    }

    public ProjectDto addProject(@RequestBody Project projectDto){
        Project project = projectRepository.save(projectDto);
        Integer proId = project.getProjectId();
        project.setProjectCode("Pro-"+proId);
        Project updatedPro =  projectRepository.save(projectDto);
        return projectMapper.map(updatedPro);
    }

    public ProjectDto updateProject(Integer id, ProjectDto projectUpdateDto){
        Project project = projectRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id:  "+id+" not found"));
        project.setName(projectUpdateDto.getName());
        project.setUpdatedBy(projectUpdateDto.getUpdatedBy());
        project.setUpdatedDate(projectUpdateDto.getUpdatedDate());
        project.setDescription(projectUpdateDto.getDescription());
        projectRepository.save(project);
        return projectMapper.map(project);
    }

    public long CountOfProject() {
        return projectRepository.count();
    }

}
