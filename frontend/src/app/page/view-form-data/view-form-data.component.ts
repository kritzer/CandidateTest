import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserInfo } from 'src/app/model/UserInfo';
import { FormDataService } from 'src/app/services/form-data.service';

@Component({
  selector: 'app-view-form-data',
  templateUrl: './view-form-data.component.html',
  styleUrls: ['./view-form-data.component.css']
})
export class ViewFormDataComponent implements OnInit {
  title = 'ALL FORM DATA';
  formData: UserInfo[] = [];
  search = '';
  newValue: string ;
  searchTitle = 'ค้นหาด้วย ชื่อ นามสกุล อายุ งาน';
  message = 'ไม่พบข้อมูล';
  close = 'ปิด';
  constructor(private formDataService: FormDataService,
              private snackBar: MatSnackBar,
    ) { }

  ngOnInit(): void {
    this.loadFormData();
  }
  loadAllFormData() {
    this.formDataService.getAllFormData().subscribe( data => {
      this.formData = data as UserInfo[];
    });
  }
  loadFormData() {
    this.newValue = this.search;
    if ( !this.newValue ) {
      this.loadAllFormData();
    } else {
      this.searchByText( this.newValue );
    }
  }
  searchByText( newValue ) {
    this.formDataService.searchByText( newValue ).subscribe( res => {
      if ( res && res.length ) {
        this.formData = [];
        this.formData = res as UserInfo[];
      } else {
        this.openSnackBar( this.message, this.close );
      }
    });
  }

  openSnackBar( message: string, action: string ) {
    this.snackBar.open( message, action, {
      duration: 5000,
    });
  }
  keyInput(value: string) {

        this.search = value;

}

}

