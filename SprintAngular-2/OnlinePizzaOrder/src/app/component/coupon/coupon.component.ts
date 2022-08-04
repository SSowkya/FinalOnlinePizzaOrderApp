import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Coupon } from 'src/app/model/coupon';
import { CouponService } from 'src/app/service/coupon.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-coupon',
  templateUrl: './coupon.component.html',
  styleUrls: ['./coupon.component.css']
})
export class CouponComponent implements OnInit {
  coupon:Coupon=new Coupon();
  coupons:Coupon[]=[];
  constructor(private router:Router,private couponservice:CouponService) { }

  ngOnInit() {
  }
  addCoupon()
  {
    console.log(this.coupon);
      this.couponservice.addCoupon(this.coupon).subscribe((p)=>
      {
        swal("Coupon Added");
        this.router.navigate(['login'])
    
      }
    );
  }
  public Cancel()
  {
    this.router.navigate(['menu']);

  }
}
