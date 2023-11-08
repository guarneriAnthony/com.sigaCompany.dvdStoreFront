import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { DvdDetailComponent } from './dvd-detail/dvd-detail.component';
import { DvdCrudComponent } from './dvd-crud/dvd-crud.component';
import { ClientsListComponent } from './clients-list/clients-list.component';
import { SalesListComponent } from './sales-list/sales-list.component';
import { RegisterComponent } from './register/register.component';
import { SigninComponent } from './signin/signin.component';
import { NewDvdComponent } from './new-dvd/new-dvd.component';
import { IonicModule } from '@ionic/angular';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DvdDetailComponent,
    DvdCrudComponent,
    ClientsListComponent,
    SalesListComponent,
    RegisterComponent,
    SigninComponent,
    NewDvdComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    IonicModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
