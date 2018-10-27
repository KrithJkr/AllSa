import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class RegistresService {

  constructor(private http: HttpClient) { }
  public API = '//localhost:8080';

  getAllRestaurant(): Observable<any> {
    return this.http.get('//localhost:8080/restaurant');
  }
  getAllMember(): Observable<any> {
    return this.http.get('//localhost:8080/members');
  }
  getAllCategories(): Observable<any> {
    return this.http.get('//localhost:8080/rescatagory');
  }
  getAllMenus(): Observable<any> {
    return this.http.get('//localhost:8080/Menus');
  }

}
