import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Tema } from '../models/Tema';

@Injectable({
  providedIn: 'root'
})
export class TemaService {

  constructor(
    private http: HttpClient) { }

    token = {headers: new HttpHeaders().set("Authorization", environment.token)}

    getById(id: number): Observable<Tema> {
      return this.http.get<Tema>(`https://blogcharlesamorim.herokuapp.com/temas/${id}`, this.token)
    }

    getByTitulo(titulo: string): Observable<Tema> {
      return this.http.get<Tema>(`https://blogcharlesamorim.herokuapp.com/temas/titulo/${titulo}`, this.token)
    }

    getByDescricao(descricao: string): Observable<Tema> {
      return this.http.get<Tema>(`https://blogcharlesamorim.herokuapp.com/temas/descricao/${descricao}`, this.token)
    }

    getAll(): Observable<Tema> {
      return this.http.get<Tema>(`https://blogcharlesamorim.herokuapp.com/temas/all`, this.token)
    }

    cadastrar(tema: Tema): Observable<Tema> {
      return this.http.post<Tema>("https://blogcharlesamorim.herokuapp.com/temas", tema, this.token);
    }

    alterar(tema: Tema): Observable<Tema> {
      return this.http.put<Tema>(`https://blogcharlesamorim.herokuapp.com/temas`, tema, this.token);
    }

    deletar(id: number): Observable<Tema> {
        return this.http.delete<Tema>(`https://blogcharlesamorim.herokuapp.com/temas/${id}`, this.token);
    }
}
