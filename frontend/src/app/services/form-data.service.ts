import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class FormDataService {

  private API = '//localhost:9000';

  constructor(private http: HttpClient) { }

  getAllFormData(): Observable<any> {
    return this.http.get(this.API + '/getAllForm');
  }

  getByLastNameOrFirstName(lastName, firstName): Observable<any> {
    return this.http.get(this.API + '/getByLastNameOrFirstName?lastName=' + lastName + '&firstName=' + firstName);
  }

  addFormData(formData): Observable<any> {
    return this.http.post(this.API + '/addFormData', formData);
  }



}
