import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  name:string="";
  msg:string=""
  adminFlag:boolean;
  customerFlag:boolean;
  showDialog2: boolean;
constructor(private route:ActivatedRoute,private loginService:LoginService,private router:Router) { }

ngOnInit() {
  this.name=this.route.snapshot.params['name']
  this.adminFlag=this.loginService.isAdmin();
  this.customerFlag=this.loginService.isCustomer();

}
handleLogout():void
  {
    this.loginService.invokeLogout();
    swal("Logged Out Succesfully")

  }
  Order()
  {
    swal("Please login with ur Details");
    this.router.navigate(['login']);
  }
}