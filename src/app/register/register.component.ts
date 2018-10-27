import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { queryRefresh } from '@angular/core/src/render3/query';
import { Router } from '@angular/router';
import { CreateService } from '../create.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  username: '';
  password: '';
  email: '';
  memberOf = 'EMAIL';

  test:any;
  constructor(private registerService: RegisterService , private httpClient: HttpClient , private _router: Router,private createService:CreateService) {
  }
  ngOnInit() {
  }
  save() {
    // tslint:disable-next-line:max-line-length
    if ( this.username === '' || this.password === '' || this.email === ''  ||  this.username === undefined || this.password === undefined || this.email === undefined ) {
    alert('กรอกข้อมูลให้ครบ');
    } else {
      this.memberOf = this.memberOf;
      this.createService.setEmailProfile(this.email);
      this.httpClient.post('http://localhost:8080/member/create/' + this.username + '/' + this.password + '/' + this.email + '/' + this.memberOf, null).subscribe(
        data => {
          console.log('PUT Request is successful', data);
          document.location.href = 'http://localhost:4200/createprofile';
      },
      error => {
          console.log('Error', error);
      }
      );
    }
  }

}