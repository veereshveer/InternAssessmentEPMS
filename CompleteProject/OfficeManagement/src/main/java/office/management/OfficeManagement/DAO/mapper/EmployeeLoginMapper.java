package office.management.OfficeManagement.DAO.mapper;

import office.management.OfficeManagement.DAO.dto.EmployeeLoginDto;
import office.management.OfficeManagement.DAO.model.EmployeeLogin;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeLoginMapper {

    EmployeeLoginDto map(EmployeeLogin employeeLogin);

    List<EmployeeLoginDto> map(List<EmployeeLogin> employeeLoginList);
}

