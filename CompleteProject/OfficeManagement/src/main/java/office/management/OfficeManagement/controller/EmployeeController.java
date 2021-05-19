package office.management.OfficeManagement.controller;

import lombok.RequiredArgsConstructor;
import office.management.OfficeManagement.DAO.dto.CreateEmployeeDto;
import office.management.OfficeManagement.DAO.dto.EmployeeDto;
import office.management.OfficeManagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeDto> findByEmpId(@PathVariable("id") Integer id){
        EmployeeDto findEmployeeById= employeeService.findByEmpId(id);
        return new ResponseEntity<>(findEmployeeById, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<EmployeeDto>> findAllByEmpIds(){
        List<EmployeeDto> empList= employeeService.findAllByEmpIds();
        return new ResponseEntity<>(empList,HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteByEmpId(@PathVariable("id") Integer id){
         employeeService.deleteByEmpId(id);
         return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EmployeeDto> updateEmployees(@PathVariable("id") Integer id,@RequestBody CreateEmployeeDto createEmployeeDto){
        EmployeeDto updatedDto= employeeService.updateEmployees(id,createEmployeeDto);
        return new ResponseEntity<>(updatedDto,HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<EmployeeDto> addEmployees(@RequestBody CreateEmployeeDto createEmployeeDto){
        EmployeeDto newEmp= employeeService.addEmployees(createEmployeeDto);
        return new ResponseEntity<>(newEmp,HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<EmployeeDto> CountOfEmployee(){
        long countOfEmployee= employeeService.CountOfEmployee();
        return new ResponseEntity(countOfEmployee, HttpStatus.OK);
    }

}

