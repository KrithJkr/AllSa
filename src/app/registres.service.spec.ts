import { TestBed, inject } from '@angular/core/testing';

import { RegistresService } from './registres.service';

describe('RegistresService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RegistresService]
    });
  });

  it('should be created', inject([RegistresService], (service: RegistresService) => {
    expect(service).toBeTruthy();
  }));
});
