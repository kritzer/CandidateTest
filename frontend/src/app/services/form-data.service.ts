import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FormDataService {

  public API = '//localhost:9000';

  constructor(private http: HttpClient) { }

  getAllFormData(): Observable<any> {
    return this.http.get(this.API + '/getAllForm');
  }

  addFormData(formData): Observable<any> {
    return this.http.post(this.API + '/addFormData', formData);
  }

}
