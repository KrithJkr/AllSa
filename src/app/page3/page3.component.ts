import { Component, OnInit } from '@angular/core';
import { PageService } from '../page.service';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { PARAMETERS } from '@angular/core/src/util/decorators';

@Component({
  selector: 'app-page3',
  templateUrl: './page3.component.html',
  styleUrls: ['./page3.component.css']
})
export class Page3Component implements OnInit {

  thediscount: Object;
  thetime:Object;

  constructor(private data: PageService,private route: ActivatedRoute) {
    this.route.params.subscribe( params => this.thediscount = params.id);
    this.route.params.subscribe( params => this.thetime = params.id);
  }
  ngOnInit() {
        this.data.ShowDiscountdetail(this.thediscount).subscribe(data => {this.thediscount = data;})
        
  }

}