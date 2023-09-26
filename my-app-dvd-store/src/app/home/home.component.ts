import { Component, OnInit } from '@angular/core';
import { TypeEnum } from '../utils/enums/TypeEnums';
import { DvdServiceService } from '../dvd-service.service';

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


constructor(private DvdServiceService : DvdServiceService){}

handleTypeClickButton = (type : String) => {
  this.dvdToShow = this.dvds.filter((value) => {
    return value.type === type
  })
}

//ngOnInit(){
  //this.dvdToShow = this.dvds
//}
async ngOnInit() {

  const dvdGetAlldtos = await this.DvdServiceService.getAllDvd()

  for (let x of dvdGetAlldtos) {
    const dvd : Dvd = {
      name: x.name,
      type: x.type,
      quantity: x.quantity,
      price: x.price,
      description: x.description,
      image: x.image
    }
    this.dvds.push(dvd);
  }
}
}
