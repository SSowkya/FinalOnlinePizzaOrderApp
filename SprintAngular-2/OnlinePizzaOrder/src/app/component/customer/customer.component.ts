import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/service/customer.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customer:Customer=new Customer();
  msg: any;

  constructor(private customerService:CustomerService,private router:Router) { }

  ngOnInit() {
  }
 
    public register():void{
      debugger
      console.log(this.customer);
      this.customerService.addCustomer(this.customer).subscribe((p)=>
      {
        swal("Customer Added");
        this.router.navigate(['login'])
    
      }
    );
    }
   
    
    cancel()
    {
      this.router.navigate(['login'])
    }
  }

