import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginData: LoginData;
  constructor(private auth: AuthService,
              private router: Router) { }

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
}
class LoginData {
  username: string;
  password: string;
}
