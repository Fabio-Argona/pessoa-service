package com.example.pessoa_service.dto;

public class ResidenteResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private ImovelResponseDTO imovel;

    public ResidenteResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ImovelResponseDTO getImovel() {
        return imovel;
    }

    public void setImovel(ImovelResponseDTO imovel) {
        this.imovel = imovel;
    }
}
