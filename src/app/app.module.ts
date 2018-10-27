import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatIconModule } from '@angular/material';
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

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'resta',
    pathMatch: 'full'
    },
    {
    path: 'menu',
    component: MenuComponent
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
path: 'resta',
component: RestaComponent
}
,
{
path: 'restainfo/:rid',
component: RestainfoComponent
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
    StarRatingComponent
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
    MatTooltipModule



  ],
  providers: [MenuService,RestaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
