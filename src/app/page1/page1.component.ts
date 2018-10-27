import { Page2Component } from './../page2/page2.component';
import { Component, OnInit } from '@angular/core';
import { PageService } from '../page.service';
import { Observable, from } from 'rxjs';

@Component({
  selector: 'app-page1',
  templateUrl: './page1.component.html',
  styleUrls: ['./page1.component.css']
})
export class Page1Component implements OnInit {
  promo: Array<any>;
  resta: Array<any>;
  constructor(private pageService: PageService) {}
  ngOnInit() {
    this.pageService.getAllDiscount().subscribe(data => {this.promo = data;} )
    this.pageService.getAllRestaurant().subscribe(data => {this.resta = data;} )
  }
}