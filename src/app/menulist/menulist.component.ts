import { InfomenuService } from './../infomenu.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menulist',
  templateUrl: './menulist.component.html',
  styleUrls: ['./menulist.component.css']
})
export class MenulistComponent implements OnInit {
  menus: Array<any>;
constructor(private menuService: InfomenuService) { }

ngOnInit() {
    this.menuService.getAllMenu().subscribe(data => {
    this.menus = data;
    })
  }
}
