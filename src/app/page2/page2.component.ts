import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { PageService } from '../page.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { PARAMETERS } from '@angular/core/src/util/decorators';

@Component({
  selector: 'app-page2',
  templateUrl: './page2.component.html',
  styleUrls: ['./page2.component.css']
})
export class Page2Component implements OnInit {

  Buttontoggle:boolean = false;
  PromotionName: String;
  PromotionTitle: String;
  PromotionDuration: String;
  PromotionType: number;
  Startdate: null;
  Enddate: null;
  Code:String;
  Coupon: Array<any>;
  restas:Array<any>;
  restautant: String;

  constructor(private data: PageService,private httpClient: HttpClient,private router: Router) { }

  ngOnInit() {
    this.data.getCoupon().subscribe(data => {this.Coupon = data;})
    this.data.getAllRestaurant().subscribe(data => {this.restas = data;})
  }

  save(){
    if(this.PromotionName === undefined || this.PromotionTitle === undefined || this.PromotionType === undefined ||
      this.Startdate === undefined || this.Enddate === undefined || this.PromotionDuration === undefined|| this.restautant === undefined) {
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }
    else{
      if(this.Code !== undefined){
        this.httpClient.post('http://localhost:8080/discount(coupon)/create/' + this.PromotionName + '/' + this.PromotionTitle+ '/' + this.PromotionType+ '/'
         + this.Startdate + '/' + this.Enddate+ '/' + this.PromotionDuration+ '/'+ this.restautant +'/'+ this.Code,null).subscribe(
        data => {
                console.log('PUT Code and discount is successful', data);
            },
            error => {
                console.log('------------Error----------', error);
                this.router.navigate(['page1']);
            }

      );
      }
      else{
        this.httpClient.post('http://localhost:8080/discount/create/' + this.PromotionName + '/' + this.PromotionTitle+ '/' + this.PromotionType+ '/'
         + this.Startdate + '/' + this.Enddate+ '/' + this.PromotionDuration+ '/'+ this.restautant,null).subscribe(
        data => {
            console.log('PUT Request is successful', data);
        },
        error => {
            console.log('**********Error***********', error);
            this.router.navigate(['page1']);
        }

  );}
  }
  }

}