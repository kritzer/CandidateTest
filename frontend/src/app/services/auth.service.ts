import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/delay';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Injectable()
export class AuthService {
  public redirectUrl: string;

  private API = '//localhost:9000';
  constructor(private http: HttpClient,
              private router: Router) { }

  login(loginData) {
      this.http.get(this.API + '/login?username=' + loginData.username + '&password=' + loginData.password ).subscribe( data => {
        console.log(data);
        if (data !== null) {
          console.log('Success');
          localStorage.setItem('userData', JSON.stringify(data));
          this.router.navigate(['']);
        } else {
          console.log('Failed');
        }
      });
  }
  logout(): void {
    localStorage.clear();
    this.router.navigate(['/login']);
  }

}
