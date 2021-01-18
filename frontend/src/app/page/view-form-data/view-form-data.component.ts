import { Component, Input, OnInit } from '@angular/core';
import { Userinfo } from 'src/app/model/userinfo';
import { FormDataService } from 'src/app/services/form-data.service';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'app-view-form-data',
  templateUrl: './view-form-data.component.html',
  styleUrls: ['./view-form-data.component.css']
})
export class ViewFormDataComponent implements OnInit {
  title = 'ALL FORM DATA';
  formData: Userinfo[] = [];
  search: string;
  constructor(private fdts: FormDataService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getFormData();
  }
  getFormData() {
    this.fdts.getAllFormData().subscribe( data => {
      this.formData = data as Userinfo[];
      console.log(this.formData);
    });
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }

}

