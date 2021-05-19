package office.management.OfficeManagement.DAO.mapper;

import office.management.OfficeManagement.DAO.dto.ProjectDto;
import office.management.OfficeManagement.DAO.model.Project;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDto map(Project projectDto);

    List<ProjectDto> map(List<Project> projectList);

}
