import {Injectable} from '@angular/core';
import {GrowlMessageService} from './services/growl-message.service';
import {isNullOrUndefined} from 'util';
import {AdvancedLog} from './services/advanced-log';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AppService {
  public readonly DOMAIN = 'http://localhost:8080/';

  constructor(private http: HttpClient,
              private growlMessageService: GrowlMessageService) {
  }

  public callRestGet(url: string): Promise<any> {
    return this.http.get(`${this.DOMAIN}${url}`)
      .toPromise().then(dataResponse => {
        AdvancedLog.separatedLabeledLog('callRestGet', dataResponse);
        return dataResponse;
      })
      .catch(err => {
        AdvancedLog.error(err);
      });
  }

  public callRestSave(saveUrl: string, param: any, showSuccessMessage?: boolean): Promise<any> {
    return this.successIndicatedOperation(saveUrl, param, showSuccessMessage, 'Save successful!');
  }

  public callRestDelete(deleteUrl: string, showSuccessMessage?: boolean): Promise<any> {
    return this.http.delete(`${this.DOMAIN}${deleteUrl}`)
      .toPromise().then(() => {
        if (!isNullOrUndefined(showSuccessMessage)) {
          this.growlMessageService.successMessage('Delete succesful!');
        }
      })
      .catch(err => {
        AdvancedLog.error(err);
      });
  }

  private successIndicatedOperation(url: string, param: any, showSuccessMessage: boolean, messageBody: string): Promise<any> {
    showSuccessMessage = !isNullOrUndefined(showSuccessMessage) && showSuccessMessage;
    return this.callRestPost(url, param)
      .then(dataResponse => {
        if (showSuccessMessage) {
          this.growlMessageService.successMessage(messageBody);
        }
        return Promise.resolve(dataResponse);
      })
      .catch(error => {
        return Promise.reject(error);
      });
  }

  public callRestUpdate(updateUrl: string, param: any, showSuccessMessage?: boolean): Promise<any> {
    return this.http.put(`${this.DOMAIN}${updateUrl}`, param)
      .toPromise().then(dataResponse => {
        if (!isNullOrUndefined(showSuccessMessage)) {
          this.growlMessageService.successMessage('Save succesful!');
        }
        return dataResponse;
      })
      .catch(err => {
        AdvancedLog.error(err);
      });
  }

  public callRestPost(url: string, param?: any): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      AdvancedLog.log(`callRestPost, url: ${this.DOMAIN}` + url);
      if (!isNullOrUndefined(param)) {
        AdvancedLog.separatedLabeledLog('sent param', param);
      }
      this.http.post(this.DOMAIN + url, param)
        .toPromise().then(response => {
        resolve(response);
      }).catch(err => {
        this.handleError(err, reject);
      });
    });
  }

  private handleError(error: any, reject): void {
    AdvancedLog.separatedLabeledLog('error object', error);
    let message = '';
    if (!isNullOrUndefined(error.errorMessage)) {
      message = error.errorMessage;
    } else {
      message = error._body;
    }

    this.growlMessageService.errorMessage(message);
    reject(message);
  }

}
