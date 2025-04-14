import { Component, inject } from '@angular/core';
import { User } from '../../../shared/models/user.model';
import { Invoice } from '../../../shared/models/invoice.model';
import { ApiService } from '../../../shared/services/api.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-dashboard-page',
  imports: [CommonModule],
  templateUrl: './admin-dashboard-page.component.html',
  styleUrl: './admin-dashboard-page.component.css'
})
export class AdminDashboardPageComponent {
  private apiService = inject(ApiService);

  users: User[] = [];
  invoices: Invoice[] = [];

  ngOnInit(): void {
    this.apiService.getAllUsers().subscribe({
      next: (data) => (this.users = data),
      error: (err) => console.error('Erreur lors de la récupération des utilisateurs :', err),
    });

    this.apiService.getAllInvoices().subscribe({
      next: (data) => (this.invoices = data),
      error: (err) => console.error('Erreur lors de la récupération des factures :', err),
    });
  }
}
