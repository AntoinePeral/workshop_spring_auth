import { Component, inject } from '@angular/core';
import { AuthService } from '../../../shared/services/auth.service';
import { Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  imports: [FormsModule],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {
  user = {
    email: '',
    password: '',
  };

  private authService = inject(AuthService);
  private router = inject(Router);

  onSubmit(form: NgForm) {
    if (form.valid) {
      this.authService.login(this.user.email, this.user.password).subscribe({
        next: () => this.router.navigate(['/invoices']), // ou autre redirection
        error: () => alert('Email ou mot de passe incorrect'),
      });
    }
  }
}
