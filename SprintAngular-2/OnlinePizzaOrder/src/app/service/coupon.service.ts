import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Coupon } from '../model/coupon';
import { Projecturl } from '../projecturl';

@Injectable({
  providedIn: 'root'
})
export class CouponService {

  url:string=Projecturl.getUrl();
  //put, get, post, delete
    constructor(private http:HttpClient) { }

  
    public addCoupon(coupon:Coupon):Observable<any>
    {
  return this.http.post(this.url+"CreateCoupon", coupon,{responseType:'text'});
    }

    public extractCoupons():Observable<any>
    {
  return this.http.get<any>(this.url+"coupon");
    }
    public Searchcouponid(id:number):Observable<any>
    {
  return this.http.get<any>(this.url+`Coupon/${id}`);
    }
    public deleteCoupon(id: number):Observable<any>
    {
      return this.http.delete<any>(this.url+`DeleteCoupon/${id}`);
    }
    public updateCoupon(coupon:Coupon,couponId:number):Observable<any>
    {
      return this.http.put<any>(this.url+`UpdateCoupon/coupon/${couponId}`,coupon);
    }
  }