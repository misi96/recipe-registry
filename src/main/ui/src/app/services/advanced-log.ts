export class AdvancedLog {
  static log(message: string): void {
    console.log(message);
  }

  static error(errorMessage: string): void {
    console.error(errorMessage);
  }

  static separatedLabeledLog(label: string, obj: any): void {
    console.log('--- ' + label + ' ---');
    console.log(obj);
    console.log('--- /' + label + ' ---');
  }

  static errorLog(label: string, obj: any): void {
    console.error('--- ' + label + ' ---');
    console.error(obj);
    console.error('--- /' + label + ' ---');
  }

  static inlineLog(name: string, value: any): void {
    console.log(`--- ${name}: ${value} ---`);
  }

  static markerLog(log: string): void {
    console.log('--- ' + log + ' ---');
  }
}
