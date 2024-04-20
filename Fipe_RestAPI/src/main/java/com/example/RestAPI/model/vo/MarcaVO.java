package com.example.RestAPI.model.vo;

public class MarcaVO {

    private String codigo;

    private String nome;

    public MarcaVO(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public MarcaVO() {
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
