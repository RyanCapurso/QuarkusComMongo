package com.example.costumes;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Costume extends PanacheMongoEntity {
    private String name;
    private String cpf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String telefone;

    public Costume(){

    }
    public Costume(String name, String cpf, String telefone){
        this.name = name;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
