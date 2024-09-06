package edu.es.eoi.marketplace.controller;

import edu.es.eoi.marketplace.dto.PedidosDto;
import edu.es.eoi.marketplace.service.PedidosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marketplace/pedidos")
public class PedidosController {

    private final PedidosService pedidoService;

    public PedidosController(PedidosService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidosDto> findById(@PathVariable Integer id) {
        PedidosDto pedido = pedidoService.findById(id);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{nombreparcial}/nombre")
    public ResponseEntity<List<PedidosDto>> findByNombre(@PathVariable String nombreparcial) {
        List<PedidosDto> pedidos = pedidoService.findByNombre(nombreparcial);
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PedidosDto> create(@RequestBody PedidosDto pedidoDto) {
    	PedidosDto createdPedido = pedidoService.create(pedidoDto);
        return ResponseEntity.ok(createdPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidosDto> update(@PathVariable Integer id, @RequestBody PedidosDto pedidoDto) {
    	PedidosDto updatedPedido = pedidoService.update(id, pedidoDto);
        return ResponseEntity.ok(updatedPedido);
    }

}
