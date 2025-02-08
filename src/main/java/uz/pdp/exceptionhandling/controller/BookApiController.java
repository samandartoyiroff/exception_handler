package uz.pdp.exceptionhandling.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.exceptionhandling.db.DB;
import uz.pdp.exceptionhandling.entity.Book;
import uz.pdp.exceptionhandling.exception.NotFoundException;

@RestController
@RequestMapping("/api/book")
public class BookApiController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable Integer id) {
        Book book = DB.BOOKS.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " not found", "/book"));
        return ResponseEntity.ok(book);
    }



}
