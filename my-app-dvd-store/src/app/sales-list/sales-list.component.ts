import { Component } from '@angular/core';
import { DvdServiceService } from '../dvd-service.service';

@Component({
  selector: 'app-sales-list',
  templateUrl: './sales-list.component.html',
  styleUrls: ['./sales-list.component.css']
})
export class SalesListComponent {

  constructor( private dvdServiceService: DvdServiceService ) { }

}
