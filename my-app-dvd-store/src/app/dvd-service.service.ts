
import { Injectable } from '@angular/core';
import { Axios } from 'axios';
import { TypeEnum } from './utils/enums/TypeEnums';

export interface DvdGetAllDTO {
  name: String,
  type: TypeEnum,
  quantity: number,
  price: bigint,
  description: String,
  image: String;
  
}

@Injectable({
  providedIn: 'root'
})
export class DvdServiceService {

  constructor(private axios: Axios) { }

   getAllDvd = async () : Promise<Array<DvdGetAllDTO>> => {
    return this.axios.get('http://localhost:8080/dvdStore/');
  }

}
