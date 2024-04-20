package com.example.RestAPI.service;
import com.example.RestAPI.model.MarcaEntity;
import com.example.RestAPI.model.vo.MarcaVO;
import com.example.RestAPI.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Service
public class Service {

    private final MarcaRepository marcaRepository;

    @Autowired
    public Service(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    private String consultarURL(String apiUrl){
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        return dados;
    }
    public String consultarMarcas() {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas");
    }
    public String consultarModelos(int id) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+id+"/modelos");
    }
    public String consultarAnos(int marca, int modelo) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos");
    }
    public String consultarValor(int marca, int modelo, String ano) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos/"+ano);
    }

    public List<MarcaEntity> obterMarcas(){
        String apiUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

        RestTemplate restTemplate = new RestTemplate();

        MarcaVO[] response = restTemplate.getForObject(apiUrl, MarcaVO[].class);

        return Objects.nonNull(response) ? particionarDados(response) : null;
    }

    public List<MarcaEntity> particionarDados(MarcaVO[] array){
        List<MarcaEntity> marcas = new ArrayList<>();
        Arrays.stream(array).forEach( item -> {
            MarcaEntity marca = new MarcaEntity();
            marca.setCodigo(item.getCodigo());
            marca.setNome(item.getNome());
            marcas.add(marca);
        });

        return marcas;
    }

    public void salvarMarca(){
        marcaRepository.saveAll(obterMarcas());
    }

    public void atualizarMarca(MarcaEntity marca){
        marcaRepository.save(marca);
    }

    public void deletarMarca(MarcaEntity marca){
        marcaRepository.delete(marca);
    }

}
