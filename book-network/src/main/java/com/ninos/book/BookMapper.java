package com.ninos.book;

import org.springframework.stereotype.Service;

import com.ninos.history.BookTransactionHistory;

@Service
public class BookMapper {

    public Book toBook(BookRequest request) {
      return Book.builder()
              .id(request.id())
              .title(request.title())
              .authorName(request.authorName())
              .synopsis(request.synopsis())
              .archive(false)
              .shareable(request.shareable())
              .build();
    }

    public BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .rate(book.getRate())
                .archived(book.isArchive())
                .shareable(book.isShareable())
                .owner(book.getOwner().fullName())
                // todo implementation later
//                .cover()
                .build();
    }

    public BorrowedBookResponse toBorrowedBookResponse(BookTransactionHistory history) {
        return BorrowedBookResponse.builder()
                .id(history.getBook().getId())
                .title(history.getBook().getTitle())
                .authorName(history.getBook().getAuthorName())
                .isbn(history.getBook().getIsbn())
                .rate(history.getBook().getRate())
                .returned(history.isReturned())
                .returnApproved(history.isReturnApproved())
                .build();
    }
}
