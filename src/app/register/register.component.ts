import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../register.service';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { queryRefresh } from '@angular/core/src/render3/query';
import { Router } from '@angular/router';


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
  constructor(private registerService: RegisterService , private httpClient: HttpClient , private _router: Router) {
  }
  ngOnInit() {
  }
  save() {
    // tslint:disable-next-line:max-line-length
    if ( this.username === '' || this.password === '' || this.email === ''  ||  this.username === undefined || this.password === undefined || this.email === undefined ) {
    alert('กรอกข้อมูลให้ครบ');
    document.location.href = 'http://localhost:4200/register';
    } else {
      this.memberOf = this.memberOf;
      // tslint:disable-next-line:max-line-length
      this.httpClient.post('http://localhost:8080/member/create/' + this.username + '/' + this.password + '/' + this.email + '/' + this.memberOf, null).subscribe(
        data => {
          console.log('PUT Request is successful', data);
          document.location.href = 'http://localhost:4200/login';
      },
      error => {
          console.log('Error', error);
      }
      );
    }
  }

}