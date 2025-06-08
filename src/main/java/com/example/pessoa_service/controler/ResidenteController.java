package com.example.pessoa_service.controler;

import com.example.pessoa_service.dto.ResidenteRequestDTO;
import com.example.pessoa_service.dto.ResidenteResponseDTO;
import com.example.pessoa_service.service.ResidenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residentes")
@Tag(name = "Residentes", description = "Gerenciamento de residentes")
public class ResidenteController {

    private final ResidenteService residenteService;

    public ResidenteController(ResidenteService residenteService) {
        this.residenteService = residenteService;
    }

    @Operation(summary = "Criar residente", description = "Cria um novo residente vinculado a um imóvel.")
    @PostMapping
    public ResponseEntity<ResidenteResponseDTO> criar(@RequestBody ResidenteRequestDTO request) {
        return ResponseEntity.ok(residenteService.criarResidente(request));
    }

    @Operation(summary = "Listar todos os residentes")
    @GetMapping
    public ResponseEntity<List<ResidenteResponseDTO>> listarTodos() {
        return ResponseEntity.ok(residenteService.listarTodos());
    }

    @Operation(summary = "Buscar residente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ResidenteResponseDTO> buscarPorId(
            @Parameter(description = "ID do residente") @PathVariable Long id) {
        return ResponseEntity.ok(residenteService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar residente")
    @PutMapping("/{id}")
    public ResponseEntity<ResidenteResponseDTO> atualizar(
            @Parameter(description = "ID do residente") @PathVariable Long id,
            @RequestBody ResidenteRequestDTO request) {
        return ResponseEntity.ok(residenteService.atualizar(id, request));
    }

    @Operation(summary = "Deletar residente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do residente") @PathVariable Long id) {
        residenteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
