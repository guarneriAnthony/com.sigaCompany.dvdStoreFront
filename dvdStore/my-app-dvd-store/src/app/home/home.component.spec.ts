// import { ComponentFixture, TestBed } from '@angular/core/testing';
// import { HomeComponent } from './home.component';
//
// describe('HomeComponent', () => {
//   let component: HomeComponent;
//   let fixture: ComponentFixture<HomeComponent>;
//
//   beforeEach(() => {
//     TestBed.configureTestingModule({
//       declarations: [HomeComponent]
//     });
//     fixture = TestBed.createComponent(HomeComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });
//
//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });
//
// //   it('should reset the filter', () => {
// //     component.dvds = [];
// //     component.dvdToShow = [];
// //     component.resetFilter();
// //     expect(component.dvdToShow).toEqual(component.dvds);
// //   });
//
//   it('should return "Out of Stock" for quantity 0', () => {
//     const result = component.getQuantityText(0);
//     expect(result).toBe('Out of Stock');
//   });
//
//   it('should return quantity as a string for non-zero quantity', () => {
//     const result = component.getQuantityText(5);
//     expect(result).toBe('5');
//   });
//
// //   it('should filter DVDs by type', () => {
// //     component.dvds = [
// //       { type: 'Action' },
// //       { type: 'Comedy' },
// //       { type: 'Action' }
// //     ];
//     component.handleTypeClickButton('Action');
//     expect(component.dvdToShow.length).toBe(2);
//     expect(component.dvdToShow[0].type).toBe('Action');
//     expect(component.dvdToShow[1].type).toBe('Action');
//   });
// });
