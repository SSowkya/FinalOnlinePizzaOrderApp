import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommonmodelComponent } from './commonmodel.component';

describe('CommonmodelComponent', () => {
  let component: CommonmodelComponent;
  let fixture: ComponentFixture<CommonmodelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommonmodelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommonmodelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
