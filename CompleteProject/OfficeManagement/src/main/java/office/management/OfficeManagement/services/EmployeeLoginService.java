package office.management.OfficeManagement.services;

import office.management.OfficeManagement.DAO.dto.EmployeeLoginDto;
import office.management.OfficeManagement.DAO.mapper.EmployeeLoginMapper;
import office.management.OfficeManagement.DAO.model.EmployeeLogin;
import office.management.OfficeManagement.DAO.repository.EmployeeLoginRepository;
import office.management.OfficeManagement.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class EmployeeLoginService {

    @Autowired
    private EmployeeLoginRepository employeeLoginRepository;
    @Autowired
    private EmployeeLoginMapper employeeLoginMapper;

    public EmployeeLoginDto getLoginDetails(Integer id) {
        EmployeeLogin getEmployeeLogin = employeeLoginRepository.findByEmpId(id);
        System.out.print(getEmployeeLogin);
        return employeeLoginMapper.map(getEmployeeLogin);
    }

    public EmployeeLoginDto updateLoginDetails(Integer id,EmployeeLoginDto employeeLoginDto) {
        EmployeeLogin employeeLogin = employeeLoginRepository.findByEmpId(id);
        employeeLogin.setUserName(employeeLoginDto.getUserName());
        employeeLogin.setPassword(employeeLoginDto.getPassword());
        EmployeeLogin updateEmployeeLogin = employeeLoginRepository.save(employeeLogin);
        return employeeLoginMapper.map(updateEmployeeLogin);
    }

    public EmployeeLoginDto addLoginDetails(EmployeeLogin employeeLoginDto) {
        EmployeeLogin addEmployeeLogin = employeeLoginRepository.save(employeeLoginDto);
        return employeeLoginMapper.map(addEmployeeLogin);
    }

}
