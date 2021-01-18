import { Component, OnInit } from '@angular/core';
import { Userinfo } from 'src/app/model/userinfo';
import { FormDataService } from 'src/app/services/form-data.service';

@Component({
  selector: 'app-view-form-data',
  templateUrl: './view-form-data.component.html',
  styleUrls: ['./view-form-data.component.css']
})
export class ViewFormDataComponent implements OnInit {
  title = 'ALL FORM DATA';
  formData: Userinfo[] = [];
  constructor(private fdts: FormDataService) { }

  ngOnInit(): void {
    this.getFormData();
  }
  getFormData() {
    this.fdts.getAllFormData().subscribe( data => {
      this.formData = data as Userinfo[];
      console.log(this.formData);
    });
  }
}

