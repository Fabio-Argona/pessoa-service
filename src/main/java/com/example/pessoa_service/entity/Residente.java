package com.example.pessoa_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "residentes")
public class Residente extends Pessoa {

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;

    public Residente() {
    }

    public Residente(String nome, String cpf, String telefone, String email) {
        super(nome, cpf, telefone, email);
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
}
