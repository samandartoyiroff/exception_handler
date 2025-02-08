package uz.pdp.exceptionhandling.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = "uz.pdp.exceptionhandling")
public class GlobalExceptionHandler {

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
