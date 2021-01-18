import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginData: LoginData;
  constructor(private auth: AuthService) { }

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
