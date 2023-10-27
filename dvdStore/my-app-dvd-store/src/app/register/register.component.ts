import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DvdServiceService, AuthRequestDto } from '../dvd-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user: AuthRequestDto = {
    username: "",
    password: ""
  };

  constructor(private route: ActivatedRoute, private dvdService: DvdServiceService) {
    }


  formulaireRegister() {
    this.dvdService.postUserByAxios(this.user).then(result => {
      console.log(result);
    });
  }

}
