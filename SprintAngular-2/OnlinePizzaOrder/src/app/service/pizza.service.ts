import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Pizza } from '../model/pizza';
import { Projecturl } from '../projecturl';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  url:string=Projecturl.getUrl();
  //put, get, post, delete
    constructor(private http:HttpClient) { }
  
    public addPizza(pizza:Pizza):Observable<any>
    {
  return this.http.post(this.url+"/CreatePizza", pizza,{responseType:'text'});
    }

    public extractPizzas():Observable<any>
    {
  return this.http.get<any>(this.url+"/pizza");
    }
    public Searchpizzaid(id:number):Observable<any>
    {
  return this.http.get<any>(this.url+`Pizza/${id}`);
    }
    public deletePizza(id: number):Observable<any>
    {
      return this.http.delete<any>(this.url+`DeletePizza/${id}`);
    }
    public updatePizza(pizza:Pizza,pizzaId:number):Observable<any>
    {
      return this.http.put<any>(this.url+`Update/pizza/${pizzaId}`,pizza);
    }
  }
