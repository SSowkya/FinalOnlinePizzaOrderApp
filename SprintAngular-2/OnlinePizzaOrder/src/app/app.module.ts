import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { CustomerComponent } from './component/customer/customer.component';
import { CommonmodelComponent } from './component/commonmodel/commonmodel.component';
import { MenuComponent } from './component/menu/menu.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { UserregisterationComponent } from './component/userregisteration/userregisteration.component';
import { PagenotfoundComponent } from './component/pagenotfound/pagenotfound.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UsermenuComponent } from './component/usermenu/usermenu.component';
import { PizzaorderComponent } from './component/pizzaorder/pizzaorder.component';
import { PizzaComponent } from './component/pizza/pizza.component';
import { CouponComponent } from './component/coupon/coupon.component';
import { ViewpizzaComponent } from './component/viewpizza/viewpizza.component';
import { ViewCouponComponent } from './component/view-coupon/view-coupon.component';
import { ViewCustomerComponent } from './component/view-customer/view-customer.component';
import { ViewPizzaOrderComponent } from './component/view-pizza-order/view-pizza-order.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CustomerComponent,
    CommonmodelComponent,
    MenuComponent,
    DashboardComponent,
    UserregisterationComponent,
    PagenotfoundComponent,
    UsermenuComponent,
    PizzaorderComponent,
    PizzaComponent,
    CouponComponent,
    ViewpizzaComponent,
    ViewCouponComponent,
    ViewCustomerComponent,
    ViewPizzaOrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
