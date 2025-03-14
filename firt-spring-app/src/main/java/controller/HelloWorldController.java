package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // rest controller combina as anotações abaixo para ser feita a resposta
//@Controller -> contoller não precisa retornar resposta direta
//@ResponseBody
@RequestMapping("/hello-world") // Esculta todas as requisições que chegarem ao endpoint "hello-world"
public class HelloWorldController {
    @GetMapping
    public String helloWorld(){
        return "hello-wrdl";
    }
}
