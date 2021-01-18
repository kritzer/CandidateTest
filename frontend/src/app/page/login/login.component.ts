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
    ) { }

  ngOnInit(): void {
    this.loginData = new LoginData();
  }
  login(loginData) {
      this.auth.login(loginData);
  }
  resetForm() {
    this.loginData.username = null;
    this.loginData.password = null;
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
