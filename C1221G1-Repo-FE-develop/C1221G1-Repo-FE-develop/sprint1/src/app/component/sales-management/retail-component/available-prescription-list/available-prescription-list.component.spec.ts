import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailablePrescriptionListComponent } from './available-prescription-list.component';

describe('AvailablePrescriptionListComponent', () => {
  let component: AvailablePrescriptionListComponent;
  let fixture: ComponentFixture<AvailablePrescriptionListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvailablePrescriptionListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailablePrescriptionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
