import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DvdServiceService, DvdGetAllDTO } from '../dvd-service.service';

@Component({
  selector: 'app-dvd-detail',
  templateUrl: './dvd-detail.component.html',
  styleUrls: ['./dvd-detail.component.css']
})
export class DvdDetailComponent implements OnInit {
  dvdId: number = this.route.snapshot.params['id'];
  dvdToShow: DvdGetAllDTO | null = null;

  
  constructor(private route: ActivatedRoute, private dvdService : DvdServiceService) {}


  getQuantityText(quantity: number): string {
    return quantity === 0 ? 'Out of Stock' : quantity.toString();
  }

  ngOnInit(): void {
      this.dvdService.getByIdAxios(this.dvdId).then(result => {
        this.dvdToShow = result;
        console.log(this.dvdToShow);
      })
    };



  }


