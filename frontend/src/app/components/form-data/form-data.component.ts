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
              private snackBar: MatSnackBar) {

  }
  ngOnInit(): void {
    this.formdata = new FormData();
  }

  onSubmit(form) {
    this.str = 'ค่าจากฟอร์ม: ' + JSON.stringify(this.formdata);
    this.fdts.addFormData(form).subscribe( data => {
      console.log(this.str);    }
      );
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

}
class FormData {
  fname: string;
  lname: string;
  age: number;
  job: string;
}
