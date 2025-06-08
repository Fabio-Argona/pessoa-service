package com.example.pessoa_service.dto;

import java.util.List;

public class ProprietarioResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private List<ImovelResponseDTO> imoveis;

    public ProprietarioResponseDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<ImovelResponseDTO> getImoveis() { return imoveis; }
    public void setImoveis(List<ImovelResponseDTO> imoveis) { this.imoveis = imoveis; }
}
