import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatIconModule ,MatNativeDateModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import {MatSelectModule} from '@angular/material/select';
import { AddMenuComponent } from './add-menu/add-menu.component';
import {MatStepperModule} from '@angular/material/stepper';
import { MenuInfoComponent } from './menu-info/menu-info.component';
import { MenuService } from './menu.service';
import { RestaComponent } from './resta/resta.component';
import { RestainfoComponent } from './restainfo/restainfo.component';
import { StarRatingComponent } from './star-rating/star-rating.component';
import { RestaService } from './resta.service';
import {MatTooltipModule} from '@angular/material/tooltip';
import { Page1Component } from './page1/page1.component';
import { Page2Component } from './page2/page2.component';
import { Page3Component } from './page3/page3.component';
import { PageService } from './page.service';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatRadioModule} from '@angular/material/radio';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
<<<<<<< HEAD
import { ToolbarComponent } from './toolbar/toolbar.component';
=======
import { RegisterComponent } from './register/register.component';
import { CreateprofileComponent } from './createprofile/createprofile.component';
import { GoogleComponent } from './google/google.component';
import { FacebookComponent } from './facebook/facebook.component';
import { ViewprofileComponent } from './viewprofile/viewprofile.component';
import { RegisterService } from './register.service';
import { CreateService } from './create.service';
import { ViewprofileService } from './viewprofile.service';
>>>>>>> 54c30746ee787652c9bba3e6365bb67c33f2965c

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
    },
    {
    path: 'menu',
    component: MenuComponent
    }
    ,
    {
      path: 'home',
      component: HomeComponent
      }
      ,
    {
    path: 'add-menu',
    component: AddMenuComponent
    },
    {
      path: 'menu/menu-info/:menuId',
      component: MenuInfoComponent
      },
      {
        path: 'login',
        component: LoginComponent
        }
        ,
{
path: 'resta',
component: RestaComponent
}
,
{
path: 'restainfo/:rid',
component: RestainfoComponent
}
,
{
path: 'page1',
component: Page1Component
}
,
{
path: 'page2',
component: Page2Component
}
,
{
path: 'page3/:id',
component: Page3Component
},
{
  path: 'register',
  component: RegisterComponent
},
{
  path: 'createprofile',
  component: CreateprofileComponent
},
{
  path: 'viewprofile',
  component: ViewprofileComponent
},
{
  path: 'facebook',
  component: FacebookComponent
},
{
  path: 'google',
  component: GoogleComponent
}
];

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    AddMenuComponent,
    MenuInfoComponent,
    RestaComponent,
    RestainfoComponent,
    StarRatingComponent,
    Page1Component,
    Page2Component,
    Page3Component,
    LoginComponent,
    HomeComponent,
<<<<<<< HEAD
    ToolbarComponent
=======
    RegisterComponent,
    CreateprofileComponent,
    GoogleComponent,
    FacebookComponent,
    ViewprofileComponent
>>>>>>> 54c30746ee787652c9bba3e6365bb67c33f2965c
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    MatFormFieldModule,
    RouterModule.forRoot(appRoutes),
    MatSelectModule,
    MatStepperModule,
    MatIconModule,
    MatTooltipModule,
    MatDatepickerModule,
    MatRadioModule,
    MatSnackBarModule,
    MatNativeDateModule
    



  ],
  providers: [MenuService,RestaService,PageService,RegisterService, CreateService, ViewprofileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
