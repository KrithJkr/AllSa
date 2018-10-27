import { TestBed, inject } from '@angular/core/testing';

import { RestaService } from './resta.service';

describe('RestaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RestaService]
    });
  });

  it('should be created', inject([RestaService], (service: RestaService) => {
    expect(service).toBeTruthy();
  }));
});
