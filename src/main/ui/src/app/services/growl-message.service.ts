import {EventEmitter, Injectable} from '@angular/core';
import {Message} from 'primeng/api';

@Injectable()
export class GrowlMessageService {
  public emitNewMessage: EventEmitter<any> = new EventEmitter();

  constructor() {
  }

  public message(msg: Message) {
    this.emitNewMessage.emit(msg);
  }

  public errorMessage(summary, detail?) {
    this.message({severity: 'error', summary: summary, detail: detail});
  }

  public infoMessage(summary, detail?) {
    this.message({severity: 'info', summary: summary, detail: detail});
  }

  public successMessage(summary, detail?) {
    this.message({severity: 'success', summary: summary, detail: detail});
  }

  public warnMessage(summary, detail?) {
    this.message({severity: 'warn', summary: summary, detail: detail});
  }

  public messageEmitter() {
    return this.emitNewMessage;
  }
}
