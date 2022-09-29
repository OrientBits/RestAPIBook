package com.restapibook.bookServices;

import com.restapibook.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
    static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(123,"Complete Java Course","XYZ"));
        list.add(new Book(124,"Complete Python Course","PQR"));
        list.add(new Book(125,"Complete C++ Course","ABC"));
        list.add(new Book(126,"Complete Dart Course","LMN"));
    }

    public List<Book> getAllBooks(){
        return list;
    }

    public Book getBookById(int id){
        Book book1 = list.stream().filter(book -> book.getId()==id).findFirst().get();

        return book1;
    }

    public Book addBook(Book book){
        list.add(book);
        return book;
    }

    public Book deleteBook(int id){
        Book book = list.stream().filter(b -> b.getId() == id).findFirst().get();
        list.remove(book);
        System.out.println("successfully deleted");
        return book;
    }


}
