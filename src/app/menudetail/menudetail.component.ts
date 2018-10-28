import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { InfomenuService } from '../infomenu.service';

@Component({
  selector: 'app-menudetail',
  templateUrl: './menudetail.component.html',
  styleUrls: ['./menudetail.component.css']
})
export class MenudetailComponent implements OnInit {
  menu: Object;
  menus: Array<any>;
  story:Object;
  stories: Array<any>;


   constructor(private menuService: InfomenuService,private route: ActivatedRoute,private httpClient: HttpClient
    ) {
    this.route.params.subscribe( params => this.menu = params.menuId)
    this.route.params.subscribe( params => this.stories = params.menuId)
   }
   ngOnInit() {
     this.menuService.getMenu(this.menu).subscribe(      data => this.menu = data)
     this.menuService.getAllMenu().subscribe(data => {     this.menus = data;})
     this.menuService.getAllStory().subscribe(data => {      this.stories = data;})
   }

}
