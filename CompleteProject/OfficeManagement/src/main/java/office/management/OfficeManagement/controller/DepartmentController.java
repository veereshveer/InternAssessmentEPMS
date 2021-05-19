package office.management.OfficeManagement.controller;

import office.management.OfficeManagement.DAO.dto.DepartmentDto;
import office.management.OfficeManagement.DAO.model.Department;
import office.management.OfficeManagement.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentDto> findByDeptId(@PathVariable("id") Integer id){
        DepartmentDto findDepartmentById= departmentService.findByDeptId(id);
        return new ResponseEntity<>(findDepartmentById, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteByDeptId(@PathVariable("id") Integer id){
        departmentService.deleteByDeptId(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/")
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody Department department){
        DepartmentDto addDto=departmentService.addDepartment(department);
        return new ResponseEntity<>(addDto,HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<DepartmentDto>> findAllByDeptIds(){
        return new ResponseEntity<>(departmentService.findAllByDeptIds(),HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<DepartmentDto> CountOfDepartment(){
        long countOfDepartment= departmentService.CountOfDepartment();
        return new ResponseEntity(countOfDepartment, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Integer id, @RequestBody DepartmentDto departmentUpdateDto){
        DepartmentDto updateDto = departmentService.updateDepartment(id,departmentUpdateDto);
        return new ResponseEntity<>(updateDto,HttpStatus.OK);
    }

}
