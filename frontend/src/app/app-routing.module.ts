import { LoginComponent } from './page/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes, CanActivate } from '@angular/router';
import { HomeComponent } from './page/home/home.component';
import { AuthService } from './services/auth.service';
import { AuthGuardService as AuthGuard, AuthGuardService } from './services/auth-guard.service';
import { ViewFormDataComponent } from './page/view-form-data/view-form-data.component';
import { FormDataComponent } from './components/form-data/form-data.component';
const routes: Routes = [{
  path: 'home',
  component: HomeComponent,
  canActivate: [AuthGuard],
  children: [{
    path: '',
    component: FormDataComponent,
  },
  ]
}, { path: 'login',
    component: LoginComponent},
    {
      path: 'viewFormData',
      component: ViewFormDataComponent,
      canActivate: [AuthGuard],
    },
    { path: '**', redirectTo: 'home' }
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
