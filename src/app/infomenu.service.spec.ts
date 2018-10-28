import { TestBed, inject } from '@angular/core/testing';

import { InfomenuService } from './infomenu.service';

describe('InfomenuService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InfomenuService]
    });
  });

  it('should be created', inject([InfomenuService], (service: InfomenuService) => {
    expect(service).toBeTruthy();
  }));
});
