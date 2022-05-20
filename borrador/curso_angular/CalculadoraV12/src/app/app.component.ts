import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Práctica calculadora del vídeo 12';
  numero1: number = 0;
  numero2: number = 0;
  resultado: number = 0;

  calculadora(event: Event):void {
    let operador: string = (<HTMLInputElement>event.target).innerHTML;
    switch (operador) {
      case '+':
        this.resultado = this.numero1 + this.numero2;
        break;
      case '-':
        this.resultado = this.numero1 - this.numero2;
        break;
      case 'x':
        this.resultado = this.numero1 * this.numero2;
        break;
      case '/':
        this.resultado = this.numero1 / this.numero2;
        break;
    }
  }
}
