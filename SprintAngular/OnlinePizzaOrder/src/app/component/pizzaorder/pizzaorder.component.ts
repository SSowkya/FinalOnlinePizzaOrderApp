import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Coupon } from 'src/app/model/coupon';
import { Customer } from 'src/app/model/customer';
import { Pizza } from 'src/app/model/pizza';
import { Pizzaorder } from 'src/app/model/pizzaorder';
import { CouponService } from 'src/app/service/coupon.service';
import { PizzaService } from 'src/app/service/pizza.service';
import { PizzaorderService } from 'src/app/service/pizzaorder.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-pizzaorder',
  templateUrl: './pizzaorder.component.html',
  styleUrls: ['./pizzaorder.component.css']
})
export class PizzaorderComponent implements OnInit {
  pizza:Pizza=new Pizza();
  pizzas:Pizza[]=[];

  coupon:Coupon=new Coupon();
  coupons:Coupon[]=[];
  pizzaOrder:Pizzaorder=new Pizzaorder();
  private isButtonVisible = true;
  showTextBox: boolean = false;


  constructor( private pizzaOrderService:PizzaorderService, private pizzaservice:PizzaService,private couponservice:CouponService,private router:Router) { }
  ngOnInit() {
    this.getPizzaList();
    this.getCouponList();
  }
  public bookPizzaOrder():void{
    console.log(this.pizzaOrder);
    this.pizzaOrderService.bookOrder(this.pizzaOrder).subscribe((p)=>
    {
      swal("Your Order Has Booked");
    }
  );}
  public getPizzaList():void{
    //this.Issubmitted=true;
    console.log(this.pizza);
    this.pizzaservice.extractPizzas().subscribe(
      response=>
      {
  this.pizzas=response;
      }
    )
  }
  public getCouponList():void{
    //this.Issubmitted=true;
    console.log(this.pizza);
    this.couponservice.extractCoupons().subscribe(
      response=>
      {
  this.coupons=response;
      }
    )
  }
  viewselect()
  {
    this.showTextBox = !this.showTextBox; 
  }
  close()
  {
    debugger
    this.router.navigate(['usermenu']);
  }
}