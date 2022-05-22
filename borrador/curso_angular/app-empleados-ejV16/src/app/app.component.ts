import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  titulo = 'Listado de Empleados';
  nombre: string = '';
  apellido: string = '';
  cargo: string = '';
  salario: number = 0;
  empleados: any[] = [];

  insertandoEmpleado() {
    this.empleados.push({
      nombre: this.nombre,
      apellido: this.apellido,
      cargo: this.cargo,
      salario: this.salario,
    });
  }
}
