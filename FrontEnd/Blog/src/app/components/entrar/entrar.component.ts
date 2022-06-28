import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioLogin } from 'src/app/models/UsuarioLogin';
import { UsuarioService } from 'src/app/services/usuario.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-entrar',
  templateUrl: './entrar.component.html',
  styleUrls: ['./entrar.component.css']
})
export class EntrarComponent implements OnInit {

  usuarioLogin: UsuarioLogin = new UsuarioLogin();

  constructor(
    private service: UsuarioService,
    private rota: Router
  
  ) { }

  ngOnInit() {
    window.scroll(0,0)
  }

  entrar() {
    this.service.entrar(this.usuarioLogin).subscribe( {
      next: (resposta: UsuarioLogin) => {
        this.usuarioLogin = resposta
        environment.id = this.usuarioLogin.id;
        environment.nome = this.usuarioLogin.nome;
        environment.foto = this.usuarioLogin.foto;
        environment.senha = this.usuarioLogin.senha;
        environment.token = this.usuarioLogin.token;
        environment.tipo = this.usuarioLogin.tipo;
        this.rota.navigate(["/inicio"])
        },
      error: erro => {
      if(erro.status == 401) {
        alert("Usuário ou Senha Inválido(a)") 
      }
      if(erro.status == 500) {
        alert("Usuário não encontrado")
      }
    }
    });
  }
}
