import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class CreateService {


constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';

  getAllMember(): Observable<any> {
    return this.http.get('//localhost:8080/members');
  }
  getAllCreditcard(): Observable<any> {
    return this.http.get('//localhost:8080/creditcard');
  }
  getAllAddress(): Observable<any> {
    return this.http.get('//localhost:8080/address');
  }

  setEmailProfile(email){
    localStorage.setItem('key',email)
  }
  getEmailProfile(){
    return localStorage.getItem('key')
  }
  getMemberByEmail(email){
    return this.http.get('//localhost:8080/memberbyemail/'+email);
  }
}
