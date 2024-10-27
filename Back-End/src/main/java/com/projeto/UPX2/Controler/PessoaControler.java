package com.projeto.UPX2.Controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaControler {

    @GetMapping("/cliente")
    public String ClienteTest(){
        return "Test";
    }
}
