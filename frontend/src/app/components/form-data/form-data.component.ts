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
  constructor(private formDataService: FormDataService,
              private snackBar: MatSnackBar,
              private router: Router) {

  }
  ngOnInit(): void {
    this.formData = new FormData();
  }

  onSubmit(form) {
    this.str = 'ค่าจากฟอร์ม: ' + JSON.stringify(this.formData);
    this.formDataService.addFormData(form).subscribe( data => {
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
    this.formData.fname = null;
    this.formData.lname = null;
    this.formData.age = null;
    this.formData.job = null;
 }

}
class FormData {
  fname: string;
  lname: string;
  age: number;
  job: string;
}
