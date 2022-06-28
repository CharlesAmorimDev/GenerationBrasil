import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

import { Usuario } from '../models/Usuario';
import { UsuarioLogin } from '../models/UsuarioLogin';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(
    private https: HttpClient) { }

  token = {headers: new HttpHeaders().set("Authorization", environment.token)}

  getById(id: number): Observable<Usuario> {
    return this.https.get<Usuario>(`https://blogcharlesamorim.herokuapp.com/usuarios/${id}`, this.token);
  }

  getByNome(nome: string): Observable<Usuario> {
    return this.https.get<Usuario>(`https://blogcharlesamorim.herokuapp.com/usuarios/nome/${nome}`, this.token);
  }

  getbyEmail(email: string): Observable<Usuario> {
    return this.https.get<Usuario>(`https://blogcharlesamorim.herokuapp.com/usuarios/email/${email}`, this.token);
  }

  getAll(): Observable<Usuario> {
    return this.https.get<Usuario>("https://blogcharlesamorim.herokuapp.com/usuario/all", this.token);
  }

  cadastrar(usuario: Usuario): Observable<Usuario>{
    return this.https.post<Usuario>("https://blogcharlesamorim.herokuapp.com/usuarios/cadastrar", usuario);
  }

  entrar(usuarioLogin: UsuarioLogin): Observable<UsuarioLogin>{
    return this.https.post<UsuarioLogin>("https://blogcharlesamorim.herokuapp.com/usuarios/entrar", usuarioLogin);
  }

  logado() {
    var ok: boolean = false
    if(environment.token != "") {
      ok = true;
    }
    return ok;
  }
}
