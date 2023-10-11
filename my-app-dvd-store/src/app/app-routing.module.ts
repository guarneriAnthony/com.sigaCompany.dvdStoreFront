import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DvdDetailComponent } from './dvd-detail/dvd-detail.component';
import { DvdCrudComponent } from './dvd-crud/dvd-crud.component';
import { ClientsListComponent } from './clients-list/clients-list.component';
import { SalesListComponent } from './sales-list/sales-list.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'dvd-detail/:id',
    component: DvdDetailComponent
  },
  {
    path: 'dvd-crud/:id',
    component: DvdCrudComponent
  },
  {
    path: 'clients-list',
    component: ClientsListComponent
  },
  {
    path: 'sales-list',
    component: SalesListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
