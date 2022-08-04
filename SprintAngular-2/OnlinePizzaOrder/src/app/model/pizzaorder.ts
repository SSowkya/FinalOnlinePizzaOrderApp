import { Coupon } from "./coupon";
import { Customer } from "./customer";
import { Pizza } from "./pizza";

export class Pizzaorder {
    public bookingOrderId:number;
    public orderDate:Date;
    public transactionMode:string;
    public quantity:number;
    public size:string;
    public totalCost:number;
    public customer:Customer=new Customer();
    public pizza:Pizza=new Pizza();
    public coupon:Coupon=new Coupon();
}
