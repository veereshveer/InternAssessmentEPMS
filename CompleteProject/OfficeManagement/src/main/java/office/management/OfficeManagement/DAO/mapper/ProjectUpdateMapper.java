package office.management.OfficeManagement.DAO.mapper;

import office.management.OfficeManagement.DAO.dto.ProjectUpdateDto;
import office.management.OfficeManagement.DAO.model.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectUpdateMapper {

    ProjectUpdateDto map(Project projectUpdateDto);
}
