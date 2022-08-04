import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import swal from 'sweetalert';
import { Admin } from '../model/admin';
import { User } from '../model/user';
import { AdminService } from './admin.service';
import { CustomerService } from './customer.service';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  admin:Admin;
  user:User;
    constructor(private adminService:AdminService,private http:HttpClient,private customerService:CustomerService) { }
  
    public doLogin(adminName:string,adminPassword:string):boolean
    {
      debugger
     this.adminService.extractUser(adminName,adminPassword).subscribe(response=>
      {
        console.log(response);
        this.admin=response;
      });
      if(adminName==this.admin.adminName && adminPassword==this.admin.adminPassword)
      {
        debugger
          sessionStorage.setItem("adminName",this.admin.adminName);
          sessionStorage.setItem("adminPassword",this.admin.adminPassword);
          return true;
        }
      
      else{
        swal("Invalid Login Creditinals");

        return false;
        
      }
    }
    public doUserLogin(userName:string,userPassword:string):boolean
    {
      debugger
     this.customerService.extract(userName,userPassword).subscribe(response=>
      {
        console.log(response);
        this.user=response;
      });
      if(userName==this.user.userName && userPassword==this.user.userPassword)
      {
        debugger
          sessionStorage.setItem("userName",this.user.userName);
          sessionStorage.setItem("userPassword",this.user.userPassword);
          return true;
        }
      
      else{
        alert("Invalid Login Creditinals");

        return false;

      }
    }
    public isAdmin():boolean{
      let adminName=sessionStorage.getItem('adminName');
      let adminPassword=sessionStorage.getItem('adminPassword');
      console.log(adminName + " " + adminPassword);
    return !(adminName==null);
    }
    public isCustomer():boolean{
      let userName=sessionStorage.getItem('userName');
      let userPassword=sessionStorage.getItem('userPassword');
      console.log(userName + " " + userPassword);
    return !(userName==null);
    }
    public invokeLogout():void{
     
     
      sessionStorage.removeItem('adminName');
      sessionStorage.removeItem('adminPassword');
      sessionStorage.removeItem('userName');
      sessionStorage.removeItem('userPassword');
      sessionStorage.clear();
    }

  }
  