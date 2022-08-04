import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { Pizza } from 'src/app/model/pizza';
import { User } from 'src/app/model/user';
import { CustomerService } from 'src/app/service/customer.service';
import { LoginService } from 'src/app/service/login.service';
import { PizzaService } from 'src/app/service/pizza.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-usermenu',
  templateUrl: './usermenu.component.html',
  styleUrls: ['./usermenu.component.css']
})
export class UsermenuComponent implements OnInit {
  pizza:Pizza=new Pizza();
  pizzas:Pizza[]=[];
  
  Issubmitted:boolean;
  showDialog4: boolean;
  user:User=new User();
  users:User[]=[];
  customer:User=new User();
  customers:User[]=[];
newPassword:string;
userId:number;
  UserOldPassword: string;
  UName: string;
  isOpen: boolean;
  ResetoldPassword:string="";
  ResetnewPassword:string="";
  userPassword:string="";
 status:boolean;
  showDialog5: boolean;
  UPassword: any;

  constructor(private pizzaservice:PizzaService,private router:Router,private route:ActivatedRoute,private customerService:CustomerService,private loginservice:LoginService) { }

  ngOnInit() {
    this.UName = this.route.snapshot.params['uName']

    this.ResetoldPassword = this.route.snapshot.params['UPassword']
console.log(this.UName,this.UPassword);
    }
  
    handleLogout():void
    {
      this.loginservice.invokeLogout();
      swal("Log out Succesfully")
      this.router.navigate(['login']);
  
    }
    bookOrder(userId:number):void
    {
      this.router.navigate([`pizzaOrder`,userId]);

    }
    resetpopup()
    {
      this.showDialog4=true;
    }
  
    resetpassword(){

      console.log(this.ResetoldPassword+ ""+this.ResetnewPassword )
      this.customerService.updatePassword(this.ResetoldPassword,this.ResetnewPassword).subscribe(
        (response)=>{
    this.status=response;
    if(this.status){
      swal("Password has changed");
      this.router.navigate(['login']);

    }
    else{
      swal("Password has not changed");

    }
    
        }
      
      )
    }
    closePopup() {
      this.showDialog4 = false;
      this.showDialog5=false;

    }
    profilepopup(userId: number)
    {
      this.showDialog5=true;

 this.customerService.extractUserById(userId).subscribe(response=>{
      this.user=response;
      this.UName = this.user.userName;
      
    })
    }
    orderhistory()
    {
      swal('hi')

    }
}
