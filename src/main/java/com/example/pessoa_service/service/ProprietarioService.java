package com.example.pessoa_service.service;

import com.example.pessoa_service.dto.ImovelResponseDTO;
import com.example.pessoa_service.dto.ProprietarioRequestDTO;
import com.example.pessoa_service.dto.ProprietarioResponseDTO;
import com.example.pessoa_service.entity.Imovel;
import com.example.pessoa_service.entity.Proprietario;
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

    public ProprietarioResponseDTO criar(ProprietarioRequestDTO dto) {
        Proprietario proprietario = new Proprietario();
        proprietario.setNome(dto.getNome());
        proprietario.setCpf(dto.getCpf());
        proprietario.setTelefone(dto.getTelefone());
        proprietario.setEmail(dto.getEmail());

        if (dto.getImovelIds() != null) {
            List<Imovel> imoveis = imovelRepository.findAllById(dto.getImovelIds());
            proprietario.setImoveis(imoveis);
        }

        proprietario = proprietarioRepository.save(proprietario);
        return toResponseDTO(proprietario);
    }

    public ProprietarioResponseDTO buscarPorId(Long id) {
        Optional<Proprietario> proprietarioOpt = proprietarioRepository.findById(id);
        return proprietarioOpt.map(this::toResponseDTO).orElse(null);
    }

    public List<ProprietarioResponseDTO> listarTodos() {
        return proprietarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ProprietarioResponseDTO atualizar(Long id, ProprietarioRequestDTO dto) {
        Optional<Proprietario> opt = proprietarioRepository.findById(id);
        if (opt.isEmpty()) return null;

        Proprietario proprietario = opt.get();
        proprietario.setNome(dto.getNome());
        proprietario.setCpf(dto.getCpf());
        proprietario.setTelefone(dto.getTelefone());
        proprietario.setEmail(dto.getEmail());

        if (dto.getImovelIds() != null) {
            List<Imovel> imoveis = imovelRepository.findAllById(dto.getImovelIds());
            proprietario.setImoveis(imoveis);
        }

        proprietario = proprietarioRepository.save(proprietario);
        return toResponseDTO(proprietario);
    }

    public boolean deletar(Long id) {
        if (!proprietarioRepository.existsById(id)) return false;
        proprietarioRepository.deleteById(id);
        return true;
    }

    private ProprietarioResponseDTO toResponseDTO(Proprietario proprietario) {
        ProprietarioResponseDTO dto = new ProprietarioResponseDTO();
        dto.setId(proprietario.getId());
        dto.setNome(proprietario.getNome());
        dto.setCpf(proprietario.getCpf());
        dto.setTelefone(proprietario.getTelefone());
        dto.setEmail(proprietario.getEmail());

        if (proprietario.getImoveis() != null) {
            List<ImovelResponseDTO> imoveisDTO = proprietario.getImoveis().stream()
                    .map(this::toImovelResponseDTO)
                    .collect(Collectors.toList());
            dto.setImoveis(imoveisDTO);
        }

        return dto;
    }

    private ImovelResponseDTO toImovelResponseDTO(Imovel imovel) {
        ImovelResponseDTO dto = new ImovelResponseDTO();
        dto.setId(imovel.getId());
        dto.setNumeroUnidade(imovel.getNumeroUnidade());
        dto.setBloco(imovel.getBloco());
        dto.setTipo(imovel.getTipo());
        dto.setStatus(imovel.getStatus());
        return dto;
    }
}