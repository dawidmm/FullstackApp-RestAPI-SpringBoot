package pl.web.instalook.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorsController implements ErrorController {

    @RequestMapping("/error")
    public String errorIndex(HttpServletRequest request){

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        switch (statusCode){
            case 404:
                return "page404";
            case 500:
                return "page500";
            default:
                return "error";
        }

    }
}
