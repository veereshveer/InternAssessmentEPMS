package office.management.OfficeManagement.controller;

import lombok.RequiredArgsConstructor;
import office.management.OfficeManagement.DAO.report.ReportClass.*;
import office.management.OfficeManagement.DAO.report.ReportInterface.*;
import office.management.OfficeManagement.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(path = "/count")
    public ResponseEntity<ProjectCount> groupOfEmployeeDepartment(){
        ProjectCountInterface pro= reportService.countOfProject();
        ProjectCount projectCount = new ProjectCount();
        projectCount.setProCount(pro.getProCount());
        projectCount.setDeptCount(pro.getDeptCount());
        projectCount.setEmpCount(pro.getEmpCount());
        return new ResponseEntity<>(projectCount, HttpStatus.OK);
    }

    @GetMapping(path = "/empSummary")
    public ResponseEntity<List<EmployeeSummary>> groupOfEmpPro(){
        List<EmployeeSummaryInterface> empSummaryInt=  reportService.groupOfEmpPro();
        List<EmployeeSummary> employeeSummary= new ArrayList<>();
        empSummaryInt.forEach((emp -> {
            EmployeeSummary empSummary = new EmployeeSummary();
            empSummary.setCountEmpDept(emp.getCountEmpDept());
            empSummary.setDeptName(emp.getDeptName());
            employeeSummary.add(empSummary);
        }));
        return new ResponseEntity<>(employeeSummary, HttpStatus.OK);
    }

    @GetMapping(path = "/proSummary")
    public ResponseEntity<List<ProjectSummary>> proSummary(){
        List<ProjectSummaryInterface> proSummaryInt=  reportService.projectSummary();
        List<ProjectSummary> projectSummary= new ArrayList<>();
        proSummaryInt.forEach((pro -> {
            ProjectSummary proSummary = new ProjectSummary();
            proSummary.setCountEmpPro(pro.getCountEmpPro());
            proSummary.setProName(pro.getProName());
            projectSummary.add(proSummary);
        }));
        return new ResponseEntity<>(projectSummary, HttpStatus.OK);
    }

    @GetMapping(path = "/empAllDetails")
    public ResponseEntity<List<EmpAllDetails>> empAllDetails(){
        List<EmpAllDetailsInterface> empAllDetails=  reportService.EmpAllDetails();
        List<EmpAllDetails> empAllDetails1= new ArrayList<>();
        empAllDetails.forEach((emp -> {
            EmpAllDetails empAllDetail = new EmpAllDetails();
            empAllDetail.setName(emp.getName());
            empAllDetail.setEmail(emp.getEmail());
            empAllDetail.setDeptName(emp.getDeptName());
            empAllDetail.setProName(emp.getProName());
            empAllDetail.setEmpCode(emp.getEmpCode());
            empAllDetails1.add(empAllDetail);
        }));
        return new ResponseEntity<>(empAllDetails1, HttpStatus.OK);
    }

    @GetMapping(path = "/empJoin")
    public ResponseEntity<List<EmpJoinSummary>> empJoinDetails(){
        List<EmpJoinSummaryInterface> empAllDetails=  reportService.empJoinSummary();
        List<EmpJoinSummary> empJoinDetails= new ArrayList<>();
        empAllDetails.forEach((empJoin -> {
            EmpJoinSummary empJoinDetail = new EmpJoinSummary();
            empJoinDetail.setEmpCount(empJoin.getEmpCount());
            empJoinDetail.setJoinDate(empJoin.getJoinDate());
            empJoinDetails.add(empJoinDetail);
        }));
        return new ResponseEntity<>(empJoinDetails, HttpStatus.OK);
    }

    @GetMapping(path = "/Search/{empName}/{empCode}/{proName}/{proCode}/{deptName}")
    public ResponseEntity<List<EmpAllDetails>>advanceSearch(
            @PathVariable("empName") String empName,
            @PathVariable("empCode") String empCode,
            @PathVariable("proName") String proName,
            @PathVariable("proCode") String proCode,
            @PathVariable("deptName") String deptName
    ){
        List<EmpAllDetailsInterface>  advanceSearch  =  reportService.AdvanceSearch(empName,empCode, proName,proCode, deptName);
        List<EmpAllDetails> empAllDetails1= new ArrayList<>();
        advanceSearch.forEach((emp -> {
            EmpAllDetails empAllDetail = new EmpAllDetails();
            empAllDetail.setName(emp.getName());
            empAllDetail.setEmail(emp.getEmail());
            empAllDetail.setDeptName(emp.getDeptName());
            empAllDetail.setProName(emp.getProName());
            empAllDetail.setEmpCode(emp.getEmpCode());
            empAllDetails1.add(empAllDetail);
        }));
        return new ResponseEntity<>(empAllDetails1, HttpStatus.OK);
    }

}

