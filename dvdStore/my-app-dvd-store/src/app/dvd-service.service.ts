import { Injectable } from '@angular/core';
import { TypeEnum } from './utils/enums/TypeEnums';
import axios from "axios";
import { NgForm } from '@angular/forms';

export interface DvdGetAllDTO {
  id: number,
  name: String,
  type: TypeEnum,
  quantity: number,
  price: number,
  description: String,
  image: String;
}
export interface ClientGetAllDto {
  name: String,
  email: String;
}

export interface Owner {
  login: String
  password: String
}

@Injectable({
  providedIn: 'root'
})
export class DvdServiceService {
  private baseUrl = 'http://localhost:8080/dvdStore';
  private baseUrlClient = 'http://localhost:8080/clients';

  constructor() {}




 getAllAxios = async() => {
    const response = await axios.get(this.baseUrl)
    const dvds : DvdGetAllDTO[] = response.data.map((x: any)  => ({
      id: x.id,
      name: x.name,
      type: x.type,
      quantity: x.quantity,
      price: x.price,
      description: x.description,
      image: x.image
    }))
    return dvds;
 }



 getByIdAxios = async(id: number) => {
    const response = await axios.get(this.baseUrl + '/' + id)
    const dvd : DvdGetAllDTO = response.data;
    return dvd;
 }

 putByAxios = async ( dvd: DvdGetAllDTO) => {
    const response = await axios.put(this.baseUrl + '/' + dvd.id, dvd)
    return response.data;
}
  /*Les Clients sont ici pour le moment !! à mettre au propre dans un service dedié */
  getAllClientAxios = async() => {
    const response = await axios.get(this.baseUrlClient)
    const clients : ClientGetAllDto[] = response.data.map((x: any)  => ({
      name: x.name,
      email: x.email
    }))
    return clients;
   }
  /*======*/




























}
