import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormDataService } from 'src/app/services/form-data.service';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-form-data',
  templateUrl: './form-data.component.html',
  styleUrls: ['./form-data.component.css']
})
export class FormDataComponent implements OnInit {
title = '';
formdata: FormData;
str: string;
snackbar = true;
  constructor(private fdts: FormDataService,
              private snackBar: MatSnackBar,
              private router: Router) {

  }
  ngOnInit(): void {
    this.formdata = new FormData();
  }

  onSubmit(form) {
    this.str = 'ค่าจากฟอร์ม: ' + JSON.stringify(this.formdata);
    this.fdts.addFormData(form).subscribe( data => {
      this.openSnackBar('บันทึกสำเร็จ', 'ปิด');
      this.router.navigate(['/viewFormData']);
    }, error => {
        this.openSnackBar(error.message, 'ปิด');
        this.resetForm();
      }
      );
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }
  resetForm() {
    this.formdata.fname = null;
    this.formdata.lname = null;
    this.formdata.age = null;
    this.formdata.job = null;
 }

}
class FormData {
  fname: string;
  lname: string;
  age: number;
  job: string;
}
