import { Component, OnInit } from '@angular/core';
import { DvdServiceService, ClientGetAllDto } from '../dvd-service.service';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {

  clients : Array<ClientGetAllDto> = []
  clientToShow : Array<ClientGetAllDto> = []

constructor(private dvdServiceService: DvdServiceService){}

  ngOnInit(): void {
    this.dvdServiceService.getAllClientAxios()
    .then((data) => {
      this.clients = data;
      this.clientToShow = this.clients
    })
  }
}
