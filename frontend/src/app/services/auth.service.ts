import { Injectable } from '@angular/core';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/delay';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
@Injectable()
export class AuthService {
  public redirectUrl: string;

  private API = '//localhost:9000';
  constructor(private http: HttpClient,
              private router: Router,
              private snackBar: MatSnackBar) { }

  login(loginData): void {
      this.http.get(this.API + '/login?username=' + loginData.username + '&password=' + loginData.password ).subscribe( data => {
        if (data !== null) {
          localStorage.setItem('userData', JSON.stringify(data));
          this.openSnackBar('เข้าสู่ระบบสำเร็จ', 'ปิด');
          this.router.navigate(['']);
        } else {
          this.openSnackBar('เข้าสู่ระบบไม่สำเร็จ', 'ปิด');
        }
      });
  }
  logout(): void {
    localStorage.clear();
    this.router.navigate(['/login']);
  }
  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }

}
