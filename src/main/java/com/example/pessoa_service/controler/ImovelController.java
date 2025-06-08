package com.example.pessoa_service.controler;

import com.example.pessoa_service.dto.ImovelRequestDTO;
import com.example.pessoa_service.dto.ImovelResponseDTO;
import com.example.pessoa_service.service.ImovelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
@Tag(name = "Imóveis", description = "Gerenciamento de imóveis")
public class ImovelController {

    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @Operation(summary = "Criar imóvel", description = "Cria um novo imóvel e vincula a um proprietário.")
    @PostMapping
    public ResponseEntity<ImovelResponseDTO> criar(@RequestBody ImovelRequestDTO request) {
        return ResponseEntity.ok(imovelService.criar(request));
    }

    @Operation(summary = "Listar todos os imóveis")
    @GetMapping
    public ResponseEntity<List<ImovelResponseDTO>> listarTodos() {
        return ResponseEntity.ok(imovelService.listarTodos());
    }

    @Operation(summary = "Buscar imóvel por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ImovelResponseDTO> buscarPorId(
            @Parameter(description = "ID do imóvel") @PathVariable Long id) {
        return ResponseEntity.ok(imovelService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar imóvel")
    @PutMapping("/{id}")
    public ResponseEntity<ImovelResponseDTO> atualizar(
            @Parameter(description = "ID do imóvel") @PathVariable Long id,
            @RequestBody ImovelRequestDTO request) {
        return ResponseEntity.ok(imovelService.atualizar(id, request));
    }

    @Operation(summary = "Deletar imóvel")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do imóvel") @PathVariable Long id) {
        imovelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
