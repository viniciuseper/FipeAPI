package com.example.RestAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fipe")
public class MarcaEntity {

    @Id
    private String id;

    private String codigo;

    private String nome;

    public MarcaEntity(String id, String codigo, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }

    public MarcaEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
