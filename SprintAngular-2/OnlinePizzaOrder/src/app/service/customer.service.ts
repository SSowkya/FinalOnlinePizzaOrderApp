import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Customer } from '../model/customer';
import { Projecturl } from '../projecturl';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  url:string=Projecturl.getUrl();
  //put, get, post, delete
    constructor(private http:HttpClient) { }
  
    public addCustomer(customer:Customer):Observable<any>
    {
  return this.http.post(this.url+"CreateCustomer", customer,{responseType:'text'});
    }
    public extract(userName:string,userPassword:string): Observable<any>{
      return this.http.get<any>(this.url+`user/login/${userName}/${userPassword}`);
   
    }
    public extractUserById(id:number):Observable<any>
    {
      return this.http.get<any>(this.url+`User/${id}`);
    }
    public resetPassword(oldPassword:string,newPassword:string): Observable<any>{
      return this.http.get<any>(this.url+`Update/${oldPassword}/${newPassword}`);
   
    }
    public extractCustomers():Observable<any>
    {
  return this.http.get<any>(this.url+"customer");
    }
    public extractCustomerById(customerId:number):Observable<any>
    {
      return this.http.get<any>(this.url+`Customer/${customerId}`);
    }
    public deleteCustomer(id: number):Observable<any>
    {
      return this.http.delete<any>(this.url+`DeleteCustomer/${id}`);
    }
    public updateCustomer(customer:Customer,customerId:number):Observable<any>
    {
      return this.http.put<any>(this.url+`Update/customer/${customerId}`,customer);
    }
    public updatePassword(oldPassword:string , newPassword:string):Observable<any>
    {
      return this.http.put<any>(this.url+`Update/${oldPassword}/${newPassword}`,null);
    }
  }