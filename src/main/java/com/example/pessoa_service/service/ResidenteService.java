package com.example.pessoa_service.service;

import com.example.pessoa_service.dto.ResidenteRequestDTO;
import com.example.pessoa_service.dto.ResidenteResponseDTO;
import com.example.pessoa_service.entity.Imovel;
import com.example.pessoa_service.entity.Residente;
import com.example.pessoa_service.mapper.ResidenteMapper;
import com.example.pessoa_service.repository.ImovelRepository;
import com.example.pessoa_service.repository.ResidenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResidenteService {

    private final ResidenteRepository residenteRepository;
    private final ImovelRepository imovelRepository;

    public ResidenteService(ResidenteRepository residenteRepository, ImovelRepository imovelRepository) {
        this.residenteRepository = residenteRepository;
        this.imovelRepository = imovelRepository;
    }

    public ResidenteResponseDTO criarResidente(ResidenteRequestDTO dto) {
        Residente r = new Residente();
        r.setNome(dto.getNome());
        r.setCpf(dto.getCpf());
        r.setTelefone(dto.getTelefone());
        r.setEmail(dto.getEmail());

        if (dto.getImovelId() != null) {
            Optional<Imovel> imovel = imovelRepository.findById(dto.getImovelId());
            imovel.ifPresent(r::setImovel);
        }

        Residente salvo = residenteRepository.save(r);
        return ResidenteMapper.toDTO(salvo);
    }

    public List<ResidenteResponseDTO> listarTodos() {
        return residenteRepository.findAll()
                .stream()
                .map(ResidenteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
