import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/delay';
import { HttpClient } from '@angular/common/http';
@Injectable()
export class AuthService {

  public isLoggedIn = false;
  public redirectUrl: string;
  private API = '//localhost:9000';
  constructor(private http: HttpClient) { }

  login(loginData) {
      this.http.get(this.API + '/login?username=' + loginData.username + '&password=' + loginData.password ).subscribe( data => {
        console.log(data);
      });
  }
  logout(): void {
    this.isLoggedIn = false;
  }

}
