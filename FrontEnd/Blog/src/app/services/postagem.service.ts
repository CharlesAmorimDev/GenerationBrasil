import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Postagem } from '../models/Postagem';

@Injectable({
  providedIn: 'root'
})
export class PostagemService {

  constructor(
    private http: HttpClient) { }

    token = {headers: new HttpHeaders().set("Authorization", environment.token)}

    getById(id: number): Observable<Postagem> {
      return this.http.get<Postagem>(`https://blogcharlesamorim.herokuapp.com/postagens/${id}`, this.token);
    }

    getByTitulo(titulo: string): Observable<Postagem> {
      return this.http.get<Postagem>(`https://blogcharlesamorim.herokuapp.com/postagens/titulo/${titulo}`, this.token);
    }

    getByTexto(texto: string): Observable<Postagem> {
      return this.http.get<Postagem>(`https://blogcharlesamorim.herokuapp.com/postagens/texto/${texto}`, this.token);
    }

    getAll(): Observable<Postagem> {
      return this.http.get<Postagem>(`https://blogcharlesamorim.herokuapp.com/postagens/all`, this.token);
    }

    cadastrar(postagem: Postagem): Observable<Postagem> {
      return this.http.post<Postagem>("https://blogcharlesamorim.herokuapp.com/postagens", postagem, this.token);
    }

    alterar(postagem: Postagem): Observable<Postagem> {
      return this.http.put<Postagem>("https://blogcharlesamorim.herokuapp.com/postagens", postagem, this.token);
    }

    deletar(id: number): Observable<Postagem> {
      return this.http.delete<Postagem>(`https://blogcharlesamorim.herokuapp.com/postagens/${id}`, this.token)
    }
}
