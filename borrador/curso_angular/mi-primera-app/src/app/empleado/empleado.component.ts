import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  // template: '<p>Aquí iría un empleado</p>',
  styleUrls: ['./empleado.component.css'],
  // styles: ['p{background-color:red;}'],
})
export class EmpleadoComponent implements OnInit {
  nombre = 'Juan';

  apellido = 'Díaz';

  edad = 18;

  empresa = 'Pildoras Informaticas';

  // cambiaEmpresa(event: Event) {
  //   this.empresa = (<HTMLInputElement>event.target).value;
  // }

  // getEdad() {
  //   return this.edad;
  // }

  // llamaEmpresa(value: String) {}

  habilitacionCuadro = false;

  usoRegistrado = false;

  textoDeRegistro = 'No hay nadie registrado';

  getRegistroUsuario() {
    this.usoRegistrado = false;
  }

  setusuarioRegistrado(event: Event) {
    // alert('El usuario se acaba de registrar');
    // this.textoDeRegistro = 'El usuario se acaba de registrar';
    // alert(event.target);
    if ((<HTMLInputElement>event.target).value == 'si') {
      this.textoDeRegistro = 'El usuario se acaba de registrar';
    } else {
      this.textoDeRegistro = 'No hay nadie registrado';
    }
  }

  constructor() {}

  ngOnInit(): void {}
}
