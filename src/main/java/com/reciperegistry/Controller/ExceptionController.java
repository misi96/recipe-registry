package com.reciperegistry.Controller;

import org.apache.maven.model.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class ExceptionController {
    /**
     * This is the exception handler of project.
     *
     * @param sr    the http servlet request
     * @param ex    the exception
     * @param model the model
     * @return the exceptionHandler as string
     */
    @ExceptionHandler(Exception.class)
    public String
    exceptionHandler(HttpServletRequest sr, Exception ex, Model model) {
        model.addProperty("errMessage", ex.getMessage());
        return "exceptionHandler";
    }
}
