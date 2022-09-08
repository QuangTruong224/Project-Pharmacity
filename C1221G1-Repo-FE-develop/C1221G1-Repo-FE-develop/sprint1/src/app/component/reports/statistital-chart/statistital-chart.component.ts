import {Component, OnInit} from '@angular/core';
import {ReportService} from "../../../service/report.service";
import {Static} from "../../../model/static";
import {Chart, registerables} from 'chart.js';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import * as $ from "jquery";
import {StaticByMonth} from "../../../model/static-by-month";
import {ToastrService} from "ngx-toastr";

Chart.register(...registerables);

@Component({
  selector: 'app-statistital-chart',
  templateUrl: './statistital-chart.component.html',
  styleUrls: ['./statistital-chart.component.css']
})
export class StatistitalChartComponent implements OnInit {
  statics: Static[] = [];
  staticsByMonth: StaticByMonth[] = [];
  public year = true;
  public month = true;
  canvas: any;
  ctx: any;
  show = false;
  show1 = false;
  showYear: string;
  showMonth: string;
  staticForm: FormGroup;

  constructor(private reportService: ReportService, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.staticForm = new FormGroup({
      year: new FormControl('', [Validators.required]),
      month: new FormControl('', [Validators.required]),
    });
  }
  submit() {
    $('#myChart').remove(); // this is my <canvas> element
    $('#containChart').append('<canvas style="width: 100%" id="myChart"><canvas>');
    if ((this.staticForm.value.month != '' && this.staticForm.value.year == '')||
      (this.staticForm.value.month == '' && this.staticForm.value.year == '')) {
      this.show = false;
      this.show1 = false;
    } else if (this.staticForm.value.month != '' && this.staticForm.value.year != '') {
      this.statics = [];
      this.reportService.getStaticByMonth(this.staticForm.value.month, this.staticForm.value.year)
        .subscribe(staticsByMonth => {
          console.log(staticsByMonth);
          this.showMonth = this.staticForm.value.month;
          this.showYear = this.staticForm.value.year;
          this.show = true;
          this.show1 = true;
          this.staticsByMonth = staticsByMonth;
          this.canvas = document.getElementById('myChart');
          this.ctx = this.canvas.getContext('2d');
          const myChart = new Chart(this.ctx, {
            type: 'line',
            data: {
              labels: ['Ngày 1', 'Ngày 2', 'Ngày 3', 'Ngày 4', 'Ngày 5', 'Ngày 6', 'Ngày 7', 'Ngày 8', 'Ngày 9', 'Ngày 10'
                , 'Ngày 11', 'Ngày 12', 'Ngày 13', 'Ngày 14', 'Ngày 15', 'Ngày 16', 'Ngày 17', 'Ngày 18', 'Ngày 19', 'Ngày 20'
                , 'Ngày 21', 'Ngày 22', 'Ngày 23', 'Ngày 24', 'Ngày 25', 'Ngày 26', 'Ngày 27', 'Ngày 28', 'Ngày 29', 'Ngày 30', 'Ngày 31'],
              datasets: [
                {
                  label: 'Doanh thu',
                  data: [staticsByMonth[0].revenue, staticsByMonth[1].revenue, staticsByMonth[2].revenue,
                    staticsByMonth[3].revenue, staticsByMonth[4].revenue, staticsByMonth[5].revenue,
                    staticsByMonth[6].revenue, staticsByMonth[7].revenue, staticsByMonth[8].revenue,
                    staticsByMonth[9].revenue, staticsByMonth[10].revenue, staticsByMonth[11].revenue,
                    staticsByMonth[12].revenue, staticsByMonth[13].revenue, staticsByMonth[14].revenue,
                    staticsByMonth[15].revenue, staticsByMonth[16].revenue, staticsByMonth[17].revenue,
                    staticsByMonth[18].revenue, staticsByMonth[19].revenue, staticsByMonth[20].revenue,
                    staticsByMonth[21].revenue, staticsByMonth[22].revenue, staticsByMonth[23].revenue,
                    staticsByMonth[24].revenue, staticsByMonth[25].revenue, staticsByMonth[26].revenue,
                    staticsByMonth[27].revenue, staticsByMonth[28].revenue, staticsByMonth[29].revenue,
                    staticsByMonth[30].revenue],
                  borderColor: 'limegreen',
                  backgroundColor: [
                    'limegreen'
                  ],
                  borderWidth: 1
                },
                {
                  label: 'Lợi nhuận',
                  data: [staticsByMonth[0].profit, staticsByMonth[1].profit, staticsByMonth[2].profit,
                    staticsByMonth[3].profit, staticsByMonth[4].profit, staticsByMonth[5].profit,
                    staticsByMonth[6].profit, staticsByMonth[7].profit, staticsByMonth[8].profit,
                    staticsByMonth[9].profit, staticsByMonth[10].profit, staticsByMonth[11].profit,
                    staticsByMonth[12].profit, staticsByMonth[13].profit, staticsByMonth[14].profit,
                    staticsByMonth[15].profit, staticsByMonth[16].profit, staticsByMonth[17].profit,
                    staticsByMonth[18].profit, staticsByMonth[19].profit, staticsByMonth[20].profit,
                    staticsByMonth[21].profit, staticsByMonth[22].profit, staticsByMonth[23].profit,
                    staticsByMonth[24].profit, staticsByMonth[25].profit, staticsByMonth[26].profit,
                    staticsByMonth[27].profit, staticsByMonth[28].profit, staticsByMonth[29].profit,
                    staticsByMonth[30].profit],
                  borderColor: 'violet',
                  backgroundColor: [
                    'violet'
                  ],
                  borderWidth: 2
                },
              ]
            },
            options: {
              responsive: false,
              scales: {
                y: {
                  beginAtZero: true,
                },
              },
            },

          });
        });
    } else {
      this.staticsByMonth = [];
      this.show1 = false;
      this.reportService.getStatic(this.staticForm.value.year).subscribe(statics => {
        this.showYear = this.staticForm.value.year;
        this.show = true;
        console.log(statics);
        this.statics = statics;
        this.canvas = document.getElementById('myChart');
        this.ctx = this.canvas.getContext('2d');
        const myChart = new Chart(this.ctx, {
          type: 'line',
          data: {
            labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10'
              , 'Tháng 11', 'Tháng 12'],
            datasets: [
              {
                label: 'Doanh thu',
                data: [statics[0].revenue, statics[1].revenue, statics[2].revenue, statics[3].revenue
                  , statics[4].revenue, statics[5].revenue, statics[6].revenue, statics[7].revenue
                  , statics[8].revenue, statics[9].revenue, statics[10].revenue, statics[11].revenue],
                borderColor: 'limegreen',
                backgroundColor: [
                  'limegreen'
                ],
                borderWidth: 1
              },
              {
                label: 'Lợi nhuận',
                data: [statics[0].profit, statics[1].profit, statics[2].profit, statics[3].profit
                  , statics[4].profit, statics[5].profit, statics[6].profit, statics[7].profit
                  , statics[8].profit, statics[9].profit, statics[10].profit, statics[11].profit],
                borderColor: 'violet',
                backgroundColor: [
                  'violet'
                ],
                borderWidth: 2
              },
            ]
          },
          options: {
            responsive: false,
            scales: {
              y: {
                beginAtZero: true,
              },
            },
          },

        });
      });
    }
  }
}
