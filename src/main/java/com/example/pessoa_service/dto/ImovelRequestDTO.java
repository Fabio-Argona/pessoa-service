package com.example.pessoa_service.dto;

import java.util.List;

public class ImovelRequestDTO {
    private String numero;
    private String bloco;
    private String tipo;
    private String status;
    private Long proprietarioId;
    private List<Long> residenteIds;


    public ImovelRequestDTO() {}

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Long proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public List<Long> getResidenteIds() {
        return residenteIds;
    }

    public void setResidenteIds(List<Long> residenteIds) {
        this.residenteIds = residenteIds;
    }
}
