package com.example.Library.Library.Service;

import com.example.Library.Library.Dao.BookRepo;
import com.example.Library.Library.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService
{
    @Autowired
    private BookRepo bookRepo;
    public List<Book> getAllBooks()
    {
        return bookRepo.findAll();
    }

    public Book findBookbyId(int id)
    {
        return bookRepo.findById(id).orElse(null);
    }

    public void addBook(Book book)
    {
        bookRepo.save(book);
    }

    public void updateBook(Book book)
    {
        bookRepo.save(book);
    }

    public void deleteBookById(int id)
    {
        bookRepo.deleteById(id);
    }


}
