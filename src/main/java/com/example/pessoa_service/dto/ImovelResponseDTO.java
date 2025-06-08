package com.example.pessoa_service.dto;

import java.util.List;

public class ImovelResponseDTO {
    private Long id;
    private String numeroUnidade;
    private String bloco;
    private String tipo;
    private String status;
    private List<Long> residenteIds;
    private Long proprietarioId;     // <--- adicionar este campo
    private String proprietarioNome;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroUnidade() { return numeroUnidade; }
    public void setNumeroUnidade(String numeroUnidade) { this.numeroUnidade = numeroUnidade; }

    public String getBloco() { return bloco; }
    public void setBloco(String bloco) { this.bloco = bloco; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Long> getResidenteIds() { return residenteIds; }
    public void setResidenteIds(List<Long> residenteIds) { this.residenteIds = residenteIds; }

    public Long getProprietarioId() { return proprietarioId; }
    public void setProprietarioId(Long proprietarioId) { this.proprietarioId = proprietarioId; }

    public String getProprietarioNome() { return proprietarioNome; }
    public void setProprietarioNome(String proprietarioNome) { this.proprietarioNome = proprietarioNome; }
}
