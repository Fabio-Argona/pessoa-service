package com.example.pessoa_service.dto;

import java.util.List;

public class ProprietarioRequestDTO {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private List<Long> imovelIds;

    public ProprietarioRequestDTO() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getImovelIds() {
        return imovelIds;
    }

    public void setImovelIds(List<Long> imovelIds) {
        this.imovelIds = imovelIds;
    }
}
