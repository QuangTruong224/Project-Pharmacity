import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicinePrescriptionCreateComponent } from './medicine-prescription-create.component';

describe('MedicinePrescriptionCreateComponent', () => {
  let component: MedicinePrescriptionCreateComponent;
  let fixture: ComponentFixture<MedicinePrescriptionCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicinePrescriptionCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicinePrescriptionCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
