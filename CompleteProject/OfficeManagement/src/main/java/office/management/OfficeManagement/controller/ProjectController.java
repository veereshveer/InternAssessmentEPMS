package office.management.OfficeManagement.controller;

import lombok.RequiredArgsConstructor;
import office.management.OfficeManagement.DAO.dto.ProjectDto;
import office.management.OfficeManagement.DAO.model.Project;
import office.management.OfficeManagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProjectDto> findByProjectId(@PathVariable("id") Integer id){
        ProjectDto findProjectById= projectService.findByProjectId(id);
        return new ResponseEntity<>(findProjectById, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<ProjectDto>> findAllByProjectIds(){
        return new ResponseEntity<>(projectService.findAllByProjectIds(),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteByProjectId(@PathVariable("id") Integer id){
        projectService.deleteByProjectId(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/")
    public ResponseEntity<ProjectDto> addProject(@RequestBody Project project){
        ProjectDto addDto=projectService.addProject(project);
        return new ResponseEntity<>(addDto,HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<ProjectDto> CountOfProject(){
        long countOfProject= projectService.CountOfProject();
        return new ResponseEntity(countOfProject, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Integer id, @RequestBody ProjectDto projectUpdateDto){
        ProjectDto updateDto = projectService.updateProject(id,projectUpdateDto);
        return new ResponseEntity<>(updateDto,HttpStatus.OK);
    }

}
