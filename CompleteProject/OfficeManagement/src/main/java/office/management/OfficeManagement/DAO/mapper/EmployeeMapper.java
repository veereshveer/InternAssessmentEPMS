package office.management.OfficeManagement.DAO.mapper;


import office.management.OfficeManagement.DAO.dto.CreateEmployeeDto;
import office.management.OfficeManagement.DAO.dto.EmployeeDto;
import office.management.OfficeManagement.DAO.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "department",ignore = true)
    EmployeeDto map(Employee employeeDto);

    List<EmployeeDto> map(List<Employee> employeeList);

    @Mapping(target = "projects",ignore = true )
    Employee map(CreateEmployeeDto createEmployeeDto);

}

