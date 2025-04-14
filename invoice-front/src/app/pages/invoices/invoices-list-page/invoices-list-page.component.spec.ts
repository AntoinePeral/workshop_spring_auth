import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvoicesListPageComponent } from './invoices-list-page.component';

describe('InvoicesListPageComponent', () => {
  let component: InvoicesListPageComponent;
  let fixture: ComponentFixture<InvoicesListPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InvoicesListPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InvoicesListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
