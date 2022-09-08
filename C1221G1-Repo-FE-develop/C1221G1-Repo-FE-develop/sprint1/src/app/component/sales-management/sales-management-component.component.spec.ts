import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalesManagementComponentComponent } from './sales-management-component.component';

describe('SalesManegementComponentComponent', () => {
  let component: SalesManagementComponentComponent;
  let fixture: ComponentFixture<SalesManagementComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalesManagementComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalesManagementComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
