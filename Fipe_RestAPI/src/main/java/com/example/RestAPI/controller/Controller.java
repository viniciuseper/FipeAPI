package com.example.RestAPI.controller;

import com.example.RestAPI.model.MarcaEntity;
import com.example.RestAPI.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tabelaFibe")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/marcas")
    public String consultarMarcas(){
        return service.consultarMarcas();
    }
    @GetMapping("/modelos/{marca}")
    public String consultarModelos(@PathVariable int marca){
        return service.consultarModelos(marca);
    }
    @GetMapping("/anos/{marca}/{modelo}")
    public String consultarAnos(@PathVariable int marca, @PathVariable int modelo){
        return service.consultarAnos(marca, modelo);
    }
    @GetMapping("/valor/{marca}/{modelo}/{ano}")
    public String consultarValor(@PathVariable int marca, @PathVariable int modelo, @PathVariable String ano){
        return service.consultarValor(marca, modelo, ano);
    }

    @PostMapping("/salvar")
    public void salvarMarca(){
        service.salvarMarca();
    }

    @PutMapping("/atualizarMarca")
    public void atualizarMarca(@RequestBody MarcaEntity marca){
        service.atualizarMarca(marca);
    }

    @DeleteMapping("/deletarMarca")
    public void deletearMarca(@RequestBody MarcaEntity marca){
        service.deletarMarca(marca);
    }


}

