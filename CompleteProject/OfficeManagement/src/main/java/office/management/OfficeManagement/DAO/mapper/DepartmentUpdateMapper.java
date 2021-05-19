package office.management.OfficeManagement.DAO.mapper;


import office.management.OfficeManagement.DAO.dto.DepartmentUpdateDto;
import office.management.OfficeManagement.DAO.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentUpdateMapper {

    DepartmentUpdateDto map(Department departmentUpdateDto);
}
