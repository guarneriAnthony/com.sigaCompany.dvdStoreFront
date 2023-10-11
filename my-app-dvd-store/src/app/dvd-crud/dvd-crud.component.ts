import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DvdServiceService, DvdGetAllDTO } from '../dvd-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-dvd-crud',
  templateUrl: './dvd-crud.component.html',
  styleUrls: ['./dvd-crud.component.css']
})
export class DvdCrudComponent implements OnInit {
  dvdId: number = this.route.snapshot.params['id'];
  dvdToShow: DvdGetAllDTO ;

constructor(private route: ActivatedRoute, private dvdService : DvdServiceService) {
  this.dvdToShow = {} as DvdGetAllDTO;
}

formulaire() {
  if (this.dvdId) {
    this.dvdService.putByAxios(this.dvdToShow).then(result => {
  console.log(result);
})
  }
//ici le post aux lieu du put
}





ngOnInit(): void {
  if (this.dvdId) {
  this.dvdService.getByIdAxios(this.dvdId).then(result => {
    this.dvdToShow = result;
  })
  }
};
}
