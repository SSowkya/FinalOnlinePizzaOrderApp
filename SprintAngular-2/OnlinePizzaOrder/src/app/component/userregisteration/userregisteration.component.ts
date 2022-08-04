import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/service/admin.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-userregisteration',
  templateUrl: './userregisteration.component.html',
  styleUrls: ['./userregisteration.component.css']
})
export class UserregisterationComponent implements OnInit {

  adminObj:Admin=new Admin();

  constructor(private adminService:AdminService,private router:Router) { }

  ngOnInit() {
  }
  public addAdmin():void{
        this.adminService.addAdmin(this.adminObj).subscribe(
   (data)=>
   {
   // console.log(data);
   swal("Admin is Added");
   this.router.navigate(['login']);
   
    }
   )
    }
    public cancel()
    {
      this.router.navigate(['login']);
 
    }
}
