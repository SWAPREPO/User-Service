package com.sst.project.exception;

import java.time.LocalDateTime;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice
public class GlobalExceptionHandler //extends ResponseEntityExceptionHandler 
{

	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex, WebRequest request, Model model) throws Exception {
		
		model.addAttribute("errorMessage", ex.getMessage());
        model.addAttribute("errorDetails", "uri=" + request.getDescription(false));
        model.addAttribute("localDateTime", LocalDateTime.now());
        
        System.out.println(model.toString());
		
		return "error2";
	}
	
}
