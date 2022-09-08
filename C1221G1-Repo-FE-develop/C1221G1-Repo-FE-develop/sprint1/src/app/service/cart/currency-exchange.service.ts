import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const myHeaders = new HttpHeaders();
myHeaders.append('apikey', '8f7QhKWyUMHUXuhVBmlpkbJ3gu8r9NkI');
const httpOptions = {
  headers: new HttpHeaders({
    apikey: '8f7QhKWyUMHUXuhVBmlpkbJ3gu8r9NkI'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CurrencyExchangeService {

  constructor(private httpClient: HttpClient) {
  }

  public getRate(): Observable<any> {
    return this.httpClient.get('https://api.apilayer.com/currency_data/convert?to=VND&from=USD&amount=1', httpOptions);
  }
}
