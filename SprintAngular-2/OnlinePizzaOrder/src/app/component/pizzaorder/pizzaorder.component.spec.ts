import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzaorderComponent } from './pizzaorder.component';

describe('PizzaorderComponent', () => {
  let component: PizzaorderComponent;
  let fixture: ComponentFixture<PizzaorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PizzaorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PizzaorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
