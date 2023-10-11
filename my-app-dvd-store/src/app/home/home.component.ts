import { Component, OnInit } from '@angular/core';
import {DvdGetAllDTO, DvdServiceService } from '../dvd-service.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})


export class HomeComponent implements OnInit {

dvds : Array<DvdGetAllDTO>  = [] 
dvdToShow : Array<DvdGetAllDTO> = []


constructor(private dvdServiceService: DvdServiceService){}

resetFilter  = () => {
  this.dvdToShow = this.dvds
}
getQuantityText(quantity: number): string {
  return quantity === 0 ? 'Out of Stock' : quantity.toString();
}


handleTypeClickButton = (type: string) => {
    this.dvdToShow = this.dvds.filter((value) => {
      return value.type === type
    })
  }
filterByPrice = () => {
  this.dvdToShow = this.dvds.filter((dvd) => {
    return dvd.price < 10;
  })
};
filterByPriceRange = (minPrice: number, maxPrice: number) => {
  this.dvdToShow = this.dvds.filter((dvd) => {
    return dvd.price >= minPrice && dvd.price <= maxPrice;
  })
};
filterByPriceAbove = (minPrice: number) => {
  this.dvdToShow = this.dvds.filter((dvd) => {
    return dvd.price > minPrice;
  })
};





ngOnInit(): void {
  this.dvdServiceService.getAllAxios()
  .then((data) => {
  this.dvds = data;
  this.dvdToShow = this.dvds
  }) 
}

}


