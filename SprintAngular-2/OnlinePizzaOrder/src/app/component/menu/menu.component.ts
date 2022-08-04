import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  uName:string;
  msg:string=""
  adminFlag:boolean;
  customerFlag: boolean;
constructor(private route:ActivatedRoute,private loginService:LoginService,private router:Router) { }

ngOnInit() {
  this.uName = this.route.snapshot.params['uName']
  this.adminFlag=this.loginService.isAdmin();
  this.customerFlag=this.loginService.isCustomer();

}
handleLogout():void
    {
      this.loginService.invokeLogout();
      swal("Log out Succesfully")
      this.router.navigate(['login']);
  
    }
}