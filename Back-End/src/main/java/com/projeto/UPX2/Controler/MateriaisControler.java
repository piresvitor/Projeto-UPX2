package com.projeto.UPX2.Controler;

import com.projeto.UPX2.Model.Materiais;
import com.projeto.UPX2.Repository.MateriaisRepository;
import com.projeto.UPX2.Service.MateriaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/materiais")
public class MateriaisControler {

    @Autowired
    private MateriaisRepository materiaisRepository;

    @Autowired
    private MateriaisService materiaisService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Materiais>> buscarMateriaisReciclaveis(@RequestParam("texto") String texto) {
        List<Materiais> materiais = materiaisRepository.findByObjetoContainingIgnoreCase(texto);

        if (materiais.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se não houver materiais
        }

        return ResponseEntity.ok(materiais); // Retorna a lista completa de objetos Materiais
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
