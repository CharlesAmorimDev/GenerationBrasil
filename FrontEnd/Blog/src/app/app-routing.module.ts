import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './components/cadastrar/cadastrar.component';
import { EntrarComponent } from './components/entrar/entrar.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { TemaComponent } from './components/tema/tema.component';

const routes: Routes = [

  {path: "", redirectTo: "entrar", pathMatch:"full"},
  {path: "entrar", component:EntrarComponent},
  {path: "cadastrar", component: CadastrarComponent},
  {path: "inicio", component: InicioComponent},
  {path: "tema", component: TemaComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
