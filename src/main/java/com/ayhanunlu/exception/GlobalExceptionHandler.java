package com.ayhanunlu.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handleUserAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("errorMessage",userAlreadyExistsException.getMessage());
        return "redirect:/register";
    }
}
