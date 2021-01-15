import { LoginComponent } from './page/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes, CanActivate } from '@angular/router';
import { FormDataComponent } from './components/form-data/form-data.component';
import { HomeComponent } from './page/home/home.component';
import { AuthService } from './services/auth.service';
import { AuthGuardService as AuthGuard, AuthGuardService } from './services/auth-guard.service';
const routes: Routes = [{
  path: 'home',
  component: HomeComponent,
  children: [{
    path: '',
    component: FormDataComponent,
    canActivate: [AuthGuard]
  },
  ]
}, { path: 'login',
    component: LoginComponent},
    { path: '**', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    AuthService,
    AuthGuardService
  ]
})
export class AppRoutingModule { }
