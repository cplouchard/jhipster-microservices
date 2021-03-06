import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class EncryptionService {
  constructor(private http: HttpClient) {}

  encrypt(textToEncrypt: string): Observable<string> {
    return this.http.post<string>('config/encrypt', textToEncrypt).pipe(map((response: string) => '{cipher}' + response));
  }

  decrypt(textToDecrypt: string): Observable<string> {
    return this.http.post<string>('config/decrypt', textToDecrypt);
  }
}
