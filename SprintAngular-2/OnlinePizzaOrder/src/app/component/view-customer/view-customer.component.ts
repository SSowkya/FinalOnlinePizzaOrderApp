import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/service/customer.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  customer: Customer = new Customer();
  customers: Customer[] = [];
  Issubmitted: boolean;
  private isButtonVisible = true;
  private isShow = false;
  showDialog1: boolean;
  custId: number;
  custName: string = "";
  custAddress: string = "";
  custMobile: number;
  custEmail: string = "";
  customerId: number;
  msg: string;
  constructor(private customerservice: CustomerService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    // this.getCouponList();

  }
  public getCustomersList(): void {
    this.Issubmitted = true;
    this.isShow = true;
    console.log(this.customer);
    this.customerservice.extractCustomers().subscribe(
      response => {
        this.customers = response;
      }
    )
  }
  public back() {
    this.router.navigate(['menu']);

  }
  EditCustomer(customerId: number) {
    debugger
    this.showDialog1 = true;
    // this.customerId=this.route.snapshot.params["CId"];

    this.customerservice.extractCustomerById(customerId).subscribe(response => {
      this.customer = response;
      this.custName = this.customer.customerName;
      this.custMobile = this.customer.customerMobile;
      this.custEmail = this.customer.customerEmail;
      this.custAddress = this.customer.customerAddress;

    })
  }
  closePopup() {
    this.showDialog1 = false;

  }
  public DeleteCustomer(customerId: number) {

    this.customerservice.deleteCustomer(customerId).subscribe(response => {
      console.log(response);
      swal("Customer is Deleted");
      window.location.reload();

    });

  }
  public updateCustomer(customerId: number): void {

    this.customer.customerName = this.custName;
    this.customer.customerMobile = this.custMobile;
    this.customer.customerEmail = this.custEmail;
    this.customer.customerAddress = this.custAddress;


    this.customerservice.updateCustomer(this.customer, customerId).subscribe(response => {

      console.log(response);
    });
    swal("Customer Details have been updated")
    this.showDialog1 = false;
    window.location.reload();
  }
  
}
