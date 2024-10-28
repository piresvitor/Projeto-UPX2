package com.projeto.UPX2.Controler;

import com.projeto.UPX2.Service.MateriaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class PessoaControler {

     @GetMapping("/cliente")
    public String ClienteTest(){
        return "Test";
    }


}
