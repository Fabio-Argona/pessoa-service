package com.example.pessoa_service.controler;

import com.example.pessoa_service.dto.ProprietarioRequestDTO;
import com.example.pessoa_service.dto.ProprietarioResponseDTO;
import com.example.pessoa_service.service.ProprietarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proprietarios")
@Tag(name = "Proprietários", description = "Gerenciamento de proprietários")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;
    }

    @Operation(summary = "Criar proprietário", description = "Cria um novo proprietário com seus imóveis vinculados.")
    @PostMapping
    public ResponseEntity<ProprietarioResponseDTO> criarProprietario(@RequestBody ProprietarioRequestDTO request) {
        return ResponseEntity.ok(proprietarioService.criar(request));
    }

    @Operation(summary = "Listar todos os proprietários")
    @GetMapping
    public ResponseEntity<List<ProprietarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(proprietarioService.listarTodos());
    }

    @Operation(summary = "Buscar proprietário por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProprietarioResponseDTO> buscarPorId(
            @Parameter(description = "ID do proprietário") @PathVariable Long id) {
        return ResponseEntity.ok(proprietarioService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar proprietário")
    @PutMapping("/{id}")
    public ResponseEntity<ProprietarioResponseDTO> atualizar(
            @Parameter(description = "ID do proprietário") @PathVariable Long id,
            @RequestBody ProprietarioRequestDTO request) {
        return ResponseEntity.ok(proprietarioService.atualizar(id, request));
    }

    @Operation(summary = "Deletar proprietário")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do proprietário") @PathVariable Long id) {
        proprietarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
