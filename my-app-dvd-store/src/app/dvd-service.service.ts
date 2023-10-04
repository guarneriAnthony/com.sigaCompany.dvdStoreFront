
import { Injectable } from '@angular/core';
import { Axios } from 'axios';
import { TypeEnum } from './utils/enums/TypeEnums';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080/dvdStore';


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

  constructor(private http: HttpClient) { }


 getAll(): Observable<DvdGetAllDTO> {
   return this.http.get<DvdGetAllDTO>(baseUrl);    
 }

}
