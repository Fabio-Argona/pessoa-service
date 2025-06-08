package com.example.pessoa_service.mapper;

import com.example.pessoa_service.dto.ResidenteResponseDTO;
import com.example.pessoa_service.entity.Residente;

public class ResidenteMapper {

    public static ResidenteResponseDTO toDTO(Residente residente) {
        ResidenteResponseDTO dto = new ResidenteResponseDTO();
        dto.setId(residente.getId());
        dto.setNome(residente.getNome());
        dto.setCpf(residente.getCpf());
        dto.setTelefone(residente.getTelefone());
        dto.setEmail(residente.getEmail());

        if (residente.getImovel() != null) {
            dto.setImovel(ImovelMapper.toDTO(residente.getImovel()));
        }

        return dto;
    }
}
