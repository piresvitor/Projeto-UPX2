package com.projeto.UPX2.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.UPX2.Model.Materiais;
import com.projeto.UPX2.Repository.MateriaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MateriaisService {

    @Autowired
    private MateriaisRepository materiaisRepository;

    public void lerEGravarMateriais(String caminhoArquivoJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Lê o arquivo JSON e converte para uma lista de objetos Materiais
            List<Materiais> materiais = objectMapper.readValue(new File(caminhoArquivoJson), new TypeReference<List<Materiais>>() {});

            // Salva todos os objetos Materiais no banco de dados
            materiaisRepository.saveAll(materiais);

            System.out.println("Materiais salvos com sucesso no banco de dados.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }
}