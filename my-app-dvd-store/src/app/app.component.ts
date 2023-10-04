import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app-dvd-store';
  searchText = "";

  handleSearchInput = (e: any) => {
    this.searchText = e?.target.value
  }

  handleButtonSearchClick = () => {
    console.log(this.searchText)
  }
}
