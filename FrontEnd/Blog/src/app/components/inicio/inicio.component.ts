import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioLogin } from 'src/app/models/UsuarioLogin';
import { UsuarioService } from 'src/app/services/usuario.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  constructor(
    private rota: Router,
    private usuarioService: UsuarioService
  ) { }

  ngOnInit() {
    if(environment.token == "")
      this.rota.navigate(["/entrar"])
  }

  adm() {
    let tipo = environment.tipo
    if(tipo != "Administrador"){
      return false
    }
    return true
  }
}
