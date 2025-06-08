package com.example.pessoa_service.service;

import com.example.pessoa_service.dto.ImovelResponseDTO;
import com.example.pessoa_service.dto.ResidenteRequestDTO;
import com.example.pessoa_service.dto.ResidenteResponseDTO;
import com.example.pessoa_service.entity.Imovel;
import com.example.pessoa_service.entity.Residente;
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
        Residente residente = new Residente();
        residente.setNome(dto.getNome());
        residente.setCpf(dto.getCpf());
        residente.setTelefone(dto.getTelefone());
        residente.setEmail(dto.getEmail());

        if (dto.getImovelId() != null) {
            Optional<Imovel> imovel = imovelRepository.findById(dto.getImovelId());
            imovel.ifPresent(residente::setImovel);
        }

        residente = residenteRepository.save(residente);
        return toResponseDTO(residente);
    }

    public ResidenteResponseDTO buscarPorId(Long id) {
        Optional<Residente> residenteOpt = residenteRepository.findById(id);
        return residenteOpt.map(this::toResponseDTO).orElse(null);
    }

    public List<ResidenteResponseDTO> listarTodos() {
        return residenteRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ResidenteResponseDTO atualizar(Long id, ResidenteRequestDTO dto) {
        Optional<Residente> opt = residenteRepository.findById(id);
        if (opt.isEmpty()) return null;

        Residente residente = opt.get();
        residente.setNome(dto.getNome());
        residente.setCpf(dto.getCpf());
        residente.setTelefone(dto.getTelefone());
        residente.setEmail(dto.getEmail());

        if (dto.getImovelId() != null) {
            Optional<Imovel> imovel = imovelRepository.findById(dto.getImovelId());
            imovel.ifPresent(residente::setImovel);
        } else {
            residente.setImovel(null);
        }

        residente = residenteRepository.save(residente);
        return toResponseDTO(residente);
    }

    public boolean deletar(Long id) {
        if (!residenteRepository.existsById(id)) return false;
        residenteRepository.deleteById(id);
        return true;
    }

    private ResidenteResponseDTO toResponseDTO(Residente residente) {
        ResidenteResponseDTO dto = new ResidenteResponseDTO();
        dto.setId(residente.getId());
        dto.setNome(residente.getNome());
        dto.setCpf(residente.getCpf());
        dto.setTelefone(residente.getTelefone());
        dto.setEmail(residente.getEmail());

        if (residente.getImovel() != null) {
            ImovelResponseDTO imovelDTO = new ImovelResponseDTO();
            imovelDTO.setId(residente.getImovel().getId());
            imovelDTO.setNumeroUnidade(residente.getImovel().getNumeroUnidade());
            imovelDTO.setBloco(residente.getImovel().getBloco());
            imovelDTO.setTipo(residente.getImovel().getTipo());
            imovelDTO.setStatus(residente.getImovel().getStatus());
            dto.setImovel(imovelDTO);
        }

        return dto;
    }
}
