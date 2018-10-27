import { MenuService } from './../menu.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-menu-info',
  templateUrl: './menu-info.component.html',
  styleUrls: ['./menu-info.component.css']
})
export class MenuInfoComponent implements OnInit {
  Menu: Object;
  Menus: Array<any>;
  // member: Array<any>;

   constructor(private menuService: MenuService,private route: ActivatedRoute,private httpClient: HttpClient) {
    this.route.params.subscribe( params => this.Menu = params.menuId)
   }
   ngOnInit() {
    this.menuService.getMenu(this.Menu).subscribe(
      data => this.Menu = data)
     this.menuService.getAllMenu().subscribe(data => {
     this.Menus = data;

    })
   }

}
