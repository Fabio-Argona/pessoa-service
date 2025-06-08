package com.example.pessoa_service.service;

import com.example.pessoa_service.dto.ImovelRequestDTO;
import com.example.pessoa_service.dto.ImovelResponseDTO;
import com.example.pessoa_service.entity.Imovel;
import com.example.pessoa_service.entity.Proprietario;
import com.example.pessoa_service.entity.Residente;
import com.example.pessoa_service.repository.ImovelRepository;
import com.example.pessoa_service.repository.ProprietarioRepository;
import com.example.pessoa_service.repository.ResidenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;
    private final ProprietarioRepository proprietarioRepository;
    private final ResidenteRepository residenteRepository;

    public ImovelService(ImovelRepository imovelRepository,
                         ProprietarioRepository proprietarioRepository,
                         ResidenteRepository residenteRepository) {
        this.imovelRepository = imovelRepository;
        this.proprietarioRepository = proprietarioRepository;
        this.residenteRepository = residenteRepository;
    }

    public ImovelResponseDTO criar(ImovelRequestDTO dto) {
        Imovel imovel = new Imovel();
        imovel.setNumeroUnidade(dto.getNumero());  // aqui, chamar o getter correto
        imovel.setBloco(dto.getBloco());
        imovel.setTipo(dto.getTipo());
        imovel.setStatus(dto.getStatus());

        if (dto.getProprietarioId() != null) {
            Optional<Proprietario> proprietario = proprietarioRepository.findById(dto.getProprietarioId());
            proprietario.ifPresent(imovel::setProprietario);
        }

        if (dto.getResidenteIds() != null && !dto.getResidenteIds().isEmpty()) {
            List<Residente> residentes = residenteRepository.findAllById(dto.getResidenteIds());
            imovel.setResidentes(residentes);
        }

        imovel = imovelRepository.save(imovel);
        return toResponseDTO(imovel);
    }


    public ImovelResponseDTO buscarPorId(Long id) {
        Optional<Imovel> opt = imovelRepository.findById(id);
        return opt.map(this::toResponseDTO).orElse(null);
    }

    public List<ImovelResponseDTO> listarTodos() {
        return imovelRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ImovelResponseDTO atualizar(Long id, ImovelRequestDTO dto) {
        Optional<Imovel> opt = imovelRepository.findById(id);
        if (opt.isEmpty()) return null;

        Imovel imovel = opt.get();
        imovel.setNumeroUnidade(dto.getNumero());
        imovel.setBloco(dto.getBloco());
        imovel.setTipo(dto.getTipo());
        imovel.setStatus(dto.getStatus());

        if (dto.getProprietarioId() != null) {
            Optional<Proprietario> proprietario = proprietarioRepository.findById(dto.getProprietarioId());
            imovel.setProprietario(proprietario.orElse(null));
        } else {
            imovel.setProprietario(null);
        }

        if (dto.getResidenteIds() != null) {
            List<Residente> residentes = residenteRepository.findAllById(dto.getResidenteIds());
            imovel.setResidentes(residentes);
        } else {
            imovel.setResidentes(null);
        }

        imovel = imovelRepository.save(imovel);
        return toResponseDTO(imovel);
    }

    public boolean deletar(Long id) {
        if (!imovelRepository.existsById(id)) return false;
        imovelRepository.deleteById(id);
        return true;
    }

    private ImovelResponseDTO toResponseDTO(Imovel imovel) {
        ImovelResponseDTO dto = new ImovelResponseDTO();
        dto.setId(imovel.getId());
        dto.setNumeroUnidade(imovel.getNumeroUnidade());
        dto.setBloco(imovel.getBloco());
        dto.setTipo(imovel.getTipo());
        dto.setStatus(imovel.getStatus());

        if (imovel.getProprietario() != null) {
            dto.setProprietarioId(imovel.getProprietario().getId());
            dto.setProprietarioNome(imovel.getProprietario().getNome());
        }

        if (imovel.getResidentes() != null && !imovel.getResidentes().isEmpty()) {
            dto.setResidenteIds(
                    imovel.getResidentes()
                            .stream()
                            .map(Residente::getId)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
