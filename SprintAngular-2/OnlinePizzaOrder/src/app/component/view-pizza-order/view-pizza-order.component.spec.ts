import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPizzaOrderComponent } from './view-pizza-order.component';

describe('ViewPizzaOrderComponent', () => {
  let component: ViewPizzaOrderComponent;
  let fixture: ComponentFixture<ViewPizzaOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPizzaOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPizzaOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
