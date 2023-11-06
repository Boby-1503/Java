package com.example.Library.Library.Dao;

import com.example.Library.Library.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer>
{

}
