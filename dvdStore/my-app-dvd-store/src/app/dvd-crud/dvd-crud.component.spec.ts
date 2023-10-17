import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DvdCrudComponent } from './dvd-crud.component';

describe('DvdCrudComponent', () => {
  let component: DvdCrudComponent;
  let fixture: ComponentFixture<DvdCrudComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DvdCrudComponent]
    });
    fixture = TestBed.createComponent(DvdCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
