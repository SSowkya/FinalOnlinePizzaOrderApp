import { TestBed } from '@angular/core/testing';

import { PizzaorderService } from './pizzaorder.service';

describe('PizzaorderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PizzaorderService = TestBed.get(PizzaorderService);
    expect(service).toBeTruthy();
  });
});
