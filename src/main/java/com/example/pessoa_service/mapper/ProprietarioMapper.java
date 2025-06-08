package com.example.pessoa_service.mapper;

import com.example.pessoa_service.dto.ImovelResponseDTO;
import com.example.pessoa_service.dto.ProprietarioResponseDTO;
import com.example.pessoa_service.entity.Imovel;
import com.example.pessoa_service.entity.Proprietario;

import java.util.List;
import java.util.stream.Collectors;

public class ProprietarioMapper {

    public static ProprietarioResponseDTO toDTO(Proprietario proprietario) {
        ProprietarioResponseDTO dto = new ProprietarioResponseDTO();
        dto.setId(proprietario.getId());
        dto.setNome(proprietario.getNome());
        dto.setCpf(proprietario.getCpf());
        dto.setTelefone(proprietario.getTelefone());
        dto.setEmail(proprietario.getEmail());

        List<ImovelResponseDTO> imoveisDTO = proprietario.getImoveis().stream()
                .map(ImovelMapper::toDTO)
                .collect(Collectors.toList());

        dto.setImoveis(imoveisDTO);
        return dto;
    }
}
