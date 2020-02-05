import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleThumbnailComponent } from './article-thumbnail.component';

describe('ArticleThumbnailComponent', () => {
  let component: ArticleThumbnailComponent;
  let fixture: ComponentFixture<ArticleThumbnailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticleThumbnailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleThumbnailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
