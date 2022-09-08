import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatistitalChartComponent } from './statistital-chart.component';

describe('StatistitalChartComponent', () => {
  let component: StatistitalChartComponent;
  let fixture: ComponentFixture<StatistitalChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatistitalChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatistitalChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
