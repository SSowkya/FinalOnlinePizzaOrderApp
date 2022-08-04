import { User } from "./user";

export class Customer {
	public customerId:number;
	public customerName:string;
	public customerMobile:number;
	public  customerEmail:string;
	public customerAddress:string;
    public user:User=new User();

}
