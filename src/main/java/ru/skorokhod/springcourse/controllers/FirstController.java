package ru.skorokhod.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a,
                             @RequestParam(value = "b") double b,
                             @RequestParam(value = "action") String action,
                             Model model){
        double result;

        switch (action){
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "-":
                result = a - b;
                break;
            case "+":
                result = a + b;
                break;
            default: result = 0;
        }

        model.addAttribute("result", result);

        return "first/calculator";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        model.addAttribute("message", name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
