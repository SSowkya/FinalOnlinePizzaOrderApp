import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pizza } from 'src/app/model/pizza';
import { PizzaService } from 'src/app/service/pizza.service';
import swal from 'sweetalert';
@Component({
  selector: 'app-viewpizza',
  templateUrl: './viewpizza.component.html',
  styleUrls: ['./viewpizza.component.css']
})
export class ViewpizzaComponent implements OnInit {
  pizza:Pizza=new Pizza();
  pizzas:Pizza[]=[];
  Issubmitted:boolean;
  private isButtonVisible = true;
  private isShow = false;
  showDialog1: boolean;
  pId: number;
 pName: string = "";
  pDescription: string = "";
  pCost: number;
  PcostAfterCoupon: number ;
  pizzaId: number;
  pType:string;


  

  constructor(private pizzaservice:PizzaService,private router:Router) { }


  ngOnInit() {
  }
  public getPizzaList():void{
    this.Issubmitted=true;
    this.isShow=true;
    console.log(this.pizza);
    this.pizzaservice.extractPizzas().subscribe(
      response=>
      {
  this.pizzas=response;
      }
    )
  }
  public back()
  {
    this.router.navigate(['menu']);

  }
  EditPizza(pizzaId: number) {
    debugger
    this.showDialog1 = true;
    // this.customerId=this.route.snapshot.params["CId"];

    this.pizzaservice.Searchpizzaid(pizzaId).subscribe(response => {
      this.pizza = response;
      this.pName = this.pizza.pizzaName;
      this.pType = this.pizza.pizzaType;
      this.pDescription = this.pizza.pizzaDescription;
      this.pCost = this.pizza.pizzaCost;
      this.PcostAfterCoupon = this.pizza.pizzaCostAfterCoupon;

    })
  }
  closePopup() {
    this.showDialog1 = false;

  }
  public DeletePizza(pizzaId: number) {

    this.pizzaservice.deletePizza(pizzaId).subscribe(response => {
      console.log(response);
      swal("Pizza Record has Deleted");
      window.location.reload();
    });

  }
  public updatePizza(pizzaId: number): void {


    this.pizza.pizzaName = this.pName;
    this.pizza.pizzaType = this.pType;

    this.pizza.pizzaDescription = this.pDescription;
    this.pizza.pizzaCost = this.pCost;
    this.pizza.pizzaCostAfterCoupon = this.PcostAfterCoupon;


    this.pizzaservice.updatePizza(this.pizza, pizzaId).subscribe(response => {

      console.log(response);
    });
    swal("Pizza Details have been updated")
    this.showDialog1 = false;
    window.location.reload();
  }
  
}
