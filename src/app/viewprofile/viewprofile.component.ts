import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ViewprofileService } from '../viewprofile.service';
import { RestaService } from '../resta.service';

@Component({
  selector: 'app-viewprofile',
  templateUrl: './viewprofile.component.html',
  styleUrls: ['./viewprofile.component.css']
})
export class ViewprofileComponent implements OnInit {
  profiles: any;

  profilesbyid: any;
  firstnameSelect: '';
  constructor(private viewprofileService: ViewprofileService , private httpClient: HttpClient,private restaService:RestaService) {}

  ngOnInit() {
    this.httpClient.get('//localhost:8080/profile').subscribe(data => {
      this.profiles = data; });

      this.viewprofileService.getProfileById(this.restaService.getMemberLoginId()).subscribe(data => {
        this.profilesbyid = data; console.log('PUT Request is successful', data); }
        ) ;
  }
  save(id) {
    this.viewprofileService.getProfileById(id).subscribe(data => {
      this.profilesbyid = data; console.log('PUT Request is successful', data); }
      ) ;
  }
}
