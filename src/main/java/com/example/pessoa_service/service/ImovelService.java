package com.example.pessoa_service.service;

import com.example.pessoa_service.dto.ImovelRequestDTO;
import com.example.pessoa_service.dto.ImovelResponseDTO;
import com.example.pessoa_service.entity.Imovel;
import com.example.pessoa_service.mapper.ImovelMapper;
import com.example.pessoa_service.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public ImovelResponseDTO criarImovel(ImovelRequestDTO dto) {
        Imovel imovel = ImovelMapper.toEntity(dto);
        Imovel salvo = imovelRepository.save(imovel);
        return ImovelMapper.toDTO(salvo);
    }

    public List<ImovelResponseDTO> listarTodos() {
        return imovelRepository.findAll()
                .stream()
                .map(ImovelMapper::toDTO)
                .collect(Collectors.toList());
    }
}
