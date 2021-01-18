import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginData: LoginData;
  constructor(private auth: AuthService,
              private snackBar: MatSnackBar,
              private router: Router
    ) { }

  ngOnInit(): void {
    this.loginData = new LoginData();
    this.checklogin();
  }
  login(loginData) {
      this.auth.login(loginData);
  }
  resetForm() {
    this.loginData.username = null;
    this.loginData.password = null;
  }
  checklogin() {
    if (localStorage.getItem('userData') !== null) {
      this.router.navigate(['']);
    }
  }
  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }
}
class LoginData {
  username: string;
  password: string;
}
