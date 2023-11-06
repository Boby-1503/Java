package com.example.Library.Library.Controller;

import com.example.Library.Library.Entity.Book;
import com.example.Library.Library.Service.BookService;
import org.aspectj.lang.annotation.DeclareWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{
    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Book getBookById(@PathVariable Integer id)
    {
        return bookService.findBookbyId(id);
    }

    @RequestMapping(method = RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
    }

    @RequestMapping(method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@RequestBody Book book)
    {
        bookService.updateBook(book);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public void deleteBook(@PathVariable Integer id)
    {
        bookService.deleteBookById(id);
    }

}
