import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { CustomerService } from 'src/app/service/customer.service';
import { LoginService } from 'src/app/service/login.service';
;
import swal from 'sweetalert';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User=new User();

  invalidUser: boolean;
  adminName: string = "";
  adminPassword: string = "";
  userName: string = "";
  userPassword: string = "";
  Issubmitted: boolean = false;
  showDialog1: boolean;
  showDialog2: boolean;
  showDialog3: boolean;
  
  uoldpassword:string;
  unewPassword:string;
  users:User[]=[];
  uTemp:string;
  userId:number
  valid: boolean=false;
  uName: string;


  constructor(private router: Router, private loginService: LoginService,private userService:CustomerService,private route:ActivatedRoute) { }

  ngOnInit() {
    this.uName = this.route.snapshot.params['uName']
    console.log(this.userId);
    this.userService.extractUserById(this.userId).subscribe(response=>{
      this.user=response;
   
      this.uoldpassword=this.user.userPassword;
     
    })
   
  }
  handleLogin(): void {
    if(this.adminName=="" || this.adminName==undefined)
    {
        // swal("Please enter the user name")
        this.valid=true;
        
    }
  else   if(this.adminPassword=="" || this.adminPassword==undefined)
    {
        // swal("Please enter the password")
        this.valid=true;     
       
    }
    else if (this.loginService.doLogin(this.adminName, this.adminPassword)) {
      debugger
      this.valid=false;
      console.log("menu" + " " + this.adminName);
      this.invalidUser = false;
      swal("Admin Login Success!");
      this.router.navigate(['menu']);
    } else {
      swal("Invalid Login Creditinals!");

    }
    debugger
    // window.location.reload();
  }

  handleUserLogin():void
  {
    if(this.userName=="" || this.userName==undefined)
    {
        this.valid=true;
        
    }
  else   if(this.userPassword=="" || this.userPassword==undefined)
    {
        this.valid=true;
        
       
    }
 if(this.loginService.doUserLogin(this.userName,this.userPassword))
{
  console.log("menu" + " " + this.userName);
      this.invalidUser = false;
      swal("User Login Success!");
      this.router.navigate(['usermenu',this.userName,this.userPassword]);
}
else {
  swal("Invalid Login Creditinals!");

}
  }
  
  cust() {
    debugger
    this.showDialog2 = true;
  }
  Admin() {
    debugger
    this.showDialog1 = true;
  }
  closePopup() {
    this.showDialog1 = false;
    this.showDialog2=false;
    this.showDialog3=false;
  }
  handleLogout():void
  {
    this.loginService.invokeLogout();
    swal("Logged Out Succesfully")

  }

}
