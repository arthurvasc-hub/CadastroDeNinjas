package dev.java10x.CadastroDeNinjas;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Annotation RestController, significa que estamos lidando com um controlador REST.
* Annotation RequestMapping, significa que iremos mapear as rotas fornecidas nessa classe.
* */
@RestController
@RequestMapping
public class Controller {

    //GetMapping retorna um valor fornecido na função
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
