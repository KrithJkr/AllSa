import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PageService {

constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';
  getAllRestaurant(): Observable<any> {
    return this.http.get('//localhost:8080/restaurant');
  }
  getAllDiscount(): Observable<any> {
    return this.http.get('//localhost:8080/Discount');
  }
  ShowDiscountdetail(id): Observable<any>{
    return this.http.get('//localhost:8080/Discountbyid/' + id);
  }
  getCoupon(): Observable<any>{
    return this.http.get('//localhost:8080/Coupon');
  }

}