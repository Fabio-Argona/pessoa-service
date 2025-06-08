package com.example.pessoa_service.service;

import com.example.pessoa_service.dto.ProprietarioRequestDTO;
import com.example.pessoa_service.dto.ProprietarioResponseDTO;
import com.example.pessoa_service.entity.Imovel;
import com.example.pessoa_service.entity.Proprietario;
import com.example.pessoa_service.mapper.ProprietarioMapper;
import com.example.pessoa_service.repository.ImovelRepository;
import com.example.pessoa_service.repository.ProprietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;
    private final ImovelRepository imovelRepository;

    public ProprietarioService(ProprietarioRepository proprietarioRepository, ImovelRepository imovelRepository) {
        this.proprietarioRepository = proprietarioRepository;
        this.imovelRepository = imovelRepository;
    }

    public ProprietarioResponseDTO criarProprietario(ProprietarioRequestDTO dto) {
        Proprietario p = new Proprietario();
        p.setNome(dto.getNome());
        p.setCpf(dto.getCpf());
        p.setTelefone(dto.getTelefone());
        p.setEmail(dto.getEmail());

        if (dto.getIdsImoveis() != null) {
            List<Imovel> imoveis = imovelRepository.findAllById(dto.getIdsImoveis());
            p.setImoveis(imoveis);
        }

        Proprietario salvo = proprietarioRepository.save(p);
        return ProprietarioMapper.toDTO(salvo);
    }

    public List<ProprietarioResponseDTO> listarTodos() {
        return proprietarioRepository.findAll()
                .stream()
                .map(ProprietarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
