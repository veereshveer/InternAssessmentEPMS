package office.management.OfficeManagement.controller;

import office.management.OfficeManagement.DAO.dto.EmployeeLoginDto;
import office.management.OfficeManagement.DAO.model.EmployeeLogin;
import office.management.OfficeManagement.services.EmployeeLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/userLogin")
public class EmployeeLoginController {

    @Autowired
    private EmployeeLoginService employeeLoginService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeLoginDto> getAllLoginDetails(@PathVariable("id") Integer id){
        EmployeeLoginDto getLoginDto = employeeLoginService.getLoginDetails(id);
        return new ResponseEntity<>(getLoginDto, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EmployeeLoginDto> getAllLoginDetails(@PathVariable("id") Integer id, @RequestBody EmployeeLoginDto employeeLoginDto){
        EmployeeLoginDto getLoginDto = employeeLoginService.updateLoginDetails(id, employeeLoginDto);
        return new ResponseEntity<>(getLoginDto, HttpStatus.OK);
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<EmployeeLoginDto> getAllLoginDetails(@RequestBody EmployeeLogin employeeLoginDto){
        EmployeeLoginDto getLoginDto = employeeLoginService.addLoginDetails(employeeLoginDto);
        return new ResponseEntity<>(getLoginDto, HttpStatus.OK);
    }
}
