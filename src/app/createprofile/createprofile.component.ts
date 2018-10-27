import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CreateService } from '../create.service';
import { RestaService } from '../resta.service';

@Component({
  selector: 'app-createprofile',
  templateUrl: './createprofile.component.html',
  styleUrls: ['./createprofile.component.css']
})
export class CreateprofileComponent implements OnInit {
  address: any;
  selectAddress: '';
  selectBank: '';
  bank: any;
  usernameSelect: '';
  username: any;

  memberinfo:any = {
    firstname: '',
    lastname: '',
    age: '',
    number: ''
  }
  memberLogin:any;

  constructor(private createService: CreateService , private httpClient: HttpClient,private restaService:RestaService) {}
  ngOnInit() {
    this.getAllCreditcard();
    this.getAllAddress();
    this.getAllMember();
    this.restaService.getMemberById(this.restaService.getMemberLoginId()).subscribe(
      data => this.memberLogin = data)
  }
  save() {
    // tslint:disable-next-line:max-line-length
    if ( this.memberLogin.mid === '' || this.memberinfo.firstname === '' || this.memberinfo.lastname === '' || this.memberinfo.age === '' || this.selectAddress === '' || this.memberinfo.number === '' || this.selectBank === '' || this.memberLogin.mid === undefined || this.memberinfo.firstname === undefined || this.memberinfo.lastname === undefined || this.memberinfo.age === undefined || this.selectAddress === undefined || this.memberinfo.number === undefined  || this.selectBank === undefined ) {
    alert('กรอกข้อมูลให้ครบ');
    } else {
      // tslint:disable-next-line:max-line-length
      this.httpClient.post('http://localhost:8080/profile/create/' + this.memberLogin.mid + '/'  +  this.memberinfo.firstname + '/' + this.memberinfo.lastname + '/' + this.memberinfo.age + '/' + this.selectAddress  + '/' + this.memberinfo.number + '/' + this.selectBank , null).subscribe(
        data => {
          console.log('PUT Request is successful', data);
           document.location.href = 'http://localhost:4200/viewprofile'; 
      },
      error => {
          console.log('Error', error);
           document.location.href = 'http://localhost:4200/viewprofile'; 
      }
      );
    }
  }
  getAllCreditcard() {
    this.createService.getAllCreditcard().subscribe(data => {
    this.bank = data;
    console.log(this.bank);
    });
  }
  getAllAddress() {
    this.createService.getAllAddress().subscribe(data => {
    this.address = data;
       console.log(this.address);
    });
  }
  getAllMember() {
    this.createService.getAllMember().subscribe(data => {
    this.username = data;
    console.log(this.username);
    });
  }
}
