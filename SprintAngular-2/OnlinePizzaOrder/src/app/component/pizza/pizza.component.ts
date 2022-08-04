import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pizza } from 'src/app/model/pizza';
import { PizzaService } from 'src/app/service/pizza.service';
import swal from 'sweetalert';

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {
  pizza:Pizza=new Pizza();
  pizzas:Pizza[]=[];
  Issubmitted:boolean;
  uName: any;
  UPassword: any;
  errorMsg: string="";

  constructor(private pizzaservice:PizzaService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit() {
  
    this.uName = this.route.snapshot.params['uName']

    this.UPassword = this.route.snapshot.params['UPassword']
  }
  public addPizza():void{
    console.log(this.pizza);
    this.pizzaservice.addPizza(this.pizza).subscribe((p)=>
    {
     // this.msg=p['message'];
      //console.log(this.msg);
      console.log(p);
      this.errorMsg=p.errorMsg;
      console.log(this.errorMsg);
      swal("Pizza added");
      // this.router.navigate(['login']);

    }
  );
  
  }
  public getPizzaList():void{
    this.Issubmitted=true;
    console.log(this.pizza);
    this.pizzaservice.extractPizzas().subscribe(
      response=>
      {
  this.pizzas=response;
      }
    )
  }
  public cancel()
  {
    this.router.navigate(['login']);

  }
}
