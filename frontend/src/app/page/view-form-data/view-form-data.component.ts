import { Component, Input, OnInit } from '@angular/core';
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
  @Input() search: string = '';
  newValue: string ;
  searchTitle = 'ค้นหาด้วย ชื่อ หรือ นามสกุล เท่านั้น';
  constructor(private formDataService: FormDataService) { }

  ngOnInit(): void {
    this.searchFormData();
  }
  getFormData() {
    this.formDataService.getAllFormData().subscribe( data => {
      this.formData = data as UserInfo[];
    });
  }
  searchFormData() {
    this.newValue = this.search;
    if (this.newValue === '') {
      this.getFormData();
    } else {
      this.getFormByFirstName(this.newValue);
    }
  }
  getFormByFirstName(newValue) {
    this.formDataService.getByLastNameOrFirstName('', newValue).subscribe( res => {
      if (res && res.length) {
        this.formData = [];
        this.formData = res as UserInfo[];
      } else {
        this.getFormByLastName(newValue);
      }
    });
  }
  getFormByLastName(newValue) {
    this.formDataService.getByLastNameOrFirstName(newValue, '').subscribe( res => {
      if (res && res.length) {
        this.formData = [];
        this.formData = res as UserInfo[];
      }
    });
  }
  keyInput(value: string) {
    if (value) {
        this.search = value;
    }
}

}

