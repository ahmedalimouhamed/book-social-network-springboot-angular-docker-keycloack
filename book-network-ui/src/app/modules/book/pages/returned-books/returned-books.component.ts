import { Component, OnInit } from '@angular/core';
import { BorrowedBookResponse, PageResponseBorrowedBookResponse } from 'src/app/services/models';
import { BookService } from 'src/app/services/services';

@Component({
  selector: 'app-returned-books',
  templateUrl: './returned-books.component.html',
  styleUrls: ['./returned-books.component.scss']
})
export class ReturnedBooksComponent implements OnInit {
  returnedBooks: PageResponseBorrowedBookResponse = {};
  page: number = 0;
  size: number = 5;
  message: string = '';
  level: string = 'success';

  constructor(
    private bookService: BookService,
  ){}
  
  ngOnInit(): void {
    this.findAllReturnedBooks();
  }

  private findAllReturnedBooks(){
    this.bookService.findAllreturnedBooks({
      page: this.page,
      size: this.size
    }).subscribe({
      next: (resp) => {
        this.returnedBooks = resp;
      }
    })
  }

  goToFirstPage(){
    this.page = 0;
    this.findAllReturnedBooks();
  }

  goToPriviousPage(){
    this.page--;
    this.findAllReturnedBooks();
  }

  goToPage(page: number){
    this.page = page;
    this.findAllReturnedBooks();
  }

  goToNextPage(){
    this.page++;
    this.findAllReturnedBooks();
  }

  goLastPage(){
    this.page = this.returnedBooks.totalPages as number - 1;
    this.findAllReturnedBooks();
  }

  get isLastPage(): boolean{
    return this.page == this.returnedBooks.totalPages as number - 1
  }

  approveBookReturn(book: BorrowedBookResponse){
    if(!book.returned){
      this.level = 'error';
      this.message = 'The book is not yet returned';
      return;
    }

    this.bookService.approveReturnBorrowBook({
      'book-id': book.id as number
    }).subscribe({
      next: () => {
        this.level = 'success';
        this.message = 'Book return approved';
        this.findAllReturnedBooks();
      }
    })
  }
}
