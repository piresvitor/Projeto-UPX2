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

    @Autowired
    private MateriaisService materiaisService;

    @GetMapping("/cliente")
    public String ClienteTest(){
        return "Test";
    }

    //Utilizado uma unica vez para gravar o arquivo json de materias no Banco de Dados
    @PostMapping("/gravar-materiais")
    public ResponseEntity<String> carregarMateriais(@RequestParam("file") MultipartFile file) {
        try {
            // Salva o arquivo temporariamente para leitura
            File tempFile = File.createTempFile("materiais", ".json");
            file.transferTo(tempFile);

            // Chama o método do serviço para ler e salvar os materiais
            materiaisService.lerEGravarMateriais(tempFile.getAbsolutePath());

            // Deleta o arquivo temporário após o uso
            tempFile.delete();

            return ResponseEntity.ok("Materiais salvos com sucesso no banco de dados.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erro ao processar o arquivo JSON: " + e.getMessage());
        }
    }
}
