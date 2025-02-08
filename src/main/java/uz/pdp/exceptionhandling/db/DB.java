package uz.pdp.exceptionhandling.db;

import uz.pdp.exceptionhandling.entity.Book;

import java.util.List;

public class DB {
    public static List<Book> BOOKS = List.of(
            new Book(1, "Clean Code", "Robert C. Martin"),
            new Book(2, "Effective Java", "Joshua Bloch")
    );
}
