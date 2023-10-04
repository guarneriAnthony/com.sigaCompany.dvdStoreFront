import { Component, OnInit } from '@angular/core';
import { TypeEnum } from '../utils/enums/TypeEnums';
import { DvdServiceService } from '../dvd-service.service';
import { HttpClient } from '@angular/common/http';

export interface Dvd {
  name: String,
  type: TypeEnum,
  quantity: number,
  price: bigint,
  description: String,
  image: String;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
dvds : Array<Dvd>  = [] 
dvdToShow : Array<Dvd> = []
typeFilter: string = ''
data : Array<Dvd>  = [] 


handleTypeClickButton = (type: string) => {
    this.dvdToShow = this.dvds.filter((value) => {
      return value.type === type
    })
  }


constructor(private http: HttpClient, public dvdServiceService: DvdServiceService){}


ngOnInit(): void {
    this.http.get<any>('http://localhost:8080/dvdStore').subscribe({
      next: (data) => {
        this.data = data;
        for (const x of this.data) {
          const dvd: Dvd = {
            name: x.name,
            type: x.type,
            quantity: x.quantity,
            price: x.price,
            description: x.description,
            image: x.image
          };
          this.dvds.push(dvd);
        }
      },
      error: error => {
        console.log("Lerreur est ICI", error);
      }
    })
    this.dvdToShow = this.dvds
  }  
}



