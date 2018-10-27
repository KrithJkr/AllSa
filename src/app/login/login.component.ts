import { Component, OnInit } from '@angular/core';
import {RestaService}from '../resta.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  members:Array<any>;
  checkround:Number;


  constructor(private restaService:RestaService,private router: Router) { }

  ngOnInit() {
    this.restaService.getMembers().subscribe(data => {
      this.members = data;
      })
  }

  
  loginUser(event){
    event.preventDefault()
    const target = event.target
    const username = target.querySelector('#username').value
    const password = target.querySelector('#password').value

    for(let i=0 ; i< this.members.length; i++)
    {
        if (this.members[i].username === username && this.members[i].password === password)
        {
            this.checkround = 1;
            console.log("User Found" , this.members[i]);
            this.restaService.setMemberLoginId(this.members[i].mid);
            break;
        }
        else
        this.checkround = 0;
        
    }

    if(this.checkround === 1){
      alert("Login Success");
          this.router.navigate(['home']);
        }
      else
      alert("Username/Password is Invalid");

  }


}
