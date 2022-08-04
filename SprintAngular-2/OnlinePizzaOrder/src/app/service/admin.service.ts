import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Admin } from '../model/admin';
import { Projecturl } from '../projecturl';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  url:string=Projecturl.getUrl();
  //put, get, post, delete
    constructor(private http:HttpClient) { }
    public addAdmin(admin:Admin):Observable<any>
    {
      debugger
      return this.http.post(this.url+"CreateAdmin", admin,{responseType:'text'});

    }
    public extractUser(adminName:string,adminPassword:string): Observable<any>{
      return this.http.get<any>(this.url+`admin/login/${adminName}/${adminPassword}`);
    }
}