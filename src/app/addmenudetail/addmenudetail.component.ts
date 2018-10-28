import { InfomenuService } from './../infomenu.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addmenudetail',
  templateUrl: './addmenudetail.component.html',
  styleUrls: ['./addmenudetail.component.css']
})
export class AddmenudetailComponent implements OnInit {

  menu:Array<any>;
  ingredient:Array<any>;

  constructor(private httpClient: HttpClient,private infomenuService: InfomenuService,private route: ActivatedRoute) {
    this.route.params.subscribe( params => this.menu = params.mid)
   }
    ngOnInit() {
      this.getAllMenu();
      this.getShowIngredient();
      //this.InfomenuService.getMenu(this.menu).subscribe(data => this.menu = data);
    };

  nutext:String;
  stext:String;
  protein:String;
  carbohydrate:String;
  vitamin:String;
  fat:String;
  fruit:String;
    mymenu : any = {
      cal:'',
      menuId:''
    }


    save(){

      this.httpClient.post('http://localhost:8080/menu/create/'+ this.stext+'/'+this.nutext+
      '/'+this.protein+'/'+this.carbohydrate+'/'+this.vitamin+'/'+this.fruit+'/'+this.fat+'/'+this.mymenu.menuId,this.mymenu).subscribe(
        data => {
            console.log('PUT Request is successful', data);
        },
        error => {
            console.log('Error', error);
            //window.location.reload();
        }

    );

    }

    getAllMenu() {
      this.infomenuService.getAllMenu().subscribe(data => {
      this.menu = data;
      console.log(this.menu);
      });
    }

    getShowIngredient() {
      this.infomenuService.getShowIngredient().subscribe(data => {
      this.ingredient = data;
      console.log(this.ingredient);
      });
    }

      }
