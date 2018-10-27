import { MenuService } from './../menu.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-add-menu',
  templateUrl: './add-menu.component.html',
  styleUrls: ['./add-menu.component.css']
})
export class AddMenuComponent implements OnInit {

  member: Array<any>;
  categories: Array<any>;
  meat: Array<any>;
  constructor(private menuService: MenuService,private httpClient: HttpClient) {

   }

  ngOnInit() {
    this.menuService.getAllMember().subscribe
    (data => {this.member = data})
    this.menuService.getAllCategories().subscribe
    (data => {this.categories = data})
    this.menuService.getAllMeat().subscribe
    (data => {this.meat = data})
  }
  MenuInput : any = {
    MenuNameSelect: '',
    MeatIdSelect:'',
    CatIdSelect:'',
    CookingSelect:'',
    PicUrlSelect:'',
    MemberIdSelect:''
  }

  save(){
    this.httpClient.post('http://localhost:8080/menu/create/',this.MenuInput).subscribe(
      data => {
          console.log('PUT Request is successful', data);
      },
      error => {
          console.log('Error', error);
          /* window.location.reload(); */
      }
      );
  }


}
