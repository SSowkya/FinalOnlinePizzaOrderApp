import { typeWithParameters } from '@angular/compiler/src/render3/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Coupon } from 'src/app/model/coupon';
import { CouponService } from 'src/app/service/coupon.service';

@Component({
  selector: 'app-view-coupon',
  templateUrl: './view-coupon.component.html',
  styleUrls: ['./view-coupon.component.css']
})
export class ViewCouponComponent implements OnInit {
   coupon:Coupon=new Coupon();
  coupons:Coupon[]=[];
  Issubmitted:boolean;
  private isButtonVisible = true;
  private isShow = false;
  showDialog1: boolean;
  cId: number;
  cName: string = "";
   cDescription: string = "";
   cpizzaId: number;

 
   couponId: number;
   cType:string;
  errorMsg:string="No changes Found";
  error:boolean;

  constructor(private couponservice:CouponService,private router:Router) { }

  ngOnInit() {
   // this.getCouponList();
   

  }
  public getCouponList():void{
    this.Issubmitted=true;
    this.isShow=true;
    console.log(this.coupon);
    this.couponservice.extractCoupons().subscribe(
      response=>
      {
  this.coupons=response;
      }
    )
  }
  public back()
  {
    this.router.navigate(['menu']);

  }
  EditCoupon(couponId: number) {
    debugger
    this.showDialog1 = true;
    // this.customerId=this.route.snapshot.params["CId"];

    this.couponservice.Searchcouponid(couponId).subscribe(response => {
      this.coupon = response;
      this.cName = this.coupon.couponName;
      this.cDescription = this.coupon.couponDescription;
      this.cType = this.coupon.couponType;
      this.cpizzaId = this.coupon.couponPizzaId;

    })
  }
  closePopup() {
    this.showDialog1 = false;

  }
  public DeleteCoupon(couponId: number) {

    this.couponservice.deleteCoupon(couponId).subscribe(response => {
      console.log(response);
    });

  }
  public updateCoupon(couponId: number): void {


    this.coupon.couponName = this.cName;
    this.coupon.couponType = this.cType;
    this.coupon.couponDescription= this.cDescription;
    this.coupon.couponPizzaId = this.cpizzaId;

    this.couponservice.updateCoupon(this.coupon, couponId).subscribe(response => {

      console.log(response);
     this.errorMsg=response.errorMsg;
     
      
    });
    this.showDialog1 = false;
    window.location.reload();
  }
}
