package com.example.pessoa_service.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "imoveis")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroUnidade;
    private String bloco;
    private String tipo; // exemplo: "Alugado" ou "Próprio"
    private String status; // exemplo: "Ativo", "Inativo"

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Residente> residentes = new ArrayList<>();

    public Imovel() {
    }

    public Imovel(String numeroUnidade, String bloco, String tipo, String status) {
        this.numeroUnidade = numeroUnidade;
        this.bloco = bloco;
        this.tipo = tipo;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNumeroUnidade() {
        return numeroUnidade;
    }

    public void setNumeroUnidade(String numeroUnidade) {
        this.numeroUnidade = numeroUnidade;
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

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public List<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residente> residentes) {
        this.residentes = residentes;
    }

    public void adicionarResidente(Residente residente) {
        residentes.add(residente);
        residente.setImovel(this);
    }

    public void removerResidente(Residente residente) {
        residentes.remove(residente);
        residente.setImovel(null);
    }
}
