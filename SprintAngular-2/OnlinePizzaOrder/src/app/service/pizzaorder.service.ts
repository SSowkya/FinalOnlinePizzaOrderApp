import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Pizzaorder } from '../model/pizzaorder';
import { Projecturl } from '../projecturl';

@Injectable({
  providedIn: 'root'
})
export class PizzaorderService {

  url:string=Projecturl.getUrl();
  //put, get, post, delete
    constructor(private http:HttpClient) { }
  
    public bookOrder(pizza:Pizzaorder):Observable<any>
    {
  return this.http.post(this.url+"bookPizza", pizza,{responseType:'text'});
    }

    public extractOrders():Observable<any>
    {
  return this.http.get<any>(this.url+"/pizzaOrder");
    }
    public SearchOrderid(id:number):Observable<any>
    {
  return this.http.get<any>(this.url+`pizzaOrder/${id}`);
    }
    public deleteOrder(id: number):Observable<any>
    {
      return this.http.delete<any>(this.url+`pizzaOrder/${id}`);
    }
    public updateOrder(order:Pizzaorder,orderId:number):Observable<any>
    {
      return this.http.put<any>(this.url+`Update/pizzaOrder/${orderId}`,order);
    }
    public calculateTotalCost(pizzaId:number):Observable<any>
 {
   return this.http.get<any>(this.url+`pizzaOrder/TotalCost/${pizzaId}`);
 }
  }

