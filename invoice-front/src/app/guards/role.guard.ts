import { Any } from './../../../node_modules/@sigstore/protobuf-specs/dist/__generated__/google/protobuf/any.d';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../shared/services/auth.service';
import { inject } from '@angular/core';

export const roleGuard: (expectedRole: string) => CanActivateFn =
  (expectedRole) => () => {
    const authService = inject(AuthService);
    const router = inject(Router);

    if (
      authService.isLoggedIn() &&
      authService.getUserRoles()?.some((role: any) => role.authority  === expectedRole)
    ) {
      return true;
    } else {
      router.navigate(['/']);
      return false;
    }
  };
