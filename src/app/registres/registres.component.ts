import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { HttpClient} from '@angular/common/http';
import { RegistresService } from '../registres.service';
import { RestaService } from '../resta.service';

@Component({
  selector: 'app-registres',
  templateUrl: './registres.component.html',
  styleUrls: ['./registres.component.css']
})
export class RegistresComponent implements OnInit {
  tel: number;
  rtel: number;
  rname: String;
  menus: '';
  catego: '';
  owa: '';
  promo: '';

  memberLogin:any;

  

  packAddress: any = {
    addressSelect: '',
    picurl: ''
  };

  owname: Array<any>;
  menu: Array<any>;
  category: Array<any>;
  promos: Array<any>;
  restas: Array<any>;
  constructor(private httpClient: HttpClient, private RegistresService: RegistresService,private restaService:RestaService) { }

  ngOnInit() {
    this.RegistresService.getAllRestaurant().subscribe(data => {
      this.restas = data;
      })
      this.RegistresService.getAllMenus().subscribe(data => {
        this.menu = data;
        })
        this.RegistresService.getAllMember().subscribe(data => {
          this.owname = data;
          })
          this.RegistresService.getAllCategories().subscribe(data => {
            this.category = data;
            })
    this.restaService.getMemberById(this.restaService.getMemberLoginId()).subscribe(
      data => this.memberLogin = data)
  }
  save() {
    if (this.owa === undefined || this.rname === '' || this.packAddress.addressSelect === ''
        || this.catego === undefined
        || this.menus === undefined || this.packAddress.addressSelect === undefined || this.rtel === undefined ) {
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
        this.httpClient.post('http://localhost:8080/restaurant/create/' + this.rname + '/'
         + this.catego + '/' + this.menus + '/' + this.owa + '/' + this.rtel, this.packAddress).subscribe(
        data => {
            console.log('PUT Request is successful', data);
        },
        error => {
            console.log('---Error----', error);
             window.location.reload();
        }
        );
      }
  }
}














