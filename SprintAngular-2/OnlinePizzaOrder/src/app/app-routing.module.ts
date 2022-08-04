import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CouponComponent } from './component/coupon/coupon.component';
import { CustomerComponent } from './component/customer/customer.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { LoginComponent } from './component/login/login.component';
import { MenuComponent } from './component/menu/menu.component';
import { PagenotfoundComponent } from './component/pagenotfound/pagenotfound.component';
import { PizzaComponent } from './component/pizza/pizza.component';
import { PizzaorderComponent } from './component/pizzaorder/pizzaorder.component';
import { UsermenuComponent } from './component/usermenu/usermenu.component';
import { UserregisterationComponent } from './component/userregisteration/userregisteration.component';
import { ViewCouponComponent } from './component/view-coupon/view-coupon.component';
import { ViewCustomerComponent } from './component/view-customer/view-customer.component';
import { ViewPizzaOrderComponent } from './component/view-pizza-order/view-pizza-order.component';
import { ViewpizzaComponent } from './component/viewpizza/viewpizza.component';

const routes: Routes = [{path:"",component:DashboardComponent},
{ path: "login", component: LoginComponent },
{ path: "register", component: UserregisterationComponent },
{ path: "dashboard", component: DashboardComponent },
{ path: "customer", component: CustomerComponent },
{ path: "menu", component: MenuComponent },
 { path: "usermenu/:uName/:UPassword", component: UsermenuComponent },
 { path: "pizza", component: PizzaComponent },
 { path: "pizzaOrder", component: PizzaorderComponent },
 { path: "coupon", component: CouponComponent },
 { path: "viewpizza", component: ViewpizzaComponent },
 { path: "viewcoupon", component: ViewCouponComponent },
 { path: "viewcustomer", component: ViewCustomerComponent},
 { path: "vieworderhistory", component: ViewPizzaOrderComponent},
 { path: "viewcustomer/:CId", component: ViewCustomerComponent},
 { path: "usermenu", component: UsermenuComponent },






  { path: '**', component: PagenotfoundComponent },  

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
