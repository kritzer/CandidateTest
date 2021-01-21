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
formData: FormData;
str: string;
close = 'ปิด';
validateErrorMessage = 'กรุณาตรวจสอบข้อมูลในฟอร์ม';
addSuccess = 'บันทึกสำเร็จ';
  constructor(private formDataService: FormDataService,
              private snackBar: MatSnackBar,
              private router: Router) {
  }
  ngOnInit(): void {
    this.formData = new FormData();
  }
  onSubmit(form) {
    this.validateForm(form);
  }
  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }
  validateForm(form) {
    const checkForm = form.firstName && form.lastName && form.age >= 1 && form.job;
    if (checkForm) {
      this.addFormData(form);
    } else {
      this.openSnackBar(this.validateErrorMessage, this.close);
    }
  }
  addFormData(form) {
    this.formDataService.addFormData(form).subscribe( data => {
      this.openSnackBar(this.addSuccess, this.close);
      this.router.navigate(['/viewFormData']);
    }, error => {
      this.openSnackBar(error.message, this.close);
      } );
  }
}
class FormData {
  firstName: string;
  lastName: string;
  age: number;
  job: string;
}
