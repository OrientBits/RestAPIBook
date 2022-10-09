package com.restapibook.bookServices;

import com.restapibook.entities.Book;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Book book1 = null;
        try {
            book1= list.stream().filter(book -> book.getId()==id).findFirst().get();
        }catch (Exception e){
            System.out.println(e);
        }
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
    public void deleteBook2(int id){
        list = list.stream().filter(book -> book.getId()!=id).collect(Collectors.toList());
        System.out.println(list);
    }

    //update the book
    public List<Book> updateBook(Book book, int id) {

        list = list.stream().map(b ->{
            if (b.getId() == id){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());

            }
            return b;
        }).collect(Collectors.toList());

        System.out.println("Successfully updated");
        return list;

    }



}