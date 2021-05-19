package office.management.OfficeManagement.DAO.mapper;

import office.management.OfficeManagement.DAO.dto.DepartmentDto;
import office.management.OfficeManagement.DAO.model.Department;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDto map(Department departmentDto);

    List<DepartmentDto> map(List<Department> departmentList);
}


