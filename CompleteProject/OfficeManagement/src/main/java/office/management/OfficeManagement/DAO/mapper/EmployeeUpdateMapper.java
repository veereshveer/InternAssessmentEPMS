package office.management.OfficeManagement.DAO.mapper;

import office.management.OfficeManagement.DAO.dto.EmployeeUpdateDto;
import office.management.OfficeManagement.DAO.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeUpdateMapper {

    EmployeeUpdateDto map(Employee employeeUpdateDto);

}
