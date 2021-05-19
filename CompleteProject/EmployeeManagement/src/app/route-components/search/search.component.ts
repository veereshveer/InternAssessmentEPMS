import { Component, OnInit, ViewChild } from '@angular/core';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs/internal/Subject';
import { SearchService } from './search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  public employeeName : String = '' ;
  public employeeCode : String = '' ;
  public projectName : String = '' ;
  public projectCode : String = '' ;
  public departmentName : String = '' ;
  public empDetails : any = [] ;
  public display: String ="";
  public resultModel:boolean=false;
  public name : String = '';
  public empCode: String = '';
  public email: String = '';
  public deptName: String = '';
  public proName: String = '';
  public resultAllDeatil: any = [];
  public loadTable : String = 'd-none';

  @ViewChild(DataTableDirective)
  dtElement!: DataTableDirective;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  constructor(private service : SearchService) { }

  ngOnInit(): void {
  }

  rerender(): void {
    let self = this;
    self.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
      dtInstance.destroy();
    });
  } 

  search = () => {
    let self = this;
    self.resultAllDeatil = [];
    self.dtTrigger.next();
    self.rerender();
  self.service.search(
    self.employeeName,
    self.employeeCode,
    self.projectName,
    self.projectCode,
    self.departmentName
  )
  .subscribe((response) =>{
    self.loadTable = '';
    self.resultAllDeatil = response;
    self.dtTrigger.next();
    self.rerender();
  }, (err) => {
    alert("No Data Found");
    console.log(err);
    self.display="";
  })
}
}
