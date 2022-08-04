import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Coupon } from 'src/app/model/coupon';
import { Customer } from 'src/app/model/customer';
import { Pizza } from 'src/app/model/pizza';
import { Pizzaorder } from 'src/app/model/pizzaorder';
import { CouponService } from 'src/app/service/coupon.service';
import { CustomerService } from 'src/app/service/customer.service';
import { PizzaService } from 'src/app/service/pizza.service';
import { PizzaorderService } from 'src/app/service/pizzaorder.service';
import swal from 'sweetalert';


@Component({
  selector: 'app-view-pizza-order',
  templateUrl: './view-pizza-order.component.html',
  styleUrls: ['./view-pizza-order.component.css']
})
export class ViewPizzaOrderComponent implements OnInit {
  pizzaOrder:Pizzaorder=new Pizzaorder();
  pizzaOrders:Pizzaorder[]=[];
coupons:Coupon[]=[];
pizzas:Pizza[]=[];
customers:Customer[]=[];

  Issubmitted:boolean=false;
  private isButtonVisible = true;
  private isShow = false;
  showDialog1: boolean;
  pbookingOrderId: number;
  pOrderDate:Date;
  pTransactionMode:string;
  pQuantity: number;
  pSize:string;
  pTotalCost:number;
  bookingOrderId:number;
  pcustId:string;
  uName: any;
  UPassword: any;
  

  constructor(private pizzaorderservice:PizzaorderService,private router:Router,private couponservice:CouponService,private pizzaservice:PizzaService,private customerService:CustomerService,private route:ActivatedRoute) { }


  ngOnInit() {
    
   
    this.getPizzaList();
    this.getCouponList();
   this.getCustomerList();
  }
  public getOrderHistory():void{
    debugger
    this.Issubmitted=true;
    this.isShow=true;
    console.log(this.pizzaOrders);
    this.pizzaorderservice.extractOrders().subscribe(
      response=>
      {
  this.pizzaOrders=response;
      }
    )
  }
  public back()
  {
    this.router.navigate(['usermenu']);

  }
  EditOrder(bookingOrderId: number) {
    debugger
    this.showDialog1 = true;
    // this.customerId=this.route.snapshot.params["CId"];

    this.pizzaorderservice.SearchOrderid(bookingOrderId).subscribe(response => {
      this.pizzaOrder = response;
      this.pcustId=this.pizzaOrder.customer.customerName;

      this.pTransactionMode=this.pizzaOrder.transactionMode;
      this.pQuantity=this.pizzaOrder.quantity;
      this.pSize=this.pizzaOrder.size;

    })
  }
  public updateOrder(bookingOrderId: number): void {


    this.pizzaOrder.transactionMode=this.pTransactionMode;
    this.pizzaOrder.quantity=this.pQuantity;
    this.pizzaOrder.size=this.pSize;


    this.pizzaorderservice.updateOrder(this.pizzaOrder, bookingOrderId).subscribe(response => {

      console.log(response);
    });
    this.showDialog1 = false;
    window.location.reload();
  }
  public getCouponList():void{
    this.isShow=true;
    this.couponservice.extractCoupons().subscribe(
      response=>
      {
  this.coupons=response;
      }
    )
  }
  public getPizzaList():void{
    this.isShow=true;
    this.pizzaservice.extractPizzas().subscribe(
      response=>
      {
  this.pizzas=response;
      }
    )
  }
  public getCustomerList():void{
    this.isShow=true;
    this.customerService.extractCustomers().subscribe(
      response=>
      {
  this.customers=response;
      }
    )
  }
  closePopup() {
    this.showDialog1 = false;

  }
  public DeleteOrder(orderId: number) {

    this.pizzaorderservice.deleteOrder(orderId).subscribe(response => {
      console.log(response);
      swal("You Order Has Cancelled ");
      this.router.navigate(["usermenu"]);
    });

  }
}
