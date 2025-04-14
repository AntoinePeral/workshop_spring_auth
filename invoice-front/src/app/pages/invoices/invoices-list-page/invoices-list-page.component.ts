import { Component, inject } from '@angular/core';
import { ApiService } from '../../../shared/services/api.service';
import { Invoice } from '../../../shared/models/invoice.model';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-invoices-list-page',
  imports: [CommonModule, RouterLink],
  templateUrl: './invoices-list-page.component.html',
  styleUrl: './invoices-list-page.component.css'
})
export class InvoicesListPageComponent {

  invoices: Invoice[] = [];
  isLoading = true;

  private apiService = inject(ApiService);

  ngOnInit(): void {
    this.apiService.getUserInvoices().subscribe({
      next: (data) => {
        this.invoices = data;
        this.isLoading = false;
      },
      error: () => {
        this.invoices = [];
        this.isLoading = false;
      }
    });
  }
}
