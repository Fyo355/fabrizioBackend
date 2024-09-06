package edu.es.eoi.marketplace.controller;

import edu.es.eoi.marketplace.dto.ArticulosDto;
import edu.es.eoi.marketplace.service.ArticulosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marketplace/articulos")
public class ArticulosController {

    private final ArticulosService articuloService;

    public ArticulosController(ArticulosService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/{nombreparcial}/nombre")
    public ResponseEntity<List<ArticulosDto>> findByNombre(@PathVariable String nombreparcial) {
        List<ArticulosDto> articulos = articuloService.findByNombre(nombreparcial);
        return ResponseEntity.ok(articulos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticulosDto> findById(@PathVariable Integer id) {
        ArticulosDto articulo = articuloService.findById(id);
        return ResponseEntity.ok(articulo);
    }

    @PostMapping
    public ResponseEntity<ArticulosDto> create(@RequestBody ArticulosDto articuloDto) {
        ArticulosDto createdArticulo = articuloService.create(articuloDto);
        return ResponseEntity.ok(createdArticulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticulosDto> update(@PathVariable Integer id, @RequestBody ArticulosDto articuloDto) {
        ArticulosDto updatedArticulo = articuloService.update(id, articuloDto);
        return ResponseEntity.ok(updatedArticulo);
    }

}
