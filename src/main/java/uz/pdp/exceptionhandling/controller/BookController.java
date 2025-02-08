package uz.pdp.exceptionhandling.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.exceptionhandling.db.DB;
import uz.pdp.exceptionhandling.entity.Book;
import uz.pdp.exceptionhandling.exception.NotFoundException;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping
    public String book(Model model) {
        model.addAttribute("books", DB.BOOKS);
        System.out.println(DB.BOOKS);
        return "book";
    }

    @GetMapping("/info/{id}")
    public String bookInfo(@PathVariable Integer id, Model model) {
        Book book = DB.BOOKS
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("Book not found","/book"));
        model.addAttribute("book", book);
        return "info";
    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException(HttpServletRequest request, NotFoundException ex) {
        String requestURI = request.getRequestURI();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.addObject("url", requestURI);
        modelAndView.addObject("back", ex.getBackPath());
        return modelAndView;
    }

}
