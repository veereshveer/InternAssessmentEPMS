package office.management.OfficeManagement.services;

import office.management.OfficeManagement.DAO.dto.CreateEmployeeDto;
import office.management.OfficeManagement.DAO.dto.EmployeeDto;
import office.management.OfficeManagement.DAO.mapper.EmployeeMapper;
import office.management.OfficeManagement.DAO.model.Employee;
import office.management.OfficeManagement.DAO.model.EmployeeLogin;
import office.management.OfficeManagement.DAO.model.Project;
import office.management.OfficeManagement.DAO.repository.EmployeeLoginRepository;
import office.management.OfficeManagement.DAO.repository.EmployeeRepository;
import office.management.OfficeManagement.DAO.repository.ProjectRepository;
import office.management.OfficeManagement.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeLoginRepository employeeLoginRepository;

    public EmployeeDto findByEmpId(Integer id) {
        Employee employee = employeeRepository.findByEmpId(id);
        List<Project> projects = employee.getProjects();
        List<Integer> projectIds = projects.stream().map(project -> project.getProjectId()).collect(Collectors.toList());
        EmployeeDto empDto = employeeMapper.map(employee);
        empDto.setProjectIds(projectIds);
        return empDto;
    }

    public List<EmployeeDto> findAllByEmpIds() {
        List<Employee> employees = employeeRepository.findAll();
                return employeeMapper.map(employees);
    }

    public void deleteByEmpId(Integer id){
         employeeRepository.deleteByEmpId(id);
    }

    public EmployeeDto addEmployee(Employee employeeDto){
        Employee employee = employeeRepository.save(employeeDto);
        Integer empId = employee.getEmpId();
        employee.setEmpCode("Emp-"+empId);
        Employee updatedEmp = employeeRepository.save(employeeDto);
        return employeeMapper.map(updatedEmp);
    }

    public EmployeeDto addEmployees(CreateEmployeeDto createEmployeeDto){
        Employee employee = employeeMapper.map(createEmployeeDto);
        List<Integer> projectIds = createEmployeeDto.getProjectIds();
        List<Project> projects = projectRepository.findAllById(projectIds);
        employee.setProjects(projects);
        employee = employeeRepository.save(employee);
        Integer empId = employee.getEmpId();
        employee.setEmpCode("Emp-"+empId);
        employeeRepository.save(employee);
        EmployeeLogin employeeLogin =new EmployeeLogin();
        employeeLogin.setEmpId(employee.getEmpId());
        String empFullName= employee.getFullName();
        String empName = empFullName.replaceAll("\\s", "");
        employeeLogin.setUserName(empName+empId);
        employeeLogin.setPassword(empName+"@123");
        employeeLogin.setLastLonginTime(employee.getCreatedDate());
        employeeLoginRepository.save(employeeLogin);
        return employeeMapper.map(employee);
    }

    public EmployeeDto updateEmployees(Integer id, CreateEmployeeDto createEmployeeDto){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id:  "+id+" not found"));
        List<Integer> projectIds = createEmployeeDto.getProjectIds();
        List<Project> projects = projectRepository.findAllById(projectIds);
        employee.setEmpId(id);
        employee.setProjects(projects);
        employee.setFullName(createEmployeeDto.getFullName());
        employee.setEmail(createEmployeeDto.getEmail());
        employee.setUpdatedDate(createEmployeeDto.getUpdatedDate());
        employee.setUpdatedBy(createEmployeeDto.getUpdatedBy());
        employee.setDeptId(createEmployeeDto.getDeptId());
        employee = employeeRepository.save(employee);
        return employeeMapper.map(employee);
    }

    public long CountOfEmployee() {
        return employeeRepository.count();
    }

}
