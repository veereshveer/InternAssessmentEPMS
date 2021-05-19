package office.management.OfficeManagement.services;

import office.management.OfficeManagement.DAO.dto.DepartmentDto;
import office.management.OfficeManagement.DAO.mapper.DepartmentMapper;
import office.management.OfficeManagement.DAO.model.Department;
import office.management.OfficeManagement.DAO.repository.DepartmentRepository;
import office.management.OfficeManagement.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDto findByDeptId(Integer id) {
        Department department = departmentRepository.findByDeptId(id);
        return departmentMapper.map(department);
    }

    public List<DepartmentDto> findAllByDeptIds() {
        List<Department> department = departmentRepository.findAll();
        return departmentMapper.map(department);
    }

    public void deleteByDeptId(Integer id){
        departmentRepository.deleteByDeptId(id);
    }

    public DepartmentDto addDepartment(@RequestBody Department departmentDto){
        Department department = departmentRepository.save(departmentDto);
        return departmentMapper.map(department);
    }

    public DepartmentDto updateDepartment(Integer id, DepartmentDto departmentUpdateDto){
        Department department = departmentRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id:  "+id+" not found"));
        department.setName(departmentUpdateDto.getName());
        department.setUpdatedBy(departmentUpdateDto.getUpdatedBy());
        department.setUpdatedDate(departmentUpdateDto.getUpdatedDate());
        department.setLocation(departmentUpdateDto.getLocation());
        department.setDescription(departmentUpdateDto.getDescription());
        departmentRepository.save(department);
        return departmentMapper.map(department);
    }

    public long CountOfDepartment() {
        return departmentRepository.count();
    }
}
