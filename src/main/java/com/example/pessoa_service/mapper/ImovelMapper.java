package com.example.pessoa_service.mapper;

import com.example.pessoa_service.dto.ImovelRequestDTO;
import com.example.pessoa_service.dto.ImovelResponseDTO;
import com.example.pessoa_service.entity.Imovel;

public class ImovelMapper {

    public static Imovel toEntity(ImovelRequestDTO dto) {
        Imovel imovel = new Imovel();
        imovel.setNumero(dto.getNumero());
        imovel.setBloco(dto.getBloco());
        imovel.setTipo(dto.getTipo());
        imovel.setStatus(dto.getStatus());
        return imovel;
    }

    public static ImovelResponseDTO toDTO(Imovel imovel) {
        ImovelResponseDTO dto = new ImovelResponseDTO();
        dto.setId(imovel.getId());
        dto.setNumero(imovel.getNumero());
        dto.setBloco(imovel.getBloco());
        dto.setTipo(imovel.getTipo());
        dto.setStatus(imovel.getStatus());
        return dto;
    }
}
