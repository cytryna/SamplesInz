package s10338.service;


import s10338.domain.Book;

public interface BookService {

    public int addBook(Book book);

    public Book getBookById(int bookId);

    public void updateBook(Book book);

    public void removeBook(int bookId);

}