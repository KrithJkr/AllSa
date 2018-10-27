import { Component, OnInit, Input } from '@angular/core';
import { RestaService } from '../resta.service';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { PARAMETERS } from '@angular/core/src/util/decorators';

@Component({
  selector: 'app-restainfo',
  templateUrl: './restainfo.component.html',
  styleUrls: ['./restainfo.component.css'],


})
export class RestainfoComponent implements OnInit {




  restaurantRating: Object;
  restaurantInfo: Object;
  comments: Array<any>;
  members: Array<any>;
  restaurantnumber: any;

  
 

  constructor(private data: RestaService,private route: ActivatedRoute,private httpClient: HttpClient) {
    this.route.params.subscribe( params => this.restaurantInfo = params.rid),
    this.route.params.subscribe( params => this.comments = params.rid)
    this.route.params.subscribe( params => this.restaurantnumber = params.rid)
  }
  ngOnInit() {
    this.data.getRestaurant(this.restaurantInfo).subscribe(
      data => this.restaurantInfo = data)

    this.data.getCommentByRid(this.comments).subscribe(
    data => {this.comments = data})

    this.data.getMembers().subscribe(data => {
    this.members = data;
    })
    
    this.data.getRatingByRid(this.restaurantnumber).subscribe(
      data => { this.restaurantRating = data})
    }




  @Input('rating') rating: number;
  @Input('starCount') starCount: number;
  @Input('color') color: string;
  
  usernameSelect:''

  mycomment : any = {
    textSelect: '',
    ratingSelect:'',
    imgSelect:''
  }



  save(){
    if(this.mycomment.textSelect === '' || this.rating === undefined || this.mycomment.imgSelect === '' || this.usernameSelect === '')
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    else{
    this.httpClient.post('http://localhost:8080/comment/create/'+this.restaurantnumber+ '/'+this.usernameSelect+'/',this.mycomment).subscribe(
      data => {
          console.log('PUT Request is successful', data);
      },
      error => {
          console.log('Error', error);
          window.location.reload();
      }
    
  );
  }
  }

delete(cmid){
  this.httpClient.delete('http://localhost:8080/comment/delete/'+cmid).subscribe(
    data => {
        console.log('Delete Request is successful', data);
        window.location.reload();
    },
    error => {
        console.log('Error', error);
    }
  
);
}
onRatingChanged(rating){
	console.log(rating);
  this.rating = rating;
  this.mycomment.ratingSelect = rating;
}
  
}
