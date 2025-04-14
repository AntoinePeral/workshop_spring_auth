import { Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RegisterPageComponent } from './pages/auth/register-page/register-page.component';
import { LoginPageComponent } from './pages/auth/login-page/login-page.component';
import { InvoicesListPageComponent } from './pages/invoices/invoices-list-page/invoices-list-page.component';
import { CreateInvoicePageComponent } from './pages/invoices/create-invoice-page/create-invoice-page.component';
import { AdminDashboardPageComponent } from './pages/admin/admin-dashboard-page/admin-dashboard-page.component';

export const routes: Routes = [
  {
    path: "",
    component: HomePageComponent
  },
  {
    path: "register",
    component: RegisterPageComponent
  },
  {
    path: "login",
    component: LoginPageComponent
  },
  {
    path: "invoices/create",
    component: CreateInvoicePageComponent
  },
  {
    path: "invoices",
    component: InvoicesListPageComponent
  },
  {
    path: "admin",
    component: AdminDashboardPageComponent
  },
];
