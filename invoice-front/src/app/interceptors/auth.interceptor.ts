import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../shared/services/auth.service';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  // Supprime le token s’il est invalide ou expiré
  authService.verifyToken();
  const token = authService.getToken();

  if (token) {
    const authReq = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`,
      },
    });
    return next(authReq);
  }

  return next(req);

  // let authReq = req;

  // if(req.url.startsWith('http://localhost:8080')){
  //   const token = authService.getToken();
  //   if (token) {
  //     authReq = req.clone({
  //       setHeaders: {
  //         Authorization: `Bearer ${token}`,
  //       },
  //     });
  //   }
  // }

  // return next(authReq).pipe(
  //   catchError(error => {
  //     if(error.status === 401 || error.status === 403){
  //       router.navigate(['/login']);
  //     }
  //     return throwError(()=> error)
  //   })
  // )
};
