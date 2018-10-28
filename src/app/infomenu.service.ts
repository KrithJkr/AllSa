import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable({
  providedIn: 'root'
})
export class InfomenuService {
  [x: string]: any;

  constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';
  getAllMenu(): Observable<any> {
    return this.http.get('//localhost:8080/Menus');
  }
  getMenu(menuId) {
    return this.http.get('//localhost:8080/InfoMenu/' + menuId);
  }
  getShowIngredient(): Observable<any> {
    return this.http.get('//localhost:8080/ingredient');
  }
  getAllStory(): Observable<any> {
    return this.http.get('//localhost:8080/story');
  }
  getStoryId(Sid) {
    return this.http.get('//localhost:8080/story/' + Sid);
  }
}
