import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';

  getAllMenu(): Observable<any> {
    return this.http.get('//localhost:8080/Menus');
  }

  getMenu(menuId) {
    return this.http.get('//localhost:8080/Menu/' + menuId);
  }
  getAllMember(): Observable<any>{
    return this.http.get('//localhost:8080/Member');
  }
  getAllMeat(): Observable<any>{
    return this.http.get('//localhost:8080/Meat');
  }
  getAllCategories(): Observable<any>{
    return this.http.get('//localhost:8080/Categories');
  }


}


