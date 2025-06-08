package com.example.pessoa_service.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proprietarios")
public class Proprietario extends Pessoa {

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imovel> imoveis = new ArrayList<>();

    public Proprietario() {
    }

    public Proprietario(String nome, String cpf, String telefone, String email) {
        super(nome, cpf, telefone, email);
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
        imovel.setProprietario(this);
    }

    public void removerImovel(Imovel imovel) {
        imoveis.remove(imovel);
        imovel.setProprietario(null);
    }
}
