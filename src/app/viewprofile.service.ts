import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class ViewprofileService {


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
  getAllProfile(): Observable<any> {
    return this.http.get('//localhost:8080/profile');
  }
  getProfileById(id) {
    return this.http.get('//localhost:8080/profile/' + id);
  }
  getMemberById(id) {
    return this.http.get('//localhost:8080/member/' + id);
  }
  getCreditcardById(id) {
    return this.http.get('//localhost:8080/creditcardbyid/' + id);
  }
}