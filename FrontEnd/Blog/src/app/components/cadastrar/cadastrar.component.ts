import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/Usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

  usuario: Usuario = new Usuario();
  senhaDigitada: string;
  usuarioSelecionado: string;

  constructor(
    private service: UsuarioService,
    private rota: Router
  ) { }

  ngOnInit() {
    window.scroll(0,0)
  }

  confirmarSenha(event: any) {
    this.senhaDigitada = event.target.value;
  }

  tipoUsuario(event: any) {
    this.usuarioSelecionado = event.target.value;
  }

  cadastrar() {
    this.usuario.tipo = this.usuarioSelecionado
    if(this.usuario.senha != this.senhaDigitada) {
      alert("Senhas não coincidem");
    } else {
      this.service.cadastrar(this.usuario).subscribe((resposta: Usuario) => { 
        this.usuario = resposta
        this.rota.navigate(['/entrar'])
        alert("Usuário cadastrado com sucesso")
      })
    }
  }
}
